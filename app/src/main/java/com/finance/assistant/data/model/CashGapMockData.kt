package com.finance.assistant.data.model

import com.google.gson.annotations.SerializedName

data class CashGapMockData(
    @SerializedName("header") val header: CashGapHeader,
    @SerializedName("alertCard") val alertCard: CashGapAlertCard,
    @SerializedName("expenses") val expenses: List<CashGapExpense>,
    @SerializedName("suggestionsHeader") val suggestionsHeader: String,
    @SerializedName("suggestions") val suggestions: List<CashGapSuggestion>,
    @SerializedName("primaryAction") val primaryAction: CashGapPrimaryAction,
)

data class CashGapHeader(
    @SerializedName("title") val title: String,
)

data class CashGapAlertCard(
    @SerializedName("dateLabel") val dateLabel: String,
    @SerializedName("description") val description: String,
)

data class CashGapExpense(
    @SerializedName("id") val id: Long,
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("amountColor") val amountColor: String,
)

data class CashGapSuggestion(
    @SerializedName("id") val id: Long,
    @SerializedName("isRecommended") val isRecommended: Boolean,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
)

data class CashGapPrimaryAction(
    @SerializedName("label") val label: String,
)
