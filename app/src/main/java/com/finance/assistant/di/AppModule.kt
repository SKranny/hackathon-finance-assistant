package com.finance.assistant.di

import android.content.Context
import com.finance.assistant.data.local.FinanceDatabase
import com.finance.assistant.data.local.dao.FinancialInsightDao
import com.finance.assistant.data.local.dao.TransactionDao
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.android.qualifiers.ApplicationContext
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object AppModule {

    @Provides
    @Singleton
    fun provideFinanceDatabase(@ApplicationContext context: Context): FinanceDatabase =
        FinanceDatabase.buildDatabase(context)

    @Provides
    fun provideTransactionDao(db: FinanceDatabase): TransactionDao = db.transactionDao()

    @Provides
    fun provideFinancialInsightDao(db: FinanceDatabase): FinancialInsightDao = db.financialInsightDao()
}
