package com.finance.assistant.data.model

import com.google.gson.annotations.SerializedName

data class ForecastMockData(
    @SerializedName("header") val header: ForecastHeader,
    @SerializedName("chart") val chart: ForecastChart,
    @SerializedName("alert") val alert: ForecastAlert,
    @SerializedName("action") val action: ForecastAction,
)

data class ForecastHeader(
    @SerializedName("title") val title: String,
)

data class ForecastChart(
    @SerializedName("title") val title: String,
    @SerializedName("minBalance") val minBalance: String,
    @SerializedName("xAxisLabels") val xAxisLabels: List<String>,
    @SerializedName("gapLabel") val gapLabel: String,
    @SerializedName("salaryLabel") val salaryLabel: String,
)

data class ForecastAlert(
    @SerializedName("minBalanceLabel") val minBalanceLabel: String,
    @SerializedName("minBalanceValue") val minBalanceValue: String,
    @SerializedName("description") val description: String,
)

data class ForecastAction(
    @SerializedName("label") val label: String,
)
