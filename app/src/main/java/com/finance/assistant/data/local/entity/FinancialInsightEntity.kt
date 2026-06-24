package com.finance.assistant.data.local.entity

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity(tableName = "financial_insights")
data class FinancialInsightEntity(
    @PrimaryKey(autoGenerate = true)
    val id: Long = 0,
    val type: String,
    val title: String,
    val description: String,
    val severity: String,
    val dateMillis: Long,
    val relatedAmount: Double? = null,
    val isRead: Boolean = false,
)
