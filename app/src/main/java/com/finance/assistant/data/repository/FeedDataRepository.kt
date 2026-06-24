package com.finance.assistant.data.repository

import android.content.Context
import com.finance.assistant.data.model.FeedMockData
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FeedDataRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
) {
    private var cachedData: FeedMockData? = null

    suspend fun getFeedData(): FeedMockData {
        return cachedData ?: loadFromAssets().also { cachedData = it }
    }

    private suspend fun loadFromAssets(): FeedMockData = withContext(Dispatchers.IO) {
        val json = context.assets.open("feed_mock_data.json")
            .bufferedReader()
            .use { it.readText() }
        gson.fromJson(json, FeedMockData::class.java)
    }
}
