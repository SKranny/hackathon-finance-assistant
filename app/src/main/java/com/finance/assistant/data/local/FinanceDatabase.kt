package com.finance.assistant.data.local

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.finance.assistant.data.local.dao.FinancialInsightDao
import com.finance.assistant.data.local.dao.TransactionDao
import com.finance.assistant.data.local.entity.FinancialInsightEntity
import com.finance.assistant.data.local.entity.TransactionEntity

@Database(
    entities = [TransactionEntity::class, FinancialInsightEntity::class],
    version = 1,
    exportSchema = false,
)
abstract class FinanceDatabase : RoomDatabase() {
    abstract fun transactionDao(): TransactionDao
    abstract fun financialInsightDao(): FinancialInsightDao

    companion object {
        fun buildDatabase(context: Context): FinanceDatabase =
            Room.databaseBuilder(
                context.applicationContext,
                FinanceDatabase::class.java,
                "finance_assistant.db",
            ).build()
    }
}
