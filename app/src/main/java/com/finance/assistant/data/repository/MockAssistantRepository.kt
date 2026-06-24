package com.finance.assistant.data.repository

import android.content.Context
import com.finance.assistant.data.model.AssistantMockData
import com.finance.assistant.data.model.AssistantResponseData
import com.finance.assistant.domain.model.assistant.ActionType
import com.finance.assistant.domain.model.assistant.AssistantAction
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.delay
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class MockAssistantRepository @Inject constructor(
    @ApplicationContext private val context: Context,
    private val gson: Gson,
) {
    private var cachedData: AssistantMockData? = null
    private val messageHistory = mutableListOf<Pair<String, String>>() // userMessage to responseKey

    suspend fun getAssistantData(): AssistantMockData {
        return cachedData ?: loadFromAssets().also { cachedData = it }
    }

    private suspend fun loadFromAssets(): AssistantMockData = withContext(Dispatchers.IO) {
        val json = context.assets.open("assistant_mock_data.json")
            .bufferedReader()
            .use { it.readText() }
        gson.fromJson(json, AssistantMockData::class.java)
    }

    suspend fun sendMessage(userMessage: String): Pair<String, List<AssistantAction>> {
        delay(800)

        val data = getAssistantData()
        val response = findMatchingResponse(userMessage.lowercase(), data)
        
        messageHistory.add(userMessage to responseKey(response))
        
        val actions = response.actions.mapNotNull { actionData ->
            mapToAssistantAction(actionData)
        }

        return response.answer to actions
    }

    private fun findMatchingResponse(message: String, data: AssistantMockData): AssistantResponseData {
        val responses = data.responses
        
        return when {
            message.contains("баланс") || message.contains("сколько") || message.contains("деньги") ->
                responses["balance"] ?: responses["default"]!!
                
            message.contains("расход") || message.contains("трат") || message.contains("потрати") ->
                responses["expense"] ?: responses["default"]!!
                
            message.contains("зарплат") || message.contains("доход") ->
                responses["salary"] ?: responses["default"]!!
                
            message.contains("помощь") || message.contains("что делать") || message.contains("help") ->
                responses["help"] ?: responses["default"]!!
                
            message.contains("подписк") || message.contains("subscribe") ->
                responses["subscription"] ?: responses["default"]!!
                
            message.contains("разрыв") || message.contains("проблем") || message.contains("касса") ->
                responses["cash_gap"] ?: responses["default"]!!
                
            else -> responses["default"]!!
        }
    }

    private fun responseKey(response: AssistantResponseData): String {
        val data = cachedData ?: return "default"
        return data.responses.entries.find { it.value === response }?.key ?: "default"
    }

    private fun mapToAssistantAction(actionData: com.finance.assistant.data.model.AssistantActionData): AssistantAction? {
        val actionType = when (actionData.type.uppercase()) {
            "RESCHEDULE_EXPENSE" -> ActionType.RESCHEDULE_EXPENSE
            "CANCEL_SUBSCRIPTION" -> ActionType.CANCEL_SUBSCRIPTION
            "SET_REMINDER" -> ActionType.SET_REMINDER
            "TRANSFER_FUNDS" -> ActionType.TRANSFER_FUNDS
            "ADJUST_BUDGET" -> ActionType.ADJUST_BUDGET
            "VIEW_DETAILS" -> ActionType.VIEW_DETAILS
            else -> return null
        }

        return AssistantAction(
            title = actionData.title,
            description = "",
            type = actionType,
            data = emptyMap(),
        )
    }

    fun getGreeting(): String {
        return cachedData?.greeting ?: "Привет! Я ваш финансовый помощник."
    }
}
