package com.finance.assistant.data.objectbox.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.time.LocalDate

@Entity
data class UserProfileEntity(
    @Id var id: Long = 0,
    var name: String = "",
    var salary: Double = 0.0,
    var salaryDay: Int = 1,
    var balance: Double = 0.0,
    var nextSalaryDate: Long = 0,
    var createdAt: Long = 0,
    var updatedAt: Long = 0,
) {
    fun getNextSalaryDateAsLocalDate(): LocalDate =
        LocalDate.ofEpochDay(nextSalaryDate)

    fun getCreatedAtAsLocalDate(): LocalDate =
        LocalDate.ofEpochDay(createdAt)
}
