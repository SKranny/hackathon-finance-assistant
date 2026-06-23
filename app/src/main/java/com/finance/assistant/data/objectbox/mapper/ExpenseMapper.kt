package com.finance.assistant.data.objectbox.mapper

import com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity
import com.finance.assistant.data.objectbox.entity.UserProfileEntity
import com.finance.assistant.domain.model.expense.ExpenseSource
import com.finance.assistant.domain.model.expense.RecurringExpense
import com.finance.assistant.domain.model.expense.RecurringFrequency
import com.finance.assistant.domain.model.expense.UpcomingExpense
import com.finance.assistant.domain.model.profile.UserProfile
import java.time.LocalDate

fun UpcomingExpenseEntity.toDomain(): UpcomingExpense = UpcomingExpense(
    id = id,
    title = title,
    amount = amount,
    dueDate = getDueDateAsLocalDate(),
    category = category,
    description = description,
    isPaid = isPaid,
    source = ExpenseSource.valueOf(source.ifEmpty { "MANUAL" }),
    notificationSent = notificationSent,
)

fun UpcomingExpense.toEntity(): UpcomingExpenseEntity = UpcomingExpenseEntity(
    id = id,
    title = title,
    amount = amount,
    dueDate = dueDate.toEpochDay(),
    category = category,
    description = description,
    isPaid = isPaid,
    source = source.name,
    notificationSent = notificationSent,
)

fun RecurringExpenseEntity.toDomain(): RecurringExpense = RecurringExpense(
    id = id,
    title = title,
    amount = amount,
    category = category,
    description = description,
    frequency = try { RecurringFrequency.valueOf(frequency) } catch (e: Exception) { RecurringFrequency.MONTHLY },
    startDate = getStartDateAsLocalDate(),
    lastPaidDate = getLastPaidDateAsLocalDate(),
    nextPaymentDate = getNextPaymentDateAsLocalDate(),
    isActive = isActive,
    source = ExpenseSource.valueOf(source.ifEmpty { "MANUAL" }),
)

fun RecurringExpense.toEntity(): RecurringExpenseEntity = RecurringExpenseEntity(
    id = id,
    title = title,
    amount = amount,
    category = category,
    description = description,
    frequency = frequency.name,
    startDate = startDate.toEpochDay(),
    lastPaidDate = lastPaidDate?.toEpochDay() ?: 0,
    nextPaymentDate = nextPaymentDate.toEpochDay(),
    isActive = isActive,
    source = source.name,
)

fun UserProfileEntity.toDomain(): UserProfile = UserProfile(
    id = id,
    name = name,
    salary = salary,
    salaryDay = salaryDay,
    balance = balance,
    nextSalaryDate = getNextSalaryDateAsLocalDate(),
    createdAt = getCreatedAtAsLocalDate(),
)

fun UserProfile.toEntity(): UserProfileEntity = UserProfileEntity(
    id = id,
    name = name,
    salary = salary,
    salaryDay = salaryDay,
    balance = balance,
    nextSalaryDate = nextSalaryDate.toEpochDay(),
    createdAt = createdAt.toEpochDay(),
    updatedAt = updatedAt.toEpochDay(),
)
