package com.finance.assistant.data.remote

import com.google.gson.annotations.SerializedName

data class OllamaGenerateRequest(
    val model: String = "gemma4",
    val prompt: String,
    @SerializedName("stream")
    val stream: Boolean = false,
    val options: OllamaOptions? = null,
    val format: String? = null,
)

data class OllamaOptions(
    val temperature: Float = 0.7f,
    @SerializedName("num_predict")
    val numPredict: Int = 512,
    val top_p: Float? = null,
    val top_k: Int? = null,
)

data class OllamaResponse(
    val model: String,
    val response: String,
    @SerializedName("done")
    val done: Boolean,
    @SerializedName("total_duration")
    val totalDuration: Long? = null,
    @SerializedName("load_duration")
    val loadDuration: Long? = null,
    @SerializedName("prompt_eval_count")
    val promptEvalCount: Int? = null,
    @SerializedName("eval_count")
    val evalCount: Int? = null,
)

data class OllamaModelsResponse(
    val models: List<OllamaModel>,
)

data class OllamaModel(
    val name: String,
    val model: String,
    @SerializedName("modified_at")
    val modifiedAt: String? = null,
    val size: Long? = null,
    val digest: String? = null,
)

data class OllamaChatRequest(
    val model: String = "gemma4",
    val messages: List<OllamaMessage>,
    @SerializedName("stream")
    val stream: Boolean = false,
    val options: OllamaOptions? = null,
)

data class OllamaMessage(
    val role: String,
    val content: String,
)

data class OllamaChatResponse(
    val model: String,
    val message: OllamaMessage,
    @SerializedName("done")
    val done: Boolean,
)

data class LLMInsightsResponse(
    val insights: List<LLMInsightItem>,
)

data class LLMInsightItem(
    val type: String,
    val severity: String,
    val title: String,
    val description: String,
    val amount: Double?,
    val date: String?,
)

data class LLMActionResponse(
    val action: LLMAction?,
    val confidence: Float?,
)

data class LLMAction(
    val type: String,
    val params: Map<String, String>?,
)
