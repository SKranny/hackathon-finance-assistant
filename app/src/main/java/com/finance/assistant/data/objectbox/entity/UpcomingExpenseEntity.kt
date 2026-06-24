package com.finance.assistant.data.objectbox.entity

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id
import java.time.LocalDate

@Entity
data class UpcomingExpenseEntity(
    @Id var id: Long = 0,
    var title: String = "",
    var amount: Double = 0.0,
    var dueDate: Long = 0,
    var category: String = "",
    var description: String = "",
    var isPaid: Boolean = false,
    var source: String = "",
    var notificationSent: Boolean = false,
) {
    fun getDueDateAsLocalDate(): LocalDate =
        LocalDate.ofEpochDay(dueDate)
}
