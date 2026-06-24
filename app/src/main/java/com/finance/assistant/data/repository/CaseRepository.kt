package com.finance.assistant.data.repository

import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity_
import com.finance.assistant.data.objectbox.entity.session.ChatMessageEntity
import com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity
import com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity_
import com.finance.assistant.data.objectbox.entity.session.ChatMessageEntity_
import com.finance.assistant.data.objectbox.mapper.toDomain
import com.finance.assistant.domain.model.alert.CaseSeverity
import com.finance.assistant.domain.model.alert.CashGapCase
import com.finance.assistant.domain.model.alert.FinanceCase
import com.finance.assistant.domain.model.alert.IncomeCase
import com.finance.assistant.domain.model.alert.ScheduledExpenseCase
import com.finance.assistant.domain.model.alert.SubscriptionAction
import com.finance.assistant.domain.model.alert.ZombieSubscriptionCase
import com.finance.assistant.domain.model.alert.CaseResolution
import com.finance.assistant.domain.model.alert.RiskLevel
import com.finance.assistant.domain.model.alert.SavingsRecommendation
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
import java.time.temporal.ChronoUnit
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class CaseRepository @Inject constructor(
    private val caseBox: Box<FinanceCaseEntity>,
    private val upcomingExpenseBox: Box<UpcomingExpenseEntity>,
) {

    suspend fun saveCase(severity: CaseSeverity, title: String, description: String, dueDate: LocalDate?, amount: Double, alertType: String, additionalData: String = ""): Long =
        withContext(Dispatchers.IO) {
            val entity = FinanceCaseEntity(
                alertType = alertType,
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
                it.resolved = true
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
            .equal(FinanceCaseEntity_.resolved, false)
            .orderDesc(FinanceCaseEntity_.severity)
            .build()
            .flow()
            .map { list -> list.map { it.toDomainCase() } }
            .flowOn(Dispatchers.IO)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getCasesByType(type: String): Flow<List<FinanceCase>> =
        caseBox.query()
            .equal(FinanceCaseEntity_.alertType, type, io.objectbox.query.QueryBuilder.StringOrder.CASE_SENSITIVE)
            .equal(FinanceCaseEntity_.resolved, false)
            .build()
            .flow()
            .map { list -> list.map { it.toDomainCase() } }
            .flowOn(Dispatchers.IO)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getCasesForDateRange(startDate: LocalDate, endDate: LocalDate): Flow<List<FinanceCase>> =
        caseBox.query()
            .between(FinanceCaseEntity_.dueDate, startDate.toEpochDay(), endDate.toEpochDay())
            .equal(FinanceCaseEntity_.resolved, false)
            .order(FinanceCaseEntity_.dueDate)
            .build()
            .flow()
            .map { list -> list.map { it.toDomainCase() } }
            .flowOn(Dispatchers.IO)

    private fun FinanceCaseEntity.toDomainCase(): FinanceCase {
        val date = if (dueDate > 0) LocalDate.ofEpochDay(dueDate) else null
        val severityEnum = try { CaseSeverity.valueOf(severity) } catch (e: Exception) { CaseSeverity.INFO }

        return when (alertType) {
            "CASH_GAP" -> CashGapCase(
                id = id,
                title = title,
                description = description,
                dueDate = date ?: LocalDate.now(),
                amount = amount,
                severity = severityEnum,
                isResolved = resolved,
                gapAmount = parseDouble(parseAdditionalData("gapAmount")) ?: amount,
                daysUntilSalary = parseInt(parseAdditionalData("daysUntilSalary")) ?: 0,
                recommendedSavingsPerDay = parseDouble(parseAdditionalData("recommendedSavingsPerDay")) ?: 0.0,
                affectedExpenses = parseAdditionalDataList("affectedExpenses"),
            )
            "ZOMBIE_SUBSCRIPTION" -> ZombieSubscriptionCase(
                id = id,
                title = title,
                description = description,
                dueDate = date,
                amount = amount,
                severity = severityEnum,
                isResolved = resolved,
                monthlyAmount = amount,
                lastUsageDate = date,
                daysSinceLastUsage = parseInt(parseAdditionalData("daysSinceLastUsage")) ?: 0,
                yearlyCost = amount * 12,
                suggestedAction = try { SubscriptionAction.valueOf(parseAdditionalData("suggestedAction") ?: "INVESTIGATE") } catch (e: Exception) { SubscriptionAction.INVESTIGATE },
            )
            "SCHEDULED_EXPENSE" -> {
                val category = parseAdditionalData("category") ?: "OTHER"
                val source = parseAdditionalData("source") ?: "MANUAL"
                val scheduledDate = date ?: LocalDate.now()
                val daysUntil = ChronoUnit.DAYS.between(LocalDate.now(), scheduledDate).toInt().coerceAtLeast(1)
                
                val recommendation = if (amount > 0 && daysUntil > 0) {
                    createSavingsRecommendation(amount, daysUntil)
                } else null
                
                ScheduledExpenseCase(
                    id = id,
                    title = title,
                    description = description,
                    dueDate = scheduledDate,
                    amount = amount,
                    severity = severityEnum,
                    isResolved = resolved,
                    category = category,
                    source = source,
                    isRecurring = parseAdditionalData("isRecurring")?.toBooleanStrictOrNull() ?: false,
                    savingsRecommendation = recommendation,
                    suggestedResolutions = generateResolutionsForExpense(category, amount),
                )
            }
            "INCOME" -> IncomeCase(
                id = id,
                title = title,
                description = description,
                dueDate = date ?: LocalDate.now(),
                amount = amount,
                severity = severityEnum,
                isResolved = resolved,
                source = parseAdditionalData("source") ?: "SALARY",
            )
            else -> ScheduledExpenseCase(
                id = id,
                title = title,
                description = description,
                dueDate = date ?: LocalDate.now(),
                amount = amount,
                severity = severityEnum,
                isResolved = resolved,
                category = "OTHER",
                source = "UNKNOWN",
            )
        }
    }

    private fun createSavingsRecommendation(amount: Double, daysUntil: Int): SavingsRecommendation {
        val daily = amount / daysUntil
        val weekly = daily * 7
        val monthly = daily * 30

        val riskLevel = when {
            daily > 1000 -> RiskLevel.HIGH
            daily > 500 -> RiskLevel.MEDIUM
            else -> RiskLevel.LOW
        }

        val recommendationText = when (riskLevel) {
            RiskLevel.LOW ->
                "Откладывайте по ${daily.toInt()} ₽ в день, чтобы накопить нужную сумму без ущерба для бюджета."
            RiskLevel.MEDIUM ->
                "Рекомендуем сократить развлекательные расходы на ${(weekly * 0.3).toInt()} ₽ в неделю для достижения цели."
            RiskLevel.HIGH ->
                "Цель амбициозная. Рассмотрите возможность частичного использования накоплений или отложите покупку."
        }

        return SavingsRecommendation(
            suggestedDailyAmount = daily,
            suggestedWeeklyAmount = weekly,
            suggestedMonthlyAmount = monthly,
            totalToSave = amount,
            daysUntilExpense = daysUntil,
            recommendationText = recommendationText,
            riskLevel = riskLevel,
        )
    }

    private fun generateResolutionsForExpense(category: String, amount: Double): List<CaseResolution> {
        return when (category.lowercase()) {
            "садик", "детский сад" -> listOf(
                CaseResolution.RescheduleResolution(
                    id = "reschedule_kindergarten",
                    title = "Перенести оплату садика",
                    description = "Отложить платеж до следующей зарплаты",
                    recommendedFor = listOf("kindergarten"),
                ),
                CaseResolution.UseSavingsResolution(),
                CaseResolution.CreditLimitResolution(
                    id = "credit_kindergarten",
                    title = "Короткий лимит",
                    description = "Взять в долг до зарплаты ${amount.toInt()} ₽",
                    recommendedFor = listOf("kindergarten"),
                    limitAmount = amount,
                ),
            )
            "жкх", "коммунальные" -> listOf(
                CaseResolution.RescheduleResolution(
                    id = "reschedule_utility",
                    title = "Перенести платеж ЖКХ",
                    description = "Попросить рассрочку или перенести на другой период",
                    recommendedFor = listOf("utility"),
                ),
                CaseResolution.ReduceExpenseResolution(
                    id = "reduce_utility",
                    title = "Найти более дешевый тариф",
                    description = "Сравнить предложения других поставщиков",
                    recommendedFor = listOf("utility"),
                ),
            )
            else -> listOf(
                CaseResolution.UseSavingsResolution(),
                CaseResolution.CreditLimitResolution(
                    id = "credit_other",
                    title = "Короткий лимит до зарплаты",
                    description = "Взять в долг недостающую сумму ${amount.toInt()} ₽",
                    recommendedFor = listOf("other"),
                    limitAmount = amount,
                ),
            )
        }
    }

    private fun FinanceCaseEntity.parseAdditionalData(key: String): String? {
        return additionalData.split(";")
            .map { it.split(":") }
            .filter { it.size == 2 }
            .find { it[0] == key }?.get(1)
    }

    private fun parseDouble(value: String?): Double? = value?.toDoubleOrNull()

    private fun parseInt(value: String?): Int? = value?.toIntOrNull()

    private fun FinanceCaseEntity.parseAdditionalDataList(key: String): List<String> {
        return parseAdditionalData(key)?.split(",")?.filter { it.isNotEmpty() } ?: emptyList()
    }

    companion object {
        fun createAdditionalData(vararg pairs: Pair<String, String>): String {
            return pairs.joinToString(";") { "${it.first}:${it.second}" }
        }
    }
}
