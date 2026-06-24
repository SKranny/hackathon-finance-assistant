package com.finance.assistant.domain.model.session

import java.time.LocalDateTime
import java.util.UUID

data class SessionContext(
    val id: String = UUID.randomUUID().toString(),
    val messages: List<SessionMessage> = emptyList(),
    val lastQuery: ParsedQuery? = null,
    val lastResults: QueryResults? = null,
    val createdAt: LocalDateTime = LocalDateTime.now(),
    val lastActivity: LocalDateTime = LocalDateTime.now(),
    val language: AppLanguage = AppLanguage.RU,
) {
    fun isExpired(maxAgeMinutes: Int = 30): Boolean {
        return lastActivity.plusMinutes(maxAgeMinutes.toLong()).isBefore(LocalDateTime.now())
    }

    fun withNewMessage(message: SessionMessage): SessionContext {
        return copy(
            messages = messages + message,
            lastActivity = LocalDateTime.now(),
        )
    }

    fun withQueryResult(query: ParsedQuery, results: QueryResults): SessionContext {
        return copy(
            lastQuery = query,
            lastResults = results,
            lastActivity = LocalDateTime.now(),
        )
    }

    fun clearContext(): SessionContext {
        return copy(
            messages = emptyList(),
            lastQuery = null,
            lastResults = null,
            lastActivity = LocalDateTime.now(),
        )
    }
}

data class SessionMessage(
    val role: MessageRole,
    val content: String,
    val timestamp: LocalDateTime = LocalDateTime.now(),
    val intent: String? = null,
)

enum class MessageRole {
    USER, ASSISTANT, SYSTEM
}

data class ParsedQuery(
    val intent: String,
    val entities: Map<String, String?> = emptyMap(),
    val rawQuery: String,
)

data class QueryResults(
    val summary: String,
    val transactions: List<TransactionSummary> = emptyList(),
    val totalAmount: Double? = null,
    val period: String? = null,
    val category: String? = null,
)

data class TransactionSummary(
    val id: Long,
    val title: String,
    val amount: Double,
    val date: String,
    val category: String,
)

enum class AppLanguage(val code: String, val displayName: String) {
    RU("ru", "Русский"),
    EN("en", "English"),
    KK("kk", "Қазақша")
}
