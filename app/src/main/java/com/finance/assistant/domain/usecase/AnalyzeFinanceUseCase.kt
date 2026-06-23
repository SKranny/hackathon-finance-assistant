package com.finance.assistant.domain.usecase

import com.finance.assistant.ai.AIModelManager
import com.finance.assistant.data.repository.InsightRepository
import com.finance.assistant.data.repository.TransactionRepository
import com.finance.assistant.domain.model.FinancialInsight
import com.finance.assistant.service.CalendarScanner
import com.finance.assistant.service.TransactionScanner
import kotlinx.coroutines.flow.first
import javax.inject.Inject

class AnalyzeFinanceUseCase @Inject constructor(
    private val aiModelManager: AIModelManager,
    private val transactionRepository: TransactionRepository,
    private val insightRepository: InsightRepository,
    private val calendarScanner: CalendarScanner,
    private val transactionScanner: TransactionScanner,
) {

    suspend operator fun invoke(): Result<List<FinancialInsight>> =
        runCatching {
            if (!aiModelManager.isLoaded()) {
                aiModelManager.loadModel().getOrThrow()
            }

            val smsTransactions = transactionScanner.scanSmsTransactions()
            transactionRepository.insertAll(smsTransactions)

            val calendarEvents = calendarScanner.scanUpcomingEvents()
            val transactions = transactionRepository.getAllTransactions().first()

            val insights = aiModelManager.analyzeFinancialData(transactions, calendarEvents)
            insightRepository.insertAll(insights)
            insights
        }
}
