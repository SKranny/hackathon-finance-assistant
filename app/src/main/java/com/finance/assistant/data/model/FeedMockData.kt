package com.finance.assistant.data.model

import com.google.gson.annotations.SerializedName

data class FeedMockData(
    @SerializedName("header") val header: FeedHeader,
    @SerializedName("insights") val insights: List<InsightData>,
)

data class FeedHeader(
    @SerializedName("title") val title: String,
    @SerializedName("subtitle") val subtitle: String,
)

data class InsightData(
    @SerializedName("id") val id: Long,
    @SerializedName("caseNumber") val caseNumber: Int,
    @SerializedName("type") val type: String,
    @SerializedName("label") val label: String,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("severity") val severity: String,
)

enum class InsightSeverity {
    CRITICAL, WARNING, INFO
}
