package com.finance.assistant.domain.model.case

import java.time.LocalDate

sealed class FinanceCase {
    abstract val id: Long
    abstract val title: String
    abstract val description: String
    abstract val dueDate: LocalDate?
    abstract val amount: Double
    abstract val severity: CaseSeverity
    abstract val isResolved: Boolean
}

data class CashGapCase(
    override val id: Long = 0,
    override val title: String,
    override val description: String,
    override val dueDate: LocalDate,
    override val amount: Double,
    override val severity: CaseSeverity = CaseSeverity.CRITICAL,
    override val isResolved: Boolean = false,
    val gapAmount: Double,
    val daysUntilSalary: Int,
    val recommendedSavingsPerDay: Double,
    val affectedExpenses: List<String> = emptyList(),
) : FinanceCase()

data class ZombieSubscriptionCase(
    override val id: Long = 0,
    override val title: String,
    override val description: String,
    override val dueDate: LocalDate? = null,
    override val amount: Double,
    override val severity: CaseSeverity = CaseSeverity.WARNING,
    override val isResolved: Boolean = false,
    val monthlyAmount: Double,
    val lastUsageDate: LocalDate?,
    val daysSinceLastUsage: Int,
    val yearlyCost: Double,
    val suggestedAction: SubscriptionAction,
) : FinanceCase()

data class ScheduledExpenseCase(
    override val id: Long = 0,
    override val title: String,
    override val description: String,
    override val dueDate: LocalDate,
    override val amount: Double,
    override val severity: CaseSeverity = CaseSeverity.INFO,
    override val isResolved: Boolean = false,
    val category: String,
    val source: String,
    val isRecurring: Boolean = false,
    val suggestedAmount: Double? = null,
) : FinanceCase()

data class IncomeCase(
    override val id: Long = 0,
    override val title: String,
    override val description: String,
    override val dueDate: LocalDate,
    override val amount: Double,
    override val severity: CaseSeverity = CaseSeverity.INFO,
    override val isResolved: Boolean = false,
    val source: String,
) : FinanceCase()

enum class CaseSeverity {
    CRITICAL, WARNING, INFO
}

enum class SubscriptionAction {
    CANCEL, KEEP, REDUCE, INVESTIGATE
}
