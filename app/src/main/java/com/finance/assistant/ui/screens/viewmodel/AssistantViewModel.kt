package com.finance.assistant.ui.screens.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.finance.assistant.data.repository.ChatRepository
import com.finance.assistant.domain.model.assistant.ActionType
import com.finance.assistant.domain.model.assistant.AssistantAction
import com.finance.assistant.domain.model.assistant.ChatMessage
import com.finance.assistant.domain.usecase.AssistantUseCase
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
    val errorMessage: String? = null,
)

@HiltViewModel
class AssistantViewModel @Inject constructor(
    private val chatRepository: ChatRepository,
    private val assistantUseCase: AssistantUseCase,
) : ViewModel() {

    private val _uiState = MutableStateFlow(AssistantUiState())
    val uiState: StateFlow<AssistantUiState> = _uiState.asStateFlow()

    init {
        loadHistory()
    }

    private fun loadHistory() {
        viewModelScope.launch {
            chatRepository.getMessages().collect { messages ->
                _uiState.update { it.copy(messages = messages.reversed()) }
            }
        }
    }

    fun onInputChanged(text: String) {
        _uiState.update { it.copy(inputText = text) }
    }

    fun sendMessage() {
        val text = _uiState.value.inputText.trim()
        if (text.isBlank() || _uiState.value.isLoading) return

        _uiState.update { it.copy(inputText = "", isLoading = true, errorMessage = null) }

        viewModelScope.launch {
            val result = runCatching { assistantUseCase.sendMessage(text) }
            result.fold(
                onSuccess = { response ->
                    if (response.suggestedActions.isNotEmpty()) {
                        _uiState.update { state ->
                            state.copy(
                                messageActions = state.messageActions +
                                    (response.message.id to response.suggestedActions),
                            )
                        }
                    }
                },
                onFailure = { error ->
                    _uiState.update { it.copy(errorMessage = error.message) }
                },
            )
            _uiState.update { it.copy(isLoading = false) }
        }
    }

    fun executeAction(messageId: Long, action: AssistantAction) {
        viewModelScope.launch {
            assistantUseCase.executeAction(action.type, action.data)
            _uiState.update { state ->
                state.copy(messageActions = state.messageActions - messageId)
            }
        }
    }

    fun dismissError() {
        _uiState.update { it.copy(errorMessage = null) }
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
