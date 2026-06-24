package com.finance.assistant.data.repository

import android.content.Context
import com.finance.assistant.data.model.CashGapMockData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CashGapDataRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
) {
    private var cachedData: CashGapMockData? = null

    suspend fun getCashGapData(): CashGapMockData {
        return cachedData ?: loadFromAssets().also { cachedData = it }
    }

    private suspend fun loadFromAssets(): CashGapMockData = withContext(Dispatchers.IO) {
        val json = context.assets.open("cash_gap_mock_data.json")
            .bufferedReader()
            .use { it.readText() }
        gson.fromJson(json, CashGapMockData::class.java)
    }
}
