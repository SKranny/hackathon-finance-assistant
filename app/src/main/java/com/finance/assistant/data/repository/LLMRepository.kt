package com.finance.assistant.data.repository

import com.finance.assistant.data.remote.LLMInsightsResponse
import com.finance.assistant.data.remote.OllamaApiService
import com.finance.assistant.data.remote.OllamaGenerateRequest
import com.finance.assistant.data.remote.OllamaOptions
import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import kotlinx.coroutines.flow.flowOn
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

interface LLMRepository {
    suspend fun generateText(prompt: String, temperature: Float = 0.7f): Result<String>
    suspend fun generateStructuredJson(
        prompt: String,
        temperature: Float = 0.3f
    ): Result<LLMInsightsResponse>
    fun generateStream(prompt: String, temperature: Float = 0.7f): Flow<String>
    suspend fun isAvailable(): Boolean
}

@Singleton
class OllamaLLMRepository @Inject constructor(
    private val apiService: OllamaApiService,
    private val gson: Gson,
    @Named("ollama_model") private val modelName: String,
) : LLMRepository {

    override suspend fun generateText(prompt: String, temperature: Float): Result<String> {
        val request = OllamaGenerateRequest(
            model = modelName,
            prompt = prompt,
            stream = false,
            options = OllamaOptions(
                temperature = temperature,
                numPredict = 512,
            ),
        )

        return apiService.generate(request).map { it.response.trim() }
    }

    override suspend fun generateStructuredJson(
        prompt: String,
        temperature: Float,
    ): Result<LLMInsightsResponse> {
        val request = OllamaGenerateRequest(
            model = modelName,
            prompt = prompt,
            stream = false,
            options = OllamaOptions(
                temperature = temperature,
                numPredict = 1024,
            ),
            format = "json",
        )

        return apiService.generate(request).mapCatching { response ->
            val cleanedResponse = cleanJsonResponse(response.response)
            gson.fromJson(cleanedResponse, LLMInsightsResponse::class.java)
        }
    }

    override fun generateStream(prompt: String, temperature: Float): Flow<String> = flow {
        val request = OllamaGenerateRequest(
            model = modelName,
            prompt = prompt,
            stream = true,
            options = OllamaOptions(
                temperature = temperature,
                numPredict = 512,
            ),
        )

        val result = apiService.generate(request)
        result.getOrNull()?.let { emit(it.response) }
    }.flowOn(Dispatchers.IO)

    override suspend fun isAvailable(): Boolean {
        return runCatching {
            apiService.isModelAvailable(modelName)
        }.getOrDefault(false)
    }

    private fun cleanJsonResponse(response: String): String {
        var cleaned = response.trim()
        if (cleaned.startsWith("```json")) {
            cleaned = cleaned.removePrefix("```json").removePrefix("```")
        } else if (cleaned.startsWith("```")) {
            cleaned = cleaned.removePrefix("```")
        }
        if (cleaned.endsWith("```")) {
            cleaned = cleaned.removeSuffix("```")
        }
        return cleaned.trim()
    }
}
