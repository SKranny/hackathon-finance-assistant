package com.finance.assistant.data.objectbox.entity.case

import io.objectbox.annotation.Entity
import io.objectbox.annotation.Id

@Entity
data class FinanceCaseEntity(
    @Id var id: Long = 0,
    var caseType: String = "",
    var title: String = "",
    var description: String = "",
    var dueDate: Long = 0,
    var amount: Double = 0.0,
    var severity: String = "INFO",
    var isResolved: Boolean = false,
    var additionalData: String = "",
)

@Entity
data class ChatMessageEntity(
    @Id var id: Long = 0,
    var role: String = "",
    var content: String = "",
    var timestamp: Long = 0,
    var isRead: Boolean = false,
)
