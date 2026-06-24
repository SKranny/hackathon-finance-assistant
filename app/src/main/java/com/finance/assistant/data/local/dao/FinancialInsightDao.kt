package com.finance.assistant.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.finance.assistant.data.local.entity.FinancialInsightEntity
import kotlinx.coroutines.flow.Flow

@Dao
interface FinancialInsightDao {

    @Query("SELECT * FROM financial_insights ORDER BY dateMillis DESC")
    fun getAllInsights(): Flow<List<FinancialInsightEntity>>

    @Query("SELECT * FROM financial_insights WHERE isRead = 0 ORDER BY dateMillis DESC")
    fun getUnreadInsights(): Flow<List<FinancialInsightEntity>>

    @Query("SELECT * FROM financial_insights WHERE severity = :severity ORDER BY dateMillis DESC")
    fun getInsightsBySeverity(severity: String): Flow<List<FinancialInsightEntity>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insert(insight: FinancialInsightEntity)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAll(insights: List<FinancialInsightEntity>)

    @Query("UPDATE financial_insights SET isRead = 1 WHERE id = :id")
    suspend fun markAsRead(id: Long)

    @Delete
    suspend fun delete(insight: FinancialInsightEntity)

    @Query("DELETE FROM financial_insights")
    suspend fun deleteAll()
}
