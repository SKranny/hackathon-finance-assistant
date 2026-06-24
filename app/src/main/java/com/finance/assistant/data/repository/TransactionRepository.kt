package com.finance.assistant.data.repository

import com.finance.assistant.data.local.dao.TransactionDao
import com.finance.assistant.data.local.entity.TransactionEntity
import com.finance.assistant.domain.model.Transaction
import com.finance.assistant.domain.model.TransactionCategory
import com.finance.assistant.domain.model.TransactionSource
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class TransactionRepository @Inject constructor(
    private val transactionDao: TransactionDao,
) {

    fun getAllTransactions(): Flow<List<Transaction>> =
        transactionDao.getAllTransactions().map { entities -> entities.map { it.toDomain() } }

    fun getTransactionsBetween(start: LocalDate, end: LocalDate): Flow<List<Transaction>> =
        transactionDao.getTransactionsBetween(
            startMillis = start.toEpochMillis(),
            endMillis = end.toEpochMillis(),
        ).map { entities -> entities.map { it.toDomain() } }

    fun getTransactionsByCategory(category: TransactionCategory): Flow<List<Transaction>> =
        transactionDao.getTransactionsByCategory(category.name).map { entities ->
            entities.map { it.toDomain() }
        }

    fun getTotalBetween(start: LocalDate, end: LocalDate): Flow<Double?> =
        transactionDao.getTotalBetween(start.toEpochMillis(), end.toEpochMillis())

    fun getRecurringTransactions(): Flow<List<Transaction>> =
        transactionDao.getRecurringTransactions().map { entities -> entities.map { it.toDomain() } }

    suspend fun insert(transaction: Transaction) =
        transactionDao.insert(transaction.toEntity())

    suspend fun insertAll(transactions: List<Transaction>) =
        transactionDao.insertAll(transactions.map { it.toEntity() })

    private fun TransactionEntity.toDomain() = Transaction(
        id = id,
        title = title,
        amount = amount,
        category = try { TransactionCategory.valueOf(category) } catch (_: Exception) { TransactionCategory.OTHER },
        date = Instant.ofEpochMilli(dateMillis).atZone(ZoneId.systemDefault()).toLocalDate(),
        source = try { TransactionSource.valueOf(source) } catch (_: Exception) { TransactionSource.MANUAL },
        description = description,
        isRecurring = isRecurring,
    )

    private fun Transaction.toEntity() = TransactionEntity(
        id = id,
        title = title,
        amount = amount,
        category = category.name,
        dateMillis = date.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli(),
        source = source.name,
        description = description,
        isRecurring = isRecurring,
    )

    private fun LocalDate.toEpochMillis(): Long =
        this.atStartOfDay(ZoneId.systemDefault()).toInstant().toEpochMilli()
}
