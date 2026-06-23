package com.finance.assistant.domain.model.expense

import java.time.LocalDate

data class UpcomingExpense(
    val id: Long = 0,
    val title: String,
    val amount: Double,
    val dueDate: LocalDate,
    val category: String,
    val description: String = "",
    val isPaid: Boolean = false,
    val source: ExpenseSource = ExpenseSource.MANUAL,
    val notificationSent: Boolean = false,
)

enum class ExpenseSource {
    SMS, CALENDAR, MANUAL, DOCUMENT
}
