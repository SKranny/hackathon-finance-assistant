package com.finance.assistant.domain.model

import java.time.LocalDate

data class FinancialInsight(
    val id: Long = 0,
    val type: InsightType,
    val title: String,
    val description: String,
    val severity: InsightSeverity,
    val date: LocalDate,
    val relatedAmount: Double? = null,
    val isRead: Boolean = false,
)

enum class InsightType {
    UPCOMING_EXPENSE,
    PAYMENT_DUE,
    CASH_GAP,
    LARGE_PURCHASE,
    BUDGET_OVERAGE,
    SUBSCRIPTION_RENEWAL,
}

enum class InsightSeverity {
    INFO, WARNING, CRITICAL,
}
