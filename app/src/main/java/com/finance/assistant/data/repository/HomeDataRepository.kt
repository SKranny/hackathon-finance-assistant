package com.finance.assistant.data.repository

import android.content.Context
import com.finance.assistant.data.model.HomeMockData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class HomeDataRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
) {
    private var cachedData: HomeMockData? = null

    suspend fun getHomeData(): HomeMockData {
        return cachedData ?: loadFromAssets().also { cachedData = it }
    }

    private suspend fun loadFromAssets(): HomeMockData = withContext(Dispatchers.IO) {
        val json = context.assets.open("home_mock_data.json")
            .bufferedReader()
            .use { it.readText() }
        gson.fromJson(json, HomeMockData::class.java)
    }
}
