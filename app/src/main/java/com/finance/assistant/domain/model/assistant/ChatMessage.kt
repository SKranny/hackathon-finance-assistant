package com.finance.assistant.domain.model.assistant

import java.time.LocalDateTime

data class ChatMessage(
    val id: Long = 0,
    val role: MessageRole,
    val content: String,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val isRead: Boolean = false,
    val attachments: List<MessageAttachment> = emptyList(),
    val action: ChatAction? = null,
)

enum class MessageRole {
    USER, ASSISTANT, SYSTEM
}

data class MessageAttachment(
    val type: AttachmentType,
    val data: String,
)

enum class AttachmentType {
    EXPENSE, CASE, FORECAST, PROFILE
}

data class ChatAction(
    val type: ActionType,
    val data: Map<String, String> = emptyMap(),
)

enum class ActionType {
    RESCHEDULE_EXPENSE,
    CANCEL_SUBSCRIPTION,
    SET_REMINDER,
    TRANSFER_FUNDS,
    ADJUST_BUDGET,
    VIEW_DETAILS,
}

data class AssistantContext(
    val currentBalance: Double,
    val monthlyIncome: Double,
    val monthlyExpenses: Double,
    val upcomingExpenses: Int,
    val activeCases: Int,
    val nextSalaryDate: String?,
)

data class AssistantResponse(
    val message: ChatMessage,
    val suggestedActions: List<AssistantAction>,
    val context: AssistantContext,
)

data class AssistantAction(
    val title: String,
    val description: String,
    val type: ActionType,
    val data: Map<String, String>,
)
