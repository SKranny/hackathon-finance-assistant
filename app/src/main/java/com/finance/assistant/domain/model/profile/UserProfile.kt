package com.finance.assistant.domain.model.profile

import java.time.LocalDate

data class UserProfile(
    val id: Long = 0,
    val name: String,
    val salary: Double,
    val salaryDay: Int,
    val balance: Double,
    val nextSalaryDate: LocalDate,
    val createdAt: LocalDate = LocalDate.now(),
    val updatedAt: LocalDate = LocalDate.now(),
)

fun UserProfile.getDaysUntilSalary(): Long {
    val today = LocalDate.now()
    return java.time.temporal.ChronoUnit.DAYS.between(today, nextSalaryDate)
}

fun UserProfile.getFreeMoneyBeforeSalary(): Double {
    val daysUntilSalary = getDaysUntilSalary()
    val salaryPerDay = salary / 30.0
    return balance + (salaryPerDay * daysUntilSalary)
}
