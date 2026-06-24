package com.finance.assistant.domain.model

import java.time.LocalDateTime

data class CalendarEvent(
    val id: Long,
    val title: String,
    val description: String,
    val startTime: LocalDateTime,
    val endTime: LocalDateTime,
    val location: String? = null,
    val isAllDay: Boolean = false,
    val calendarName: String? = null,
    val possibleExpense: Boolean = false,
    val expenseAmount: Double? = null,
)
