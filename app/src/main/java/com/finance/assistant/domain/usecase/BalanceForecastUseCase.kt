package com.finance.assistant.domain.usecase

import com.finance.assistant.data.repository.ExpenseRepository
import com.finance.assistant.data.repository.UserRepository
import com.finance.assistant.domain.model.expense.UpcomingExpense
import com.finance.assistant.domain.model.forecast.BalanceEvent
import com.finance.assistant.domain.model.forecast.BalanceForecast
import com.finance.assistant.domain.model.forecast.CashGapWarning
import com.finance.assistant.domain.model.forecast.EventType
import com.finance.assistant.domain.model.forecast.ForecastPoint
import com.finance.assistant.domain.model.forecast.GapClosureMethod
import com.finance.assistant.domain.model.forecast.GapClosureSuggestion
import com.finance.assistant.domain.model.forecast.SalaryDate
import com.finance.assistant.domain.model.profile.UserProfile
import kotlinx.coroutines.flow.first
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class BalanceForecastUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val expenseRepository: ExpenseRepository,
) {

    suspend fun calculateForecast(daysAhead: Int = 30): BalanceForecast {
        val profile = userRepository.getProfile()
        val upcomingExpenses = expenseRepository.getUpcomingExpensesForDays(daysAhead).first()

        val today = LocalDate.now()
        val forecastEndDate = today.plusDays(daysAhead.toLong())

        val salaryDates = profile?.let { calculateSalaryDates(it, forecastEndDate) } ?: emptyList()
        val forecastPoints = calculateForecastPoints(profile, upcomingExpenses, salaryDates, today, forecastEndDate)
        val negativeBalanceInfo = findNegativeBalanceDate(forecastPoints)

        val gapWarning = negativeBalanceInfo?.let {
            CashGapWarning(
                date = it.first,
                amount = kotlin.math.abs(it.second),
                reason = "Накопленные расходы превышают доходы",
                daysUntilSalary = ChronoUnit.DAYS.between(today, it.first).toInt(),
                suggestedSolution = "Рекомендуется отложить ${kotlin.math.abs(it.second)} ₽"
            )
        }

        val recommendations = generateRecommendations(forecastPoints, profile)

        return BalanceForecast(
            currentBalance = profile?.balance ?: 0.0,
            salaryDates = salaryDates,
            forecastPoints = forecastPoints,
            negativeBalanceDate = negativeBalanceInfo?.first,
            negativeBalanceReason = negativeBalanceInfo?.let { "Расходы: ${getTotalExpensesForDate(forecastPoints, it.first)} ₽" },
            cashGapWarning = gapWarning,
            recommendations = recommendations,
        )
    }

    suspend fun calculateGapClosure(amount: Double, daysAvailable: Int): GapClosureSuggestion {
        val upcomingExpenses = expenseRepository.getUpcomingExpensesForDays(daysAvailable).first()

        val methods = mutableListOf<GapClosureMethod>()

        val deferrableExpenses = upcomingExpenses.filter { !it.isPaid && it.amount <= amount * 0.5 }
        for (expense in deferrableExpenses.take(3)) {
            methods.add(GapClosureMethod.DelayExpense(
                expenseTitle = expense.title,
                amount = expense.amount,
                newDate = expense.dueDate.plusWeeks(1)
            ))
        }

        val reducibleExpenses = upcomingExpenses.filter { it.amount > 1000 }
        for (expense in reducibleExpenses.take(2)) {
            methods.add(GapClosureMethod.ReduceExpense(
                expenseTitle = expense.title,
                originalAmount = expense.amount,
                reducedAmount = expense.amount * 0.7
            ))
        }

        val monthlySavings = amount / (daysAvailable / 30.0)
        if (monthlySavings > 0) {
            methods.add(GapClosureMethod.SavingsPlan(
                monthlySavings = monthlySavings,
                monthsToAccumulate = (daysAvailable / 30.0).toInt().coerceAtLeast(1)
            ))
        }

        return GapClosureSuggestion(
            totalGapAmount = amount,
            methods = methods,
        )
    }

    private fun calculateSalaryDates(profile: UserProfile, endDate: LocalDate): List<SalaryDate> {
        val salaryDates = mutableListOf<SalaryDate>()
        var currentDate = profile.nextSalaryDate

        while (!currentDate.isAfter(endDate)) {
            if (!currentDate.isBefore(LocalDate.now())) {
                salaryDates.add(SalaryDate(
                    date = currentDate,
                    amount = profile.salary,
                    source = "SALARY"
                ))
            }
            currentDate = currentDate.plusMonths(1)
        }

        return salaryDates
    }

    private fun calculateForecastPoints(
        profile: UserProfile?,
        expenses: List<UpcomingExpense>,
        salaryDates: List<SalaryDate>,
        startDate: LocalDate,
        endDate: LocalDate,
    ): List<ForecastPoint> {
        val points = mutableListOf<ForecastPoint>()
        var runningBalance = profile?.balance ?: 0.0
        var currentDate = startDate

        while (!currentDate.isAfter(endDate)) {
            val dayExpenses = expenses.filter { it.dueDate == currentDate && !it.isPaid }
            val dayIncome = salaryDates.filter { it.date == currentDate }

            val projectedExpenses = dayExpenses.sumOf { it.amount }
            val projectedIncome = dayIncome.sumOf { it.amount }

            val events = mutableListOf<BalanceEvent>()

            dayExpenses.forEach { expense ->
                events.add(BalanceEvent(
                    date = currentDate,
                    title = expense.title,
                    amount = expense.amount,
                    isExpense = true,
                    category = expense.category,
                    type = EventType.SCHEDULED_EXPENSE,
                ))
            }

            dayIncome.forEach { salary ->
                events.add(BalanceEvent(
                    date = currentDate,
                    title = "Зарплата",
                    amount = salary.amount,
                    isExpense = false,
                    category = "INCOME",
                    type = EventType.SALARY,
                ))
            }

            runningBalance = runningBalance + projectedIncome - projectedExpenses

            points.add(ForecastPoint(
                date = currentDate,
                balance = runningBalance,
                projectedExpenses = projectedExpenses,
                projectedIncome = projectedIncome,
                events = events,
            ))

            currentDate = currentDate.plusDays(1)
        }

        return points
    }

    private fun findNegativeBalanceDate(points: List<ForecastPoint>): Pair<LocalDate, Double>? {
        return points.find { it.balance < 0 }?.let { Pair(it.date, it.balance) }
    }

    private fun getTotalExpensesForDate(points: List<ForecastPoint>, date: LocalDate): Double {
        return points.find { it.date == date }?.projectedExpenses ?: 0.0
    }

    private fun generateRecommendations(points: List<ForecastPoint>, profile: UserProfile?): List<String> {
        val recommendations = mutableListOf<String>()

        val negativePoint = points.find { it.balance < 0 }
        if (negativePoint != null) {
            val daysUntilNegative = ChronoUnit.DAYS.between(LocalDate.now(), negativePoint.date)
            recommendations.add("Через $daysUntilNegative дней баланс станет отрицательным")
        }

        val highExpenseDays = points.filter { it.projectedExpenses > (profile?.salary?.times(0.3) ?: 0.0) }
        if (highExpenseDays.isNotEmpty()) {
            recommendations.add("${highExpenseDays.size} дней с высокими расходами (>30% зарплаты)")
        }

        if (points.none { it.balance < 0 }) {
            recommendations.add("Финансовая ситуация стабильна до следующей зарплаты")
        }

        return recommendations
    }
}
