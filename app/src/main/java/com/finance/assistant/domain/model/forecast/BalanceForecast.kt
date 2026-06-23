package com.finance.assistant.domain.model.forecast

import java.time.LocalDate

data class BalanceForecast(
    val currentBalance: Double,
    val salaryDates: List<SalaryDate>,
    val forecastPoints: List<ForecastPoint>,
    val negativeBalanceDate: LocalDate?,
    val negativeBalanceReason: String?,
    val cashGapWarning: CashGapWarning?,
    val recommendations: List<String>,
)

data class SalaryDate(
    val date: LocalDate,
    val amount: Double,
    val source: String = "SALARY",
)

data class ForecastPoint(
    val date: LocalDate,
    val balance: Double,
    val projectedExpenses: Double,
    val projectedIncome: Double,
    val events: List<BalanceEvent>,
)

data class BalanceEvent(
    val date: LocalDate,
    val title: String,
    val amount: Double,
    val isExpense: Boolean,
    val category: String,
    val type: EventType,
)

enum class EventType {
    SCHEDULED_EXPENSE,
    RECURRING_EXPENSE,
    INCOME,
    SALARY,
    SUBSCRIPTION,
}

data class CashGapWarning(
    val date: LocalDate,
    val amount: Double,
    val reason: String,
    val daysUntilSalary: Int,
    val suggestedSolution: String,
)

data class GapClosureSuggestion(
    val totalGapAmount: Double,
    val methods: List<GapClosureMethod>,
)

sealed class GapClosureMethod {
    data class DelayExpense(val expenseTitle: String, val amount: Double, val newDate: LocalDate?) : GapClosureMethod()
    data class ReduceExpense(val expenseTitle: String, val originalAmount: Double, val reducedAmount: Double) : GapClosureMethod()
    data class SavingsPlan(val monthlySavings: Double, val monthsToAccumulate: Int) : GapClosureMethod()
    data class ExtraIncome(val title: String, val amount: Double) : GapClosureMethod()
}
