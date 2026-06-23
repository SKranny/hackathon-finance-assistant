package com.finance.assistant.data.objectbox.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.time.LocalDate

@Entity
data class RecurringExpenseEntity(
    @Id var id: Long = 0,
    var title: String = "",
    var amount: Double = 0.0,
    var category: String = "",
    var description: String = "",
    var frequency: String = "MONTHLY",
    var startDate: Long = 0,
    var lastPaidDate: Long = 0,
    var nextPaymentDate: Long = 0,
    var isActive: Boolean = true,
    var source: String = "",
) {
    fun getStartDateAsLocalDate(): LocalDate =
        LocalDate.ofEpochDay(startDate)

    fun getLastPaidDateAsLocalDate(): LocalDate? =
        if (lastPaidDate > 0) LocalDate.ofEpochDay(lastPaidDate) else null

    fun getNextPaymentDateAsLocalDate(): LocalDate =
        LocalDate.ofEpochDay(nextPaymentDate)
}

enum class RecurringFrequency {
    DAILY, WEEKLY, MONTHLY, QUARTERLY, YEARLY
}
