package com.finance.assistant.data.repository

import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity_
import com.finance.assistant.data.objectbox.entity.case.ChatMessageEntity
import com.finance.assistant.data.objectbox.entity.case.FinanceCaseEntity
import com.finance.assistant.data.objectbox.entity.case.FinanceCaseEntity_
import com.finance.assistant.data.objectbox.entity.case.ChatMessageEntity_
import com.finance.assistant.data.objectbox.mapper.toDomain
import com.finance.assistant.domain.model.case.CaseSeverity
import com.finance.assistant.domain.model.case.CashGapCase
import com.finance.assistant.domain.model.case.FinanceCase
import com.finance.assistant.domain.model.case.IncomeCase
import com.finance.assistant.domain.model.case.ScheduledExpenseCase
import com.finance.assistant.domain.model.case.SubscriptionAction
import com.finance.assistant.domain.model.case.ZombieSubscriptionCase
import com.finance.assistant.domain.model.expense.UpcomingExpense
import com.finance.assistant.domain.model.forecast.BalanceEvent
import com.finance.assistant.domain.model.forecast.EventType
import io.objectbox.Box
import io.objectbox.kotlin.flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.time.Instant
import java.time.LocalDate
import java.time.LocalDateTime
import java.time.ZoneId
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CaseRepository @Inject constructor(
    private val caseBox: Box<FinanceCaseEntity>,
    private val upcomingExpenseBox: Box<UpcomingExpenseEntity>,
) {

    suspend fun saveCase(severity: CaseSeverity, title: String, description: String, dueDate: LocalDate?, amount: Double, caseType: String, additionalData: String = ""): Long =
        withContext(Dispatchers.IO) {
            val entity = FinanceCaseEntity(
                caseType = caseType,
                title = title,
                description = description,
                dueDate = dueDate?.toEpochDay() ?: 0,
                amount = amount,
                severity = severity.name,
                additionalData = additionalData,
            )
            caseBox.put(entity)
        }

    suspend fun markCaseResolved(id: Long) =
        withContext(Dispatchers.IO) {
            caseBox.get(id)?.let {
                it.isResolved = true
                caseBox.put(it)
            }
        }

    suspend fun deleteCase(id: Long) =
        withContext(Dispatchers.IO) {
            caseBox.remove(id)
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getActiveCases(): Flow<List<FinanceCase>> =
        caseBox.query()
            .equal(FinanceCaseEntity_.isResolved, false)
            .orderDesc(FinanceCaseEntity_.severity)
            .build()
            .flow()
            .map { list -> list.map { it.toDomainCase() } }
            .flowOn(Dispatchers.IO)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getCasesByType(type: String): Flow<List<FinanceCase>> =
        caseBox.query()
            .equal(FinanceCaseEntity_.caseType, type)
            .equal(FinanceCaseEntity_.isResolved, false)
            .build()
            .flow()
            .map { list -> list.map { it.toDomainCase() } }
            .flowOn(Dispatchers.IO)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getCasesForDateRange(startDate: LocalDate, endDate: LocalDate): Flow<List<FinanceCase>> =
        caseBox.query()
            .between(FinanceCaseEntity_.dueDate, startDate.toEpochDay(), endDate.toEpochDay())
            .equal(FinanceCaseEntity_.isResolved, false)
            .order(FinanceCaseEntity_.dueDate)
            .build()
            .flow()
            .map { list -> list.map { it.toDomainCase() } }
            .flowOn(Dispatchers.IO)

    private fun FinanceCaseEntity.toDomainCase(): FinanceCase {
        val date = if (dueDate > 0) LocalDate.ofEpochDay(dueDate) else null
        val severityEnum = try { CaseSeverity.valueOf(severity) } catch (e: Exception) { CaseSeverity.INFO }

        return when (caseType) {
            "CASH_GAP" -> CashGapCase(
                id = id,
                title = title,
                description = description,
                dueDate = date ?: LocalDate.now(),
                amount = amount,
                severity = severityEnum,
                isResolved = isResolved,
                gapAmount = parseAdditionalData("gapAmount") ?: amount,
                daysUntilSalary = parseAdditionalData("daysUntilSalary")?.toInt() ?: 0,
                recommendedSavingsPerDay = parseAdditionalData("recommendedSavingsPerDay")?.toDouble() ?: 0.0,
                affectedExpenses = parseAdditionalDataList("affectedExpenses"),
            )
            "ZOMBIE_SUBSCRIPTION" -> ZombieSubscriptionCase(
                id = id,
                title = title,
                description = description,
                dueDate = date,
                amount = amount,
                severity = severityEnum,
                isResolved = isResolved,
                monthlyAmount = amount,
                lastUsageDate = date,
                daysSinceLastUsage = parseAdditionalData("daysSinceLastUsage")?.toInt() ?: 0,
                yearlyCost = amount * 12,
                suggestedAction = try { SubscriptionAction.valueOf(parseAdditionalData("suggestedAction") ?: "INVESTIGATE") } catch (e: Exception) { SubscriptionAction.INVESTIGATE },
            )
            "SCHEDULED_EXPENSE" -> ScheduledExpenseCase(
                id = id,
                title = title,
                description = description,
                dueDate = date ?: LocalDate.now(),
                amount = amount,
                severity = severityEnum,
                isResolved = isResolved,
                category = parseAdditionalData("category") ?: "OTHER",
                source = parseAdditionalData("source") ?: "MANUAL",
                isRecurring = parseAdditionalData("isRecurring")?.toBoolean() ?: false,
            )
            "INCOME" -> IncomeCase(
                id = id,
                title = title,
                description = description,
                dueDate = date ?: LocalDate.now(),
                amount = amount,
                severity = severityEnum,
                isResolved = isResolved,
                source = parseAdditionalData("source") ?: "SALARY",
            )
            else -> ScheduledExpenseCase(
                id = id,
                title = title,
                description = description,
                dueDate = date ?: LocalDate.now(),
                amount = amount,
                severity = severityEnum,
                isResolved = isResolved,
                category = "OTHER",
                source = "UNKNOWN",
            )
        }
    }

    private fun FinanceCaseEntity.parseAdditionalData(key: String): String? {
        return additionalData.split(";")
            .map { it.split(":") }
            .filter { it.size == 2 }
            .find { it[0] == key }?.get(1)
    }

    private fun FinanceCaseEntity.parseAdditionalDataList(key: String): List<String> {
        return parseAdditionalData(key)?.split(",")?.filter { it.isNotEmpty() } ?: emptyList()
    }

    companion object {
        fun createAdditionalData(vararg pairs: Pair<String, String>): String {
            return pairs.joinToString(";") { "${it.first}:${it.second}" }
        }
    }
}
