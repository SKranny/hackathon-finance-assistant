package com.finance.assistant.data.repository

import com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity
import com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity_
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity_
import com.finance.assistant.data.objectbox.mapper.toDomain
import com.finance.assistant.data.objectbox.mapper.toEntity
import com.finance.assistant.domain.model.expense.RecurringExpense
import com.finance.assistant.domain.model.expense.UpcomingExpense
import io.objectbox.Box
import io.objectbox.kotlin.flow
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flowOn
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import java.time.LocalDate
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ExpenseRepository @Inject constructor(
    private val upcomingExpenseBox: Box<UpcomingExpenseEntity>,
    private val recurringExpenseBox: Box<RecurringExpenseEntity>,
) {

    suspend fun addUpcomingExpense(expense: UpcomingExpense): Long =
        withContext(Dispatchers.IO) {
            upcomingExpenseBox.put(expense.toEntity())
        }

    suspend fun updateUpcomingExpense(expense: UpcomingExpense) =
        withContext(Dispatchers.IO) {
            upcomingExpenseBox.put(expense.toEntity())
        }

    suspend fun deleteUpcomingExpense(id: Long) =
        withContext(Dispatchers.IO) {
            upcomingExpenseBox.remove(id)
        }

    suspend fun markUpcomingExpenseAsPaid(id: Long) =
        withContext(Dispatchers.IO) {
            upcomingExpenseBox.get(id)?.let {
                it.isPaid = true
                upcomingExpenseBox.put(it)
            }
        }

    suspend fun getUpcomingExpenseById(id: Long): UpcomingExpense? =
        withContext(Dispatchers.IO) {
            upcomingExpenseBox.get(id)?.toDomain()
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getUpcomingExpenses(): Flow<List<UpcomingExpense>> =
        upcomingExpenseBox.query()
            .equal(UpcomingExpenseEntity_.isPaid, false)
            .order(UpcomingExpenseEntity_.dueDate)
            .build()
            .flow()
            .map { list -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getUpcomingExpensesForDays(days: Int): Flow<List<UpcomingExpense>> {
        val today = LocalDate.now().toEpochDay()
        val endDate = LocalDate.now().plusDays(days.toLong()).toEpochDay()
        return upcomingExpenseBox.query()
            .between(UpcomingExpenseEntity_.dueDate, today, endDate)
            .equal(UpcomingExpenseEntity_.isPaid, false)
            .order(UpcomingExpenseEntity_.dueDate)
            .build()
            .flow()
            .map { list -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)
    }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getUnpaidUpcomingExpenses(): Flow<List<UpcomingExpense>> =
        upcomingExpenseBox.query()
            .equal(UpcomingExpenseEntity_.isPaid, false)
            .order(UpcomingExpenseEntity_.dueDate)
            .build()
            .flow()
            .map { list -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)

    suspend fun addRecurringExpense(expense: RecurringExpense): Long =
        withContext(Dispatchers.IO) {
            recurringExpenseBox.put(expense.toEntity())
        }

    suspend fun updateRecurringExpense(expense: RecurringExpense) =
        withContext(Dispatchers.IO) {
            recurringExpenseBox.put(expense.toEntity())
        }

    suspend fun deleteRecurringExpense(id: Long) =
        withContext(Dispatchers.IO) {
            recurringExpenseBox.remove(id)
        }

    suspend fun deactivateRecurringExpense(id: Long) =
        withContext(Dispatchers.IO) {
            recurringExpenseBox.get(id)?.let {
                it.isActive = false
                recurringExpenseBox.put(it)
            }
        }

    suspend fun getRecurringExpenseById(id: Long): RecurringExpense? =
        withContext(Dispatchers.IO) {
            recurringExpenseBox.get(id)?.toDomain()
        }

    suspend fun updateLastPaidDate(id: Long, date: LocalDate) =
        withContext(Dispatchers.IO) {
            recurringExpenseBox.get(id)?.let {
                it.lastPaidDate = date.toEpochDay()
                recurringExpenseBox.put(it)
            }
        }

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getActiveRecurringExpenses(): Flow<List<RecurringExpense>> =
        recurringExpenseBox.query()
            .equal(RecurringExpenseEntity_.isActive, true)
            .order(RecurringExpenseEntity_.nextPaymentDate)
            .build()
            .flow()
            .map { list -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)

    @OptIn(ExperimentalCoroutinesApi::class)
    fun getAllRecurringExpenses(): Flow<List<RecurringExpense>> =
        recurringExpenseBox.query()
            .order(RecurringExpenseEntity_.title)
            .build()
            .flow()
            .map { list -> list.map { it.toDomain() } }
            .flowOn(Dispatchers.IO)

    suspend fun getUpcomingRecurringPayments(limitDays: Int): List<RecurringExpense> =
        withContext(Dispatchers.IO) {
            val today = LocalDate.now().toEpochDay()
            val endDate = LocalDate.now().plusDays(limitDays.toLong()).toEpochDay()
            recurringExpenseBox.query()
                .between(RecurringExpenseEntity_.nextPaymentDate, today, endDate)
                .equal(RecurringExpenseEntity_.isActive, true)
                .order(RecurringExpenseEntity_.nextPaymentDate)
                .build()
                .find()
                .map { it.toDomain() }
        }

    suspend fun calculateTotalUpcomingExpenses(): Double =
        withContext(Dispatchers.IO) {
            val today = LocalDate.now().toEpochDay()
            val endOfMonth = LocalDate.now().plusMonths(1).withDayOfMonth(LocalDate.now().lengthOfMonth()).toEpochDay()
            upcomingExpenseBox.query()
                .between(UpcomingExpenseEntity_.dueDate, today, endOfMonth)
                .equal(UpcomingExpenseEntity_.isPaid, false)
                .build()
                .find()
                .sumOf { it.amount }
        }

    suspend fun calculateTotalRecurringExpenses(): Double =
        withContext(Dispatchers.IO) {
            recurringExpenseBox.query()
                .equal(RecurringExpenseEntity_.isActive, true)
                .build()
                .find()
                .sumOf { it.amount }
        }
}
