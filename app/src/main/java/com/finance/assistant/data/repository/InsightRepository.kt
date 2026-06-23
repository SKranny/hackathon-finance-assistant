package com.finance.assistant.data.repository

import com.finance.assistant.data.local.dao.FinancialInsightDao
import com.finance.assistant.data.local.entity.FinancialInsightEntity
import com.finance.assistant.domain.model.FinancialInsight
import com.finance.assistant.domain.model.InsightSeverity
import com.finance.assistant.domain.model.InsightType
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class InsightRepository @Inject constructor(
    private val insightDao: FinancialInsightDao,
) {

    fun getAllInsights(): Flow<List<FinancialInsight>> =
        insightDao.getAllInsights().map { entities -> entities.map { it.toDomain() } }

    fun getUnreadInsights(): Flow<List<FinancialInsight>> =
        insightDao.getUnreadInsights().map { entities -> entities.map { it.toDomain() } }

    suspend fun insert(insight: FinancialInsight) =
        insightDao.insert(insight.toEntity())

    suspend fun insertAll(insights: List<FinancialInsight>) =
        insightDao.insertAll(insights.map { it.toEntity() })

    suspend fun markAsRead(id: Long) = insightDao.markAsRead(id)

    private fun FinancialInsightEntity.toDomain() = FinancialInsight(
        id = id,
        type = try { InsightType.valueOf(type) } catch (_: Exception) { InsightType.UPCOMING_EXPENSE },
        title = title,
        description = description,
        severity = try { InsightSeverity.valueOf(severity) } catch (_: Exception) { InsightSeverity.INFO },
        date = Instant.ofEpochMilli(dateMillis).atZone(ZoneId.systemDefault()).toLocalDate(),
        relatedAmount = relatedAmount,
        isRead = isRead,
    )

    private fun FinancialInsight.toEntity() = FinancialInsightEntity(
        id = id,
        type = type.name,
        title = title,
        description = description,
        severity = severity.name,
        dateMillis = date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
        relatedAmount = relatedAmount,
        isRead = isRead,
    )
}
