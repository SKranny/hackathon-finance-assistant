package com.finance.assistant.domain.model.expense

import java.time.LocalDate

data class RecurringExpense(
    val id: Long = 0,
    val title: String,
    val amount: Double,
    val category: String,
    val description: String = "",
    val frequency: RecurringFrequency = RecurringFrequency.MONTHLY,
    val startDate: LocalDate,
    val lastPaidDate: LocalDate? = null,
    val nextPaymentDate: LocalDate,
    val isActive: Boolean = true,
    val source: ExpenseSource = ExpenseSource.MANUAL,
)

enum class RecurringFrequency {
    DAILY, WEEKLY, MONTHLY, QUARTERLY, YEARLY;

    fun getDaysInterval(): Long = when (this) {
        DAILY -> 1
        WEEKLY -> 7
        MONTHLY -> 30
        QUARTERLY -> 90
        YEARLY -> 365
    }

    fun calculateNextDate(from: LocalDate): LocalDate = when (this) {
        DAILY -> from.plusDays(1)
        WEEKLY -> from.plusWeeks(1)
        MONTHLY -> from.plusMonths(1)
        QUARTERLY -> from.plusMonths(3)
        YEARLY -> from.plusYears(1)
    }
}
