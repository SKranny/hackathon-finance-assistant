package com.finance.assistant.data.model

import com.google.gson.annotations.SerializedName

data class PaymentConfirmationMockData(
    @SerializedName("header") val header: PaymentConfirmationHeader,
    @SerializedName("successIcon") val successIcon: SuccessIcon,
    @SerializedName("title") val title: String,
    @SerializedName("description") val description: String,
    @SerializedName("actions") val actions: PaymentConfirmationActions,
)

data class PaymentConfirmationHeader(
    @SerializedName("title") val title: String,
)

data class SuccessIcon(
    @SerializedName("symbol") val symbol: String,
)

data class PaymentConfirmationActions(
    @SerializedName("primary") val primary: String,
    @SerializedName("secondary") val secondary: String,
)
