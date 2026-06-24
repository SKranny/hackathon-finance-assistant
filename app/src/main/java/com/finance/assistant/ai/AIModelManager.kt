package com.finance.assistant.ai

import android.content.Context
import android.util.Log
import com.finance.assistant.data.repository.LLMRepository
import com.finance.assistant.domain.model.CalendarEvent
import com.finance.assistant.domain.model.FinancialInsight
import com.finance.assistant.domain.model.InsightSeverity
import com.finance.assistant.domain.model.InsightType
import com.finance.assistant.domain.model.Transaction
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AIModelManager @Inject constructor(
    @ApplicationContext private val context: Context,
    private val llmRepository: LLMRepository,
) {

    private var isModelLoaded = false
    private val dateFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd")

    suspend fun loadModel(): Result<Unit> = runCatching {
        val isAvailable = llmRepository.isAvailable()
        isModelLoaded = isAvailable
        if (!isAvailable) {
            Log.w(TAG, "Ollama not available, using fallback analysis")
        }
    }

    suspend fun analyzeFinancialData(
        transactions: List<Transaction>,
        calendarEvents: List<CalendarEvent>,
    ): List<FinancialInsight> {
        val llmInsights = if (isModelLoaded) {
            generateLLMInsights(transactions, calendarEvents)
        } else {
            emptyList()
        }

        val fallbackInsights = generateFallbackInsights(transactions, calendarEvents)

        return (llmInsights + fallbackInsights).distinctBy { "${it.type}_${it.title}" }
    }

    private suspend fun generateLLMInsights(
        transactions: List<Transaction>,
        calendarEvents: List<CalendarEvent>,
    ): List<FinancialInsight> {
        val prompt = buildInsightsPrompt(transactions, calendarEvents)

        return llmRepository.generateStructuredJson(prompt)
            .getOrNull()
            ?.insights
            ?.mapNotNull { item ->
                parseInsight(item)
            }
            ?: emptyList()
    }

    private fun buildInsightsPrompt(
        transactions: List<Transaction>,
        calendarEvents: List<CalendarEvent>,
    ): String {
        val txSummary = transactions.take(50).joinToString("\n") { tx ->
            "${tx.date} | ${tx.category.name} | ${tx.amount} | ${tx.title}"
        }

        val eventsSummary = calendarEvents.take(20).joinToString("\n") { event ->
            "${event.startTime.toLocalDate()} | ${event.title} | ${event.expenseAmount ?: "?"}"
        }

        return """
Ты финансовый аналитик. Проанализируй транзакции пользователя и события календаря.

ТРАНЗАКЦИИ (последние):
$txSummary

СОБЫТИЯ КАЛЕНДАРЯ:
$eventsSummary

Верни JSON массив с финансовыми инсайтами. Типы инсайтов: UPCOMING_EXPENSE, PAYMENT_DUE, CASH_GAP, LARGE_PURCHASE, SUBSCRIPTION_RENEWAL.
Уровни серьёзности: INFO, WARNING, CRITICAL.
Формат:
{"insights": [{"type": "CASH_GAP", "severity": "WARNING", "title": "...", "description": "...", "amount": 5000, "date": "2024-01-15"}]}

Верни ТОЛЬКО JSON, без markdown разметки.
        """.trimIndent()
    }

    private fun parseInsight(item: com.finance.assistant.data.remote.LLMInsightItem): FinancialInsight? {
        val type = try {
            InsightType.valueOf(item.type.uppercase())
        } catch (e: Exception) {
            InsightType.UPCOMING_EXPENSE
        }

        val severity = try {
            InsightSeverity.valueOf(item.severity.uppercase())
        } catch (e: Exception) {
            InsightSeverity.INFO
        }

        val date = item.date?.let {
            runCatching { LocalDate.parse(it, dateFormatter) }.getOrNull()
        } ?: LocalDate.now()

        return FinancialInsight(
            type = type,
            title = item.title,
            description = item.description,
            severity = severity,
            date = date,
            relatedAmount = item.amount,
        )
    }

    private fun generateFallbackInsights(
        transactions: List<Transaction>,
        calendarEvents: List<CalendarEvent>,
    ): List<FinancialInsight> {
        val insights = mutableListOf<FinancialInsight>()
        val today = LocalDate.now()

        insights.addAll(detectUpcomingExpensesFallback(calendarEvents, transactions))
        insights.addAll(detectCashGaps(transactions))
        insights.addAll(detectLargePurchases(transactions))
        insights.addAll(detectRecurringPayments(transactions))

        return insights
    }

    private fun detectUpcomingExpensesFallback(
        events: List<CalendarEvent>,
        transactions: List<Transaction>,
    ): List<FinancialInsight> {
        val insights = mutableListOf<FinancialInsight>()
        val today = LocalDate.now()

        val recurringTx = transactions.filter { it.isRecurring }
        for (tx in recurringTx) {
            val nextDate = tx.date.plusMonths(1)
            if (nextDate.isBefore(today.plusDays(7))) {
                insights.add(
                    FinancialInsight(
                        type = InsightType.SUBSCRIPTION_RENEWAL,
                        title = "Скоро списание: ${tx.title}",
                        description = "Ожидаемое списание ${tx.amount} ₽ ${nextDate}",
                        severity = InsightSeverity.WARNING,
                        date = nextDate,
                        relatedAmount = tx.amount,
                    )
                )
            }
        }

        return insights
    }

    private fun detectCashGaps(transactions: List<Transaction>): List<FinancialInsight> {
        val insights = mutableListOf<FinancialInsight>()
        val today = LocalDate.now()
        val endOfMonth = today.withDayOfMonth(today.lengthOfMonth())

        val upcomingExpenses = transactions.filter {
            it.date in today..endOfMonth && it.amount > 0
        }

        val totalExpenses = upcomingExpenses.sumOf { it.amount }
        val totalIncome = transactions.filter {
            it.category.name == "SALARY" && it.date in today..endOfMonth
        }.sumOf { it.amount }

        if (totalExpenses > totalIncome && totalIncome > 0) {
            insights.add(
                FinancialInsight(
                    type = InsightType.CASH_GAP,
                    title = "Возможный кассовый разрыв",
                    description = "Расходы ($totalExpenses ₽) превышают доходы ($totalIncome ₽) до конца месяца",
                    severity = InsightSeverity.CRITICAL,
                    date = today,
                    relatedAmount = totalExpenses - totalIncome,
                )
            )
        }

        return insights
    }

    private fun detectLargePurchases(transactions: List<Transaction>): List<FinancialInsight> {
        val insights = mutableListOf<FinancialInsight>()
        val today = LocalDate.now()
        val monthStart = today.withDayOfMonth(1)

        val monthlyTransactions = transactions.filter { it.date >= monthStart }
        val avgAmount = monthlyTransactions.filter { it.amount > 0 }
            .let { if (it.isEmpty()) 0.0 else it.sumOf { t -> t.amount } / it.size }

        val largeTransactions = monthlyTransactions.filter {
            it.amount > avgAmount * 3 && it.amount > 5000
        }

        for (tx in largeTransactions) {
            insights.add(
                FinancialInsight(
                    type = InsightType.LARGE_PURCHASE,
                    title = "Крупная покупка: ${tx.title}",
                    description = "${tx.amount} ₽ — ${tx.category.name}",
                    severity = InsightSeverity.INFO,
                    date = tx.date,
                    relatedAmount = tx.amount,
                )
            )
        }

        return insights
    }

    private fun detectRecurringPayments(transactions: List<Transaction>): List<FinancialInsight> {
        val insights = mutableListOf<FinancialInsight>()
        val today = LocalDate.now()

        val recurring = transactions.filter { it.isRecurring }
        for (tx in recurring) {
            val monthAgo = today.minusMonths(1)
            if (tx.date <= monthAgo) {
                val nextPayment = tx.date.plusMonths(
                    ((today.toEpochDay() - tx.date.toEpochDay()) / 30).toLong() + 1
                )
                insights.add(
                    FinancialInsight(
                        type = InsightType.PAYMENT_DUE,
                        title = "Приближается платёж: ${tx.title}",
                        description = "Сумма: ${tx.amount} ₽, дата: $nextPayment",
                        severity = InsightSeverity.WARNING,
                        date = nextPayment,
                        relatedAmount = tx.amount,
                    )
                )
            }
        }

        return insights
    }

    fun isLoaded(): Boolean = isModelLoaded

    companion object {
        private const val TAG = "AIModelManager"
    }
}
