package com.finance.assistant.data.repository

import android.content.Context
import com.finance.assistant.data.model.PaymentConfirmationMockData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class PaymentConfirmationDataRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
) {
    private var cachedData: PaymentConfirmationMockData? = null

    suspend fun getPaymentConfirmationData(): PaymentConfirmationMockData {
        return cachedData ?: loadFromAssets().also { cachedData = it }
    }

    private suspend fun loadFromAssets(): PaymentConfirmationMockData = withContext(Dispatchers.IO) {
        val json = context.assets.open("payment_confirmation_mock_data.json")
            .bufferedReader()
            .use { it.readText() }
        gson.fromJson(json, PaymentConfirmationMockData::class.java)
    }
}
