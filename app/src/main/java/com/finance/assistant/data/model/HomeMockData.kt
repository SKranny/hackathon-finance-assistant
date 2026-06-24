package com.finance.assistant.data.model

import com.google.gson.annotations.SerializedName

data class HomeMockData(
    @SerializedName("user") val user: UserData,
    @SerializedName("balance") val balance: BalanceData,
    @SerializedName("cashGapAlert") val cashGapAlert: CashGapAlertData,
    @SerializedName("upcomingEvents") val upcomingEvents: List<UpcomingEventData>,
    @SerializedName("summary") val summary: SummaryData,
)

data class UserData(
    @SerializedName("name") val name: String,
    @SerializedName("avatarInitial") val avatarInitial: String,
)

data class BalanceData(
    @SerializedName("freeBalance") val freeBalance: Double,
    @SerializedName("currency") val currency: String,
    @SerializedName("shortfallAmount") val shortfallAmount: Double?,
    @SerializedName("shortfallDays") val shortfallDays: Int?,
    @SerializedName("shortfallDate") val shortfallDate: String?,
)

data class CashGapAlertData(
    @SerializedName("title") val title: String,
    @SerializedName("body") val body: String,
    @SerializedName("isVisible") val isVisible: Boolean,
)

data class UpcomingEventData(
    @SerializedName("id") val id: Long,
    @SerializedName("date") val date: String,
    @SerializedName("source") val source: String,
    @SerializedName("title") val title: String,
    @SerializedName("amount") val amount: Double,
    @SerializedName("isDangerBorder") val isDangerBorder: Boolean,
    @SerializedName("colorType") val colorType: String,
)

data class SummaryData(
    @SerializedName("totalIncome") val totalIncome: Double,
    @SerializedName("totalExpenses") val totalExpenses: Double,
)
