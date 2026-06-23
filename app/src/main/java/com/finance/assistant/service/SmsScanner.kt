package com.finance.assistant.service

import android.content.ContentResolver
import android.provider.Telephony
import com.finance.assistant.domain.model.Transaction
import com.finance.assistant.domain.model.TransactionCategory
import com.finance.assistant.domain.model.TransactionSource
import java.time.Instant
import java.time.LocalDate
import java.time.ZoneId
import java.util.regex.Pattern
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class SmsScanner @Inject constructor(
    private val contentResolver: ContentResolver,
) {

    fun scanFinanceMessages(daysBack: Int = 90): List<Transaction> {
        val transactions = mutableListOf<Transaction>()
        val now = System.currentTimeMillis()
        val startTime = now - daysBack * 24L * 60 * 60 * 1000

        val projection = arrayOf(
            Telephony.Sms._ID,
            Telephony.Sms.ADDRESS,
            Telephony.Sms.BODY,
            Telephony.Sms.DATE,
        )

        val selection = "${Telephony.Sms.DATE} >= ?"
        val selectionArgs = arrayOf(startTime.toString())

        val cursor = contentResolver.query(
            Telephony.Sms.CONTENT_URI,
            projection,
            selection,
            selectionArgs,
            "${Telephony.Sms.DATE} DESC",
        )

        cursor?.use {
            while (it.moveToNext()) {
                val body = it.getString(2) ?: continue
                val parsed = parseTransactionFromSms(body)
                if (parsed != null) {
                    transactions.add(
                        parsed.copy(
                            source = TransactionSource.SMS,
                            date = Instant.ofEpochMilli(it.getLong(3))
                                .atZone(ZoneId.systemDefault()).toLocalDate(),
                        )
                    )
                }
            }
        }
        return transactions
    }

    private fun parseTransactionFromSms(body: String): Transaction? {
        val amountPattern = Pattern.compile("""[\d\s]*([\d\s]+[\.,]\d{2})\s*(р|₽|руб)""")
        val matcher = amountPattern.matcher(body)
        if (!matcher.find()) return null

        val amountStr = matcher.group(1)?.replace(" ", "")?.replace(",", ".") ?: return null
        val amount = amountStr.toDoubleOrNull() ?: return null

        val title = (body.take(80).trim())
        val category = guessCategory(body)

        return Transaction(
            title = title,
            amount = amount,
            category = category,
            date = LocalDate.now(),
            source = TransactionSource.SMS,
        )
    }

    private fun guessCategory(text: String): TransactionCategory {
        val lower = text.lowercase()
        return when {
            lower.containsAny(listOf("продукт", "магазин", "супермаркет", "пятёрочка", "магнит", "перекрёсток")) ->
                TransactionCategory.FOOD
            lower.containsAny(listOf("такси", "яндекс", "uber", "метро", "транспорт", "авиа", "жд")) ->
                TransactionCategory.TRANSPORT
            lower.containsAny(listOf("коммуналь", "жкх", "электроэнерг")) ->
                TransactionCategory.UTILITIES
            lower.containsAny(listOf("подписк", "subscription", "spotify", "netflix")) ->
                TransactionCategory.SUBSCRIPTION
            lower.containsAny(listOf("аптек", "лекарств", "больниц", "клиник")) ->
                TransactionCategory.HEALTHCARE
            else -> TransactionCategory.OTHER
        }
    }

    private fun String.containsAny(list: List<String>): Boolean =
        list.any { this.contains(it) }
}
