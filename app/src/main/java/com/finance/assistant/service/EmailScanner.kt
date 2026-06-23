package com.finance.assistant.service

import com.finance.assistant.domain.model.Transaction
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class EmailScanner @Inject constructor() {

    suspend fun scanFinanceEmails(daysBack: Int = 90): List<Transaction> {
        return emptyList()
    }
}
