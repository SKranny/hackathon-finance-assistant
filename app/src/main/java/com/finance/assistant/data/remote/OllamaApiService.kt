package com.finance.assistant.data.remote

import com.google.gson.Gson
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import okhttp3.MediaType.Companion.toMediaType
import okhttp3.OkHttpClient
import okhttp3.Request
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import javax.inject.Inject
import javax.inject.Named
import javax.inject.Singleton

interface OllamaApiService {
    suspend fun generate(request: OllamaGenerateRequest): Result<OllamaResponse>
    suspend fun chat(request: OllamaChatRequest): Result<OllamaChatResponse>
    suspend fun listModels(): Result<OllamaModelsResponse>
    suspend fun isModelAvailable(modelName: String = "gemma4"): Boolean
}

@Singleton
class OllamaApiServiceImpl @Inject constructor(
    private val okHttpClient: OkHttpClient,
    @Named("ollama_base_url") private val baseUrl: String,
    private val gson: Gson,
) : OllamaApiService {

    companion object {
        private const val API_GENERATE = "/api/generate"
        private const val API_CHAT = "/api/chat"
        private const val API_TAGS = "/api/tags"
        private val JSON_MEDIA_TYPE = "application/json; charset=utf-8".toMediaType()
    }

    override suspend fun generate(request: OllamaGenerateRequest): Result<OllamaResponse> = 
        withContext(Dispatchers.IO) {
            runCatching {
                val jsonBody = gson.toJson(request)
                val requestBody = jsonBody.toRequestBody(JSON_MEDIA_TYPE)
                
                val httpRequest = Request.Builder()
                    .url("$baseUrl$API_GENERATE")
                    .post(requestBody)
                    .build()

                val response = okHttpClient.newCall(httpRequest).execute()
                
                if (!response.isSuccessful) {
                    throw IOException("Ollama API error: ${response.code} - ${response.message}")
                }

                val responseBody = response.body?.string()
                    ?: throw IOException("Empty response from Ollama")

                gson.fromJson(responseBody, OllamaResponse::class.java)
            }
        }

    override suspend fun chat(request: OllamaChatRequest): Result<OllamaChatResponse> = 
        withContext(Dispatchers.IO) {
            runCatching {
                val jsonBody = gson.toJson(request)
                val requestBody = jsonBody.toRequestBody(JSON_MEDIA_TYPE)
                
                val httpRequest = Request.Builder()
                    .url("$baseUrl$API_CHAT")
                    .post(requestBody)
                    .build()

                val response = okHttpClient.newCall(httpRequest).execute()
                
                if (!response.isSuccessful) {
                    throw IOException("Ollama API error: ${response.code} - ${response.message}")
                }

                val responseBody = response.body?.string()
                    ?: throw IOException("Empty response from Ollama")

                gson.fromJson(responseBody, OllamaChatResponse::class.java)
            }
        }

    override suspend fun listModels(): Result<OllamaModelsResponse> = 
        withContext(Dispatchers.IO) {
            runCatching {
                val request = Request.Builder()
                    .url("$baseUrl$API_TAGS")
                    .get()
                    .build()

                val response = okHttpClient.newCall(request).execute()
                
                if (!response.isSuccessful) {
                    throw IOException("Ollama API error: ${response.code}")
                }

                val responseBody = response.body?.string()
                    ?: throw IOException("Empty response from Ollama")

                gson.fromJson(responseBody, OllamaModelsResponse::class.java)
            }
        }

    override suspend fun isModelAvailable(modelName: String): Boolean = 
        listModels().getOrNull()?.models?.any { it.name.startsWith(modelName) } ?: false
}
