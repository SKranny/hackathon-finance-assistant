package com.finance.assistant.data.repository

import android.content.Context
import com.finance.assistant.data.model.ForecastMockData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ForecastDataRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
) {
    private var cachedData: ForecastMockData? = null

    suspend fun getForecastData(): ForecastMockData {
        return cachedData ?: loadFromAssets().also { cachedData = it }
    }

    private suspend fun loadFromAssets(): ForecastMockData = withContext(Dispatchers.IO) {
        val json = context.assets.open("forecast_mock_data.json")
            .bufferedReader()
            .use { it.readText() }
        gson.fromJson(json, ForecastMockData::class.java)
    }
}
