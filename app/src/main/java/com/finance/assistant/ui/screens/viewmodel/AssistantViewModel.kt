package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.repository.LLMRepository
import com.finance.assistant.data.repository.MockAssistantRepository
import com.finance.assistant.domain.model.assistant.ActionType
import com.finance.assistant.domain.model.assistant.AssistantAction
import com.finance.assistant.domain.model.assistant.ChatMessage
import com.finance.assistant.domain.model.assistant.MessageRole
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

data class AssistantUiState(
    val messages: List<ChatMessage> = emptyList(),
    val messageActions: Map<Long, List<AssistantAction>> = emptyMap(),
    val inputText: String = "",
    val isLoading: Boolean = false,
    val isUsingLLM: Boolean = false,
    val errorMessage: String? = null,
)

@HiltViewModel
class AssistantViewModel @Inject constructor(
    private val mockAssistantRepository: MockAssistantRepository,
    private val llmRepository: LLMRepository,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AssistantUiState())
    val uiState: StateFlow<AssistantUiState> = _uiState.asStateFlow()

    private var messageIdCounter = 0L
    private var useRealLLM = true // Переключатель: true = LLM, false = мок

    init {
        loadGreeting()
    }

    private fun loadGreeting() {
        viewModelScope.launch {
            val greeting = if (useRealLLM) {
                "Привет! Я финансовый ассистент. Задайте вопрос о ваших финансах."
            } else {
                mockAssistantRepository.getGreeting()
            }
            val greetingMessage = ChatMessage(
                id = messageIdCounter++,
                role = MessageRole.ASSISTANT,
                content = greeting,
            )
            _uiState.update { it.copy(messages = listOf(greetingMessage), isUsingLLM = useRealLLM) }
        }
    }

    fun onInputChanged(text: String) {
        _uiState.update { it.copy(inputText = text) }
    }

    fun setInitialTextAndSend(text: String) {
        _uiState.update { it.copy(inputText = text) }
        sendMessage()
    }

    fun sendMessage() {
        val text = _uiState.value.inputText.trim()
        if (text.isBlank() || _uiState.value.isLoading) return

        val userMessage = ChatMessage(
            id = messageIdCounter++,
            role = MessageRole.USER,
            content = text,
        )

        _uiState.update { state ->
            state.copy(
                inputText = "",
                isLoading = true,
                errorMessage = null,
                messages = state.messages + userMessage,
            )
        }

        viewModelScope.launch {
            try {
                val response = if (useRealLLM) {
                    getLLMResponse(text)
                } else {
                    val (answer, actions) = mockAssistantRepository.sendMessage(text)
                    answer to actions
                }

                val (responseText, actions) = response

                val assistantMessage = ChatMessage(
                    id = messageIdCounter++,
                    role = MessageRole.ASSISTANT,
                    content = responseText,
                )

                _uiState.update { state ->
                    val newMessages = state.messages + assistantMessage
                    val newActions = if (actions.isNotEmpty()) {
                        state.messageActions + (assistantMessage.id to actions)
                    } else {
                        state.messageActions
                    }
                    state.copy(
                        messages = newMessages,
                        messageActions = newActions,
                        isLoading = false,
                    )
                }
            } catch (e: Exception) {
                _uiState.update { state ->
                    state.copy(
                        isLoading = false,
                        errorMessage = e.message ?: "Ошибка при отправке сообщения",
                    )
                }
            }
        }
    }

    private suspend fun getLLMResponse(userMessage: String): Pair<String, List<AssistantAction>> {
        return try {
            val prompt = buildLLMPrompt(userMessage)
            val response = llmRepository.generateText(prompt, temperature = 0.7f)
            
            response.fold(
                onSuccess = { text ->
                    val actions = extractActionsFromResponse(text)
                    text.trim() to actions
                },
                onFailure = { error ->
                    "Ошибка подключения: ${error.message}. Проверьте, что Ollama запущен." to emptyList()
                }
            )
        } catch (e: Exception) {
            "Ошибка: ${e.message}" to emptyList()
        }
    }

    private fun buildLLMPrompt(userMessage: String): String {
        return """
Ты финансовый ассистент в мобильном приложении. Отвечай кратко (2-3 предложения), дружелюбно и по делу на русском языке.

КОНТЕКСТ:
- Текущий баланс: 103 200 ₽
- Месячный доход: 180 000 ₽
- Кассовый разрыв: 28-30 июня спишется 112 000 ₽
- Следующая зарплата: 10 июля

ВОПРОС ПОЛЬЗОВАТЕЛЯ:
$userMessage

Ответь кратко и по существу.
        """.trimIndent()
    }

    private fun extractActionsFromResponse(text: String): List<AssistantAction> {
        // Извлекаем возможные действия на основе ключевых слов
        val lowerText = text.lowercase()
        
        return when {
            lowerText.contains("перенести") || lowerText.contains("разрыв") -> listOf(
                AssistantAction(
                    title = "Перенести расход",
                    description = "Перенести оплату садика на 11 июля",
                    type = ActionType.RESCHEDULE_EXPENSE,
                    data = emptyMap(),
                )
            )
            lowerText.contains("подписк") -> listOf(
                AssistantAction(
                    title = "Отменить подписку",
                    description = "Показать список подписок",
                    type = ActionType.CANCEL_SUBSCRIPTION,
                    data = emptyMap(),
                )
            )
            lowerText.contains("прогноз") || lowerText.contains("баланс") -> listOf(
                AssistantAction(
                    title = "Показать прогноз",
                    description = "Открыть экран прогноза",
                    type = ActionType.VIEW_DETAILS,
                    data = emptyMap(),
                )
            )
            else -> emptyList()
        }
    }

    fun executeAction(messageId: Long, action: AssistantAction) {
        viewModelScope.launch {
            val actionMessage = when (action.type) {
                ActionType.RESCHEDULE_EXPENSE -> "Вы выбрали: перенести расход. Открываю экран переноса..."
                ActionType.CANCEL_SUBSCRIPTION -> "Вы выбрали: отменить подписку. Открываю список подписок..."
                ActionType.SET_REMINDER -> "Вы выбрали: настроить напоминание. Открываю настройки..."
                ActionType.VIEW_DETAILS -> "Вы выбрали: подробнее. Открываю детали..."
                ActionType.TRANSFER_FUNDS -> "Вы выбрали: перевести средства. Открываю перевод..."
                ActionType.ADJUST_BUDGET -> "Вы выбрали: изменить бюджет. Открываю настройки бюджета..."
            }

            val responseMessage = ChatMessage(
                id = messageIdCounter++,
                role = MessageRole.ASSISTANT,
                content = actionMessage,
            )

            _uiState.update { state ->
                state.copy(
                    messages = state.messages + responseMessage,
                    messageActions = state.messageActions - messageId,
                )
            }
        }
    }

    fun dismissError() {
        _uiState.update { it.copy(errorMessage = null) }
    }

    fun toggleAssistantMode() {
        useRealLLM = !useRealLLM
        _uiState.update { it.copy(isUsingLLM = useRealLLM) }
        // Очищаем сообщения и загружаем приветствие заново
        messageIdCounter = 0L
        _uiState.update { it.copy(messages = emptyList()) }
        loadGreeting()
    }
}

fun ActionType.displayLabel(): String = when (this) {
    ActionType.RESCHEDULE_EXPENSE -> "Перенести расход"
    ActionType.CANCEL_SUBSCRIPTION -> "Отменить подписку"
    ActionType.SET_REMINDER -> "Напомнить"
    ActionType.TRANSFER_FUNDS -> "Перевести средства"
    ActionType.ADJUST_BUDGET -> "Изменить бюджет"
    ActionType.VIEW_DETAILS -> "Подробнее"
}
