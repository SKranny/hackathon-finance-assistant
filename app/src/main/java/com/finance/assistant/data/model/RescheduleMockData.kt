package com.finance.assistant.data.model

import com.google.gson.annotations.SerializedName

data class RescheduleMockData(
    @SerializedName("header") val header: RescheduleHeader,
    @SerializedName("dateReschedule") val dateReschedule: DateReschedule,
    @SerializedName("payment") val payment: ReschedulePayment,
    @SerializedName("infoMessage") val infoMessage: String,
    @SerializedName("confirmButton") val confirmButton: RescheduleConfirmButton,
)

data class RescheduleHeader(
    @SerializedName("title") val title: String,
)

data class DateReschedule(
    @SerializedName("originalDate") val originalDate: String,
    @SerializedName("newDate") val newDate: String,
    @SerializedName("originalDateLabel") val originalDateLabel: String,
    @SerializedName("newDateLabel") val newDateLabel: String,
)

data class ReschedulePayment(
    @SerializedName("name") val name: String,
    @SerializedName("amount") val amount: String,
    @SerializedName("account") val account: String,
    @SerializedName("overpayment") val overpayment: String,
)

data class RescheduleConfirmButton(
    @SerializedName("label") val label: String,
)
