package com.finance.assistant.domain.usecase.session

import com.finance.assistant.domain.model.assistant.ChatMessage
import com.finance.assistant.domain.model.session.AppLanguage
import com.finance.assistant.domain.model.session.MessageRole
import com.finance.assistant.domain.model.session.ParsedQuery
import com.finance.assistant.domain.model.session.QueryResults
import com.finance.assistant.domain.model.session.SessionContext
import com.finance.assistant.domain.model.session.SessionMessage
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import java.time.LocalDateTime
import java.util.UUID
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SessionManager @Inject constructor() {

    private val _currentSession = MutableStateFlow(SessionContext())
    val currentSession: StateFlow<SessionContext> = _currentSession.asStateFlow()

    private val sessionHistory = mutableListOf<SessionContext>()
    private val maxHistorySize = 10

    fun startNewSession(): String {
        saveCurrentSession()
        val newSession = SessionContext()
        _currentSession.value = newSession
        return newSession.id
    }

    fun addUserMessage(content: String, language: AppLanguage): SessionContext {
        val session = _currentSession.value
        val message = SessionMessage(
            role = MessageRole.USER,
            content = content,
            timestamp = LocalDateTime.now(),
        )
        _currentSession.value = session.withNewMessage(message).copy(language = language)
        return _currentSession.value
    }

    fun addAssistantMessage(content: String, intent: String? = null): SessionContext {
        val session = _currentSession.value
        val message = SessionMessage(
            role = MessageRole.ASSISTANT,
            content = content,
            timestamp = LocalDateTime.now(),
            intent = intent,
        )
        _currentSession.value = session.withNewMessage(message)
        return _currentSession.value
    }

    fun saveQueryResults(query: ParsedQuery, results: QueryResults): SessionContext {
        val session = _currentSession.value
        _currentSession.value = session.withQueryResult(query, results)
        return _currentSession.value
    }

    fun clearSession(): SessionContext {
        _currentSession.value = _currentSession.value.clearContext()
        return _currentSession.value
    }

    fun processFollowUp(followUpMessage: String): FollowUpContext {
        val session = _currentSession.value
        val lastResults = session.lastResults ?: return FollowUpContext(
            needsMoreContext = true,
            suggestion = "У меня нет данных о предыдущем запросе. Пожалуйста, задайте вопрос заново."
        )

        val followUp = followUpMessage.lowercase()
        val intent = session.lastQuery?.intent ?: ""

        val contextInfo = buildContextInfo(lastResults)

        return when {
            isRefinement(followUp) -> {
                val refinedIntent = refineIntent(intent, followUp, lastResults)
                FollowUpContext(
                    refinedQuery = refinedIntent,
                    contextUsed = contextInfo,
                    needsMoreContext = false,
                )
            }

            isDrillDown(followUp) -> {
                val detailLevel = extractDetailLevel(followUp)
                FollowUpContext(
                    refinedQuery = buildDetailQuery(intent, lastResults, detailLevel),
                    contextUsed = contextInfo,
                    needsMoreContext = false,
                )
            }

            isFilterRequest(followUp) -> {
                val filters = extractFilters(followUp)
                FollowUpContext(
                    refinedQuery = buildFilteredQuery(intent, lastResults, filters),
                    contextUsed = contextInfo,
                    needsMoreContext = false,
                )
            }

            isComparisonRequest(followUp) -> {
                FollowUpContext(
                    refinedQuery = buildComparisonQuery(intent, lastResults, followUpMessage),
                    contextUsed = contextInfo,
                    needsMoreContext = false,
                )
            }

            else -> FollowUpContext(
                needsMoreContext = true,
                suggestion = "Уточните, пожалуйста: что именно вы хотите узнать о ${getContextTitle(lastResults)}?",
            )
        }
    }

    private fun isRefinement(followUp: String): Boolean {
        val patterns = listOf(
            "покажи ещё", "ещё", "больше", "добавь", "подробнее",
            "more", "also", "add", "more details",
            "тағы", "көбірек"
        )
        return patterns.any { followUp.contains(it) }
    }

    private fun isDrillDown(followUp: String): Boolean {
        val patterns = listOf(
            "детали", "подробности", "по кажд", " breakdown", "details", "breakdown",
            "толығырақ", "мәлімет"
        )
        return patterns.any { followUp.contains(it) }
    }

    private fun isFilterRequest(followUp: String): Boolean {
        val patterns = listOf(
            "только", "только лишь", "только те", "filter", "only", "just",
            "тек", "ғана"
        )
        return patterns.any { followUp.contains(it) }
    }

    private fun isComparisonRequest(followUp: String): Boolean {
        val patterns = listOf(
            "сравни", "compared", "vs", "против", "больше чем", "меньше чем",
            "салыстыр", "үлкен", "кіші"
        )
        return patterns.any { followUp.contains(it) }
    }

    private fun refineIntent(originalIntent: String, followUp: String, lastResults: QueryResults): String {
        val originalQuery = lastResults.summary
        val refineWord = when {
            followUp.contains("ещё") || followUp.contains("больше") -> "+10"
            followUp.contains("детали") || followUp.contains("подробнее") -> "details"
            else -> "repeat"
        }
        return "$originalQuery [$refineWord]"
    }

    private fun extractDetailLevel(followUp: String): DetailLevel {
        return when {
            followUp.contains("все") || followUp.contains("all") || followUp.contains("барлық") -> DetailLevel.ALL
            followUp.contains("топ") || followUp.contains("top") -> DetailLevel.TOP
            followUp.contains("по категориям") || followUp.contains("by category") -> DetailLevel.BY_CATEGORY
            else -> DetailLevel.DEFAULT
        }
    }

    private fun extractFilters(followUp: String): Map<String, String> {
        val filters = mutableMapOf<String, String>()

        val categoryPatterns = mapOf(
            "еда" to "FOOD", "food" to "FOOD", "тамақ" to "FOOD",
            "транспорт" to "TRANSPORT", "transport" to "TRANSPORT", "көлік" to "TRANSPORT",
        )

        for ((pattern, category) in categoryPatterns) {
            if (followUp.contains(pattern)) {
                filters["category"] = category
                break
            }
        }

        if (followUp.contains("крупн") || followUp.contains("large") || followUp.contains("үлкен")) {
            filters["minAmount"] = "5000"
        }

        return filters
    }

    private fun buildContextInfo(results: QueryResults): String {
        val sb = StringBuilder()
        sb.appendLine("Контекст из предыдущего запроса:")
        if (results.summary.isNotEmpty()) {
            sb.appendLine("- ${results.summary}")
        }
        if (results.period != null) {
            sb.appendLine("- Период: ${results.period}")
        }
        if (results.category != null) {
            sb.appendLine("- Категория: ${results.category}")
        }
        if (results.totalAmount != null) {
            sb.appendLine("- Сумма: ${results.totalAmount} ₽")
        }
        if (results.transactions.isNotEmpty()) {
            sb.appendLine("- Транзакций: ${results.transactions.size}")
        }
        return sb.toString()
    }

    private fun getContextTitle(results: QueryResults): String {
        return when {
            results.summary.contains("расход") -> "расходах"
            results.summary.contains("перевод") -> "переводах"
            results.summary.contains("подписк") -> "подписках"
            else -> "данных"
        }
    }

    private fun buildDetailQuery(intent: String, results: QueryResults, level: DetailLevel): String {
        return when (level) {
            DetailLevel.ALL -> "$intent (все записи)"
            DetailLevel.TOP -> "$intent (топ-20)"
            DetailLevel.BY_CATEGORY -> "$intent (по категориям)"
            DetailLevel.DEFAULT -> intent
        }
    }

    private fun buildFilteredQuery(intent: String, results: QueryResults, filters: Map<String, String>): String {
        val category = filters["category"]
        val minAmount = filters["minAmount"]
        return buildString {
            append(intent)
            if (category != null) {
                append(" (категория: $category)")
            }
            if (minAmount != null) {
                append(" (от $minAmount ₽)")
            }
        }
    }

    private fun buildComparisonQuery(intent: String, results: QueryResults, followUp: String): String {
        return "$intent + сравнение"
    }

    private fun saveCurrentSession() {
        val current = _currentSession.value
        if (current.messages.isNotEmpty()) {
            sessionHistory.add(current)
            if (sessionHistory.size > maxHistorySize) {
                sessionHistory.removeAt(0)
            }
        }
    }

    fun getPreviousSessions(): List<SessionContext> = sessionHistory.toList()

    fun restoreSession(sessionId: String): Boolean {
        val session = sessionHistory.find { it.id == sessionId }
        if (session != null) {
            _currentSession.value = session
            return true
        }
        return false
    }
}

data class FollowUpContext(
    val refinedQuery: String? = null,
    val contextUsed: String? = null,
    val needsMoreContext: Boolean = false,
    val suggestion: String? = null,
)

enum class DetailLevel {
    DEFAULT, ALL, TOP, BY_CATEGORY
}
