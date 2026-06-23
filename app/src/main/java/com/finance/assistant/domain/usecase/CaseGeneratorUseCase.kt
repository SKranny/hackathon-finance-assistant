package com.finance.assistant.domain.usecase

import com.finance.assistant.data.repository.CaseRepository
import com.finance.assistant.data.repository.ExpenseRepository
import com.finance.assistant.data.repository.UserRepository
import com.finance.assistant.domain.model.case.CaseSeverity
import com.finance.assistant.domain.model.case.CashGapCase
import com.finance.assistant.domain.model.case.FinanceCase
import com.finance.assistant.domain.model.case.ScheduledExpenseCase
import com.finance.assistant.domain.model.case.SubscriptionAction
import com.finance.assistant.domain.model.case.ZombieSubscriptionCase
import com.finance.assistant.domain.model.expense.RecurringExpense
import com.finance.assistant.domain.model.expense.RecurringFrequency
import com.finance.assistant.domain.model.expense.UpcomingExpense
import com.finance.assistant.domain.model.profile.UserProfile
import com.finance.assistant.domain.model.profile.getDaysUntilSalary
import com.finance.assistant.domain.model.profile.getFreeMoneyBeforeSalary
import kotlinx.coroutines.flow.first
import java.time.LocalDate
import java.time.temporal.ChronoUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CaseGeneratorUseCase @Inject constructor(
    private val userRepository: UserRepository,
    private val expenseRepository: ExpenseRepository,
    private val caseRepository: CaseRepository,
) {

    suspend fun generateAllCases(): List<FinanceCase> {
        val cases = mutableListOf<FinanceCase>()

        val profile = userRepository.getProfile()
        val upcomingExpenses = expenseRepository.getUpcomingExpenses().first()
        val recurringExpenses = expenseRepository.getActiveRecurringExpenses().first()

        val cashGap = detectCashGap(profile, upcomingExpenses, recurringExpenses)
        cashGap?.let { cases.add(it) }

        val zombieSubscriptions = detectZombieSubscriptions(recurringExpenses)
        cases.addAll(zombieSubscriptions)

        val scheduledExpenses = upcomingExpenses.take(10)
        cases.addAll(scheduledExpenses)

        return cases
    }

    suspend fun saveGeneratedCases() {
        val cases = generateAllCases()

        cases.forEach { case ->
            val (caseType, additionalData) = when (case) {
                is CashGapCase -> "CASH_GAP" to CaseRepository.createAdditionalData(
                    "gapAmount" to case.gapAmount.toString(),
                    "daysUntilSalary" to case.daysUntilSalary.toString(),
                    "recommendedSavingsPerDay" to case.recommendedSavingsPerDay.toString(),
                    "affectedExpenses" to case.affectedExpenses.joinToString(","),
                )
                is ZombieSubscriptionCase -> "ZOMBIE_SUBSCRIPTION" to CaseRepository.createAdditionalData(
                    "daysSinceLastUsage" to case.daysSinceLastUsage.toString(),
                    "suggestedAction" to case.suggestedAction.name,
                )
                is ScheduledExpenseCase -> "SCHEDULED_EXPENSE" to CaseRepository.createAdditionalData(
                    "category" to case.category,
                    "source" to case.source,
                    "isRecurring" to case.isRecurring.toString(),
                )
                else -> "EXPENSE" to ""
            }

            caseRepository.saveCase(
                severity = case.severity,
                title = case.title,
                description = case.description,
                dueDate = case.dueDate,
                amount = case.amount,
                caseType = caseType,
                additionalData = additionalData,
            )
        }
    }

    private fun detectCashGap(
        profile: UserProfile?,
        upcomingExpenses: List<UpcomingExpense>,
        recurringExpenses: List<RecurringExpense>,
    ): CashGapCase? {
        if (profile == null) return null

        val today = LocalDate.now()
        val daysUntilSalary = profile.getDaysUntilSalary()
        val freeMoney = profile.getFreeMoneyBeforeSalary()

        val upcomingTotal = upcomingExpenses
            .filter { !it.isPaid }
            .sumOf { it.amount }

        val recurringTotal = recurringExpenses
            .filter { it.isActive }
            .sumOf { it.amount }

        val projectedExpenses = upcomingTotal + (recurringTotal / 30 * daysUntilSalary)

        if (projectedExpenses > freeMoney && freeMoney > 0) {
            val gapAmount = projectedExpenses - freeMoney
            val recommendedSavings = gapAmount / daysUntilSalary.coerceAtLeast(1)

            return CashGapCase(
                title = "Кассовый разрыв",
                description = "До зарплаты осталось $daysUntilSalary дней. Необходимо ${formatMoney(gapAmount)} ₽",
                dueDate = profile.nextSalaryDate,
                amount = gapAmount,
                severity = CaseSeverity.CRITICAL,
                gapAmount = gapAmount,
                daysUntilSalary = daysUntilSalary.toInt(),
                recommendedSavingsPerDay = recommendedSavings,
                affectedExpenses = upcomingExpenses.take(3).map { it.title },
            )
        }

        return null
    }

    private fun detectZombieSubscriptions(expenses: List<RecurringExpense>): List<ZombieSubscriptionCase> {
        val today = LocalDate.now()

        return expenses
            .filter { expense ->
                val daysSinceLastUsage = expense.lastPaidDate?.let {
                    ChronoUnit.DAYS.between(it, today).toInt()
                } ?: 0

                val unusedThreshold = when (expense.frequency) {
                    RecurringFrequency.DAILY -> 7
                    RecurringFrequency.WEEKLY -> 30
                    RecurringFrequency.MONTHLY -> 90
                    RecurringFrequency.QUARTERLY -> 180
                    RecurringFrequency.YEARLY -> 365
                }

                daysSinceLastUsage > unusedThreshold
            }
            .map { subscription ->
                val daysUnused = subscription.lastPaidDate?.let {
                    ChronoUnit.DAYS.between(it, today).toInt()
                } ?: 0

                ZombieSubscriptionCase(
                    title = "Зомби-подписка: ${subscription.title}",
                    description = "Не используется $daysUnused дней",
                    dueDate = subscription.nextPaymentDate,
                    amount = subscription.amount,
                    severity = CaseSeverity.WARNING,
                    monthlyAmount = subscription.amount,
                    lastUsageDate = subscription.lastPaidDate,
                    daysSinceLastUsage = daysUnused,
                    yearlyCost = subscription.amount * 12,
                    suggestedAction = if (daysUnused > 365) SubscriptionAction.CANCEL else SubscriptionAction.INVESTIGATE,
                )
            }
    }
}

private fun formatMoney(amount: Double): String {
    return "%,.2f".format(amount).replace(",", " ")
}
