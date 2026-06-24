package com.finance.assistant.domain.model.alert

sealed class CaseCause {
    abstract val id: String
    abstract val title: String
    abstract val description: String

    data class SubscriptionCause(
        override val id: String = "subscription",
        override val title: String = "Подписки",
        override val description: String = "Неиспользуемые подписки",
    ) : CaseCause()

    data class KindergartenCause(
        override val id: String = "kindergarten",
        override val title: String = "Оплата садика",
        override val description: String = "Регулярная оплата детского сада",
    ) : CaseCause()

    data class UtilityCause(
        override val id: String = "utility",
        override val title: String = "Коммунальные услуги",
        override val description: String = "Платежи за ЖКХ",
    ) : CaseCause()

    data class LoanCause(
        override val id: String = "loan",
        override val title: String = "Кредит/Рассрочка",
        override val description: String = "Платежи по кредитам",
    ) : CaseCause()

    data class OtherCause(
        override val id: String = "other",
        override val title: String = "Другое",
        override val description: String = "Прочие расходы",
        val customDescription: String = "",
    ) : CaseCause()
}

sealed class CaseResolution {
    abstract val id: String
    abstract val title: String
    abstract val description: String
    abstract val recommendedFor: List<String>

    data class RescheduleResolution(
        override val id: String = "reschedule",
        override val title: String,
        override val description: String,
        override val recommendedFor: List<String> = listOf("kindergarten", "utility"),
        val newDate: String? = null,
    ) : CaseResolution()

    data class UseSavingsResolution(
        override val id: String = "use_savings",
        override val title: String = "Использовать накопления",
        override val description: String = "Перевести средства из резервного фонда",
        override val recommendedFor: List<String> = listOf("other", "kindergarten"),
    ) : CaseResolution()

    data class CreditLimitResolution(
        override val id: String = "credit_limit",
        override val title: String = "Короткий лимит до зарплаты",
        override val description: String,
        override val recommendedFor: List<String> = listOf("other"),
        val limitAmount: Double,
    ) : CaseResolution()

    data class CancelSubscriptionResolution(
        override val id: String = "cancel_subscription",
        override val title: String = "Отменить подписку",
        override val description: String = "Отписаться от неиспользуемого сервиса",
        override val recommendedFor: List<String> = listOf("subscription"),
    ) : CaseResolution()

    data class ReduceExpenseResolution(
        override val id: String = "reduce_expense",
        override val title: String = "Сократить расходы",
        override val description: String = "Найти более бюджетную альтернативу",
        override val recommendedFor: List<String> = listOf("other", "utility"),
    ) : CaseResolution()
}

data class SavingsRecommendation(
    val suggestedDailyAmount: Double,
    val suggestedWeeklyAmount: Double,
    val suggestedMonthlyAmount: Double,
    val totalToSave: Double,
    val daysUntilExpense: Int,
    val recommendationText: String,
    val riskLevel: RiskLevel,
)

enum class RiskLevel {
    LOW, MEDIUM, HIGH
}
