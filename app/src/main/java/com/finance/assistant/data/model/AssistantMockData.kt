package com.finance.assistant.data.model

import com.google.gson.annotations.SerializedName

data class AssistantMockData(
    @SerializedName("greeting") val greeting: String,
    @SerializedName("context") val context: AssistantContextData,
    @SerializedName("responses") val responses: Map<String, AssistantResponseData>,
)

data class AssistantContextData(
    @SerializedName("currentBalance") val currentBalance: Double,
    @SerializedName("monthlyIncome") val monthlyIncome: Double,
    @SerializedName("monthlyExpenses") val monthlyExpenses: Double,
    @SerializedName("upcomingExpensesCount") val upcomingExpensesCount: Int,
    @SerializedName("activeCasesCount") val activeCasesCount: Int,
    @SerializedName("nextSalaryDate") val nextSalaryDate: String,
    @SerializedName("currentDate") val currentDate: String,
)

data class AssistantResponseData(
    @SerializedName("answer") val answer: String,
    @SerializedName("actions") val actions: List<AssistantActionData>,
)

data class AssistantActionData(
    @SerializedName("title") val title: String,
    @SerializedName("type") val type: String,
)
