package com.finance.assistant.ai

import android.content.Context
import com.finance.assistant.domain.model.CalendarEvent
import com.finance.assistant.domain.model.FinancialInsight
import com.finance.assistant.domain.model.InsightSeverity
import com.finance.assistant.domain.model.InsightType
import com.finance.assistant.domain.model.Transaction
import dagger.hilt.android.qualifiers.ApplicationContext
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AIModelManager @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    private var isModelLoaded = false

    suspend fun loadModel(): Result<Unit> = runCatching {
        isModelLoaded = true
    }

    suspend fun analyzeFinancialData(
        transactions: List<Transaction>,
        calendarEvents: List<CalendarEvent>,
    ): List<FinancialInsight> {
        if (!isModelLoaded) return emptyList()

        val insights = mutableListOf<FinancialInsight>()
        val today = LocalDate.now()

        val upcomingExpenses = detectUpcomingExpenses(calendarEvents, transactions)
        insights.addAll(upcomingExpenses)

        val cashGaps = detectCashGaps(transactions)
        insights.addAll(cashGaps)

        val largePurchases = detectLargePurchases(transactions)
        insights.addAll(largePurchases)

        val recurring = detectRecurringPayments(transactions)
        insights.addAll(recurring)

        return insights
    }

    private suspend fun detectUpcomingExpenses(
        events: List<CalendarEvent>,
        transactions: List<Transaction>,
    ): List<FinancialInsight> {
        val insights = mutableListOf<FinancialInsight>()
        val today = LocalDate.now()

        for (event in events) {

        }

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

    private suspend fun detectCashGaps(transactions: List<Transaction>): List<FinancialInsight> {
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

    private suspend fun detectLargePurchases(transactions: List<Transaction>): List<FinancialInsight> {
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

    private suspend fun detectRecurringPayments(transactions: List<Transaction>): List<FinancialInsight> {
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
