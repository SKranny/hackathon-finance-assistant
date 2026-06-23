package com.finance.assistant.domain.model

import java.time.LocalDate

data class Transaction(
    val id: Long = 0,
    val title: String,
    val amount: Double,
    val category: TransactionCategory,
    val date: LocalDate,
    val source: TransactionSource,
    val description: String = "",
    val isRecurring: Boolean = false,
)

enum class TransactionCategory {
    FOOD, TRANSPORT, HOUSING, UTILITIES, ENTERTAINMENT,
    HEALTHCARE, EDUCATION, SHOPPING, SUBSCRIPTION, SALARY,
    TRANSFER, OTHER,
}

enum class TransactionSource {
    SMS, EMAIL, CALENDAR, MANUAL,
}
