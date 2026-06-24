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
class TransactionScanner @Inject constructor(
    private val contentResolver: ContentResolver,
) {

    private val smsParsingLogic = SmsParsingLogic()
    private val notificationParsingLogic = NotificationParsingLogic()

    fun scanSmsTransactions(daysBack: Int = 90): List<Transaction> {
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
                val address = it.getString(1) ?: ""
                val body = it.getString(2) ?: continue
                val parsed = smsParsingLogic.parse(body, address)
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

    fun parseNotification(text: String, packageName: String): Transaction? {
        return notificationParsingLogic.parse(text, packageName, System.currentTimeMillis())
    }
}

class SmsParsingLogic {

    private val marketplacePatterns = listOf(
        MarketplacePattern("OZON", listOf("ozon", "озон", "o!"), "Wildberries"),
        MarketplacePattern("Wildberries", listOf("wildberri", "вайлдберри", "вб", "wb", "вилдберри"), "OZON"),
        MarketplacePattern("Lamoda", listOf("lamoda", "ламода"), null),
        MarketplacePattern("Яндекс Маркет", listOf("яндекс маркет", "ymarket", "yandex market", "yandex.маркет"), null),
        MarketplacePattern("Мегамаркет", listOf("мегамаркет", "megamarket", "мегамаркет"), null),
        MarketplacePattern("Amazon", listOf("amazon", "амазон"), null),
        MarketplacePattern("Kaspi", listOf("kaspi", "каспи", "қаспы"), null),
        MarketplacePattern("Google Play", listOf("google play", "google.play", "googleplay"), null),
        MarketplacePattern("Apple Store", listOf("apple store", "app store", "itunes", "apple.com"), null),
        MarketplacePattern("Spotify", listOf("spotify", "спотифай"), null),
        MarketplacePattern("YouTube", listOf("youtube", "ютуб", "youtu.be"), null),
    )

    data class MarketplacePattern(
        val name: String,
        val keywords: List<String>,
        val competitor: String? = null,
    )

    fun parse(body: String, address: String): Transaction? {
        val lowerBody = body.lowercase()
        val lowerAddress = address.lowercase()

        val amount = extractAmount(body) ?: return null
        val marketplace = detectMarketplace(lowerBody, lowerAddress)
        val title = extractTitle(body, marketplace)
        val category = guessCategory(body, marketplace)

        return Transaction(
            title = title,
            amount = amount,
            category = category,
            date = LocalDate.now(),
            source = TransactionSource.SMS,
        )
    }

    private fun detectMarketplace(body: String, address: String): MarketplacePattern? {
        for (mp in marketplacePatterns) {
            if (mp.keywords.any { body.contains(it) || address.contains(it) }) {
                return mp
            }
        }
        return null
    }

    private fun extractAmount(text: String): Double? {
        val patterns = listOf(
            Pattern.compile("""(?:sum|сумм|оплат|spent|spi|итого|всего|total|жалпы)(?:[\s:]*)([\d\s]+[.,]\d{2})\s*(?:₽|р|руб|₸|тг|kzt| тенге)?""", Pattern.CASE_INSENSITIVE),
            Pattern.compile("""([\d\s]+[.,]\d{2})\s*(?:₽|р|руб|₸|тг|kzt| тенге)(?:\s|$)""", Pattern.CASE_INSENSITIVE),
            Pattern.compile("""(?:на\s+)([\d\s]+[.,]\d{2})"""),
            Pattern.compile("""[\d\s]*([\d\s]+[.,]\d{2})\s*(?:тенге|kzt|сум)""", Pattern.CASE_INSENSITIVE),
            Pattern.compile("""\$([\d\s]+[.,]\d{2})""", Pattern.CASE_INSENSITIVE),
            Pattern.compile("""€([\d\s]+[.,]\d{2})""", Pattern.CASE_INSENSITIVE),
        )

        for (pattern in patterns) {
            val matcher = pattern.matcher(text)
            if (matcher.find()) {
                val amountStr = matcher.group(1)?.replace(" ", "")?.replace(",", ".") ?: continue
                amountStr.toDoubleOrNull()?.let { return it }
            }
        }
        return null
    }

    private fun extractTitle(body: String, marketplace: MarketplacePattern?): String {
        val lines = body.split("\n").map { it.trim() }.filter { it.isNotEmpty() }

        if (marketplace != null) {
            val skipPatterns = listOf(
                "заказ", "order", "оплата", "покупк", "жеткізу", "доставк", "төлем", "payment",
                "покупка", "purchase", "buy", "spent", "сумм", "итого", "жалпы", "total",
                "төлеу", "оплатить", "керек", "shipment", "delivery", "жіберу"
            )
            for (line in lines) {
                val lowerLine = line.lowercase()
                if (skipPatterns.any { lowerLine.contains(it) }) {
                    continue
                }

                val amountInLine = extractAmount(line)
                if (amountInLine == null && line.length in 10..100) {
                    return line.take(60)
                }
            }

            val titleKeywords = listOf(
                "товар", "позиция", "item", "артикул", "sku", "тауар", "positions", "product",
                "наименование", "название", "name", "описание", "description", "атау", " зат",
                "commodity", "goods", "stuff"
            )
            for (line in lines) {
                if (titleKeywords.any { line.lowercase().contains(it) }) {
                    return line.take(60)
                }
            }

            if (lines.isNotEmpty()) {
                return lines.last().take(60)
            }
        }

        val cleanedBody = body
            .replace(Regex("""[\d\s]+[.,]\d{2}\s*(?:₽|р|руб|₸|тг|kzt| тенге|\$|€)?"""), "")
            .replace(Regex("""\b\d{4,}\b"""), "")
            .replace(Regex("""\b\w{1,3}\b"""), " ")
            .trim()
            .replace(Regex("""\s+"""), " ")

        return cleanedBody.take(60).ifEmpty { "Purchase" }
    }

    private fun guessCategory(text: String, marketplace: MarketplacePattern?): TransactionCategory {
        val lower = text.lowercase()

        if (marketplace != null) {
            return TransactionCategory.SHOPPING
        }

        return when {
            containsAny(lower, listOf(
                "продукт", "магазин", "супермаркет", "пятёрочка", "магнит", "перекрёсток", "ашан", "лента", "дикси",
                "product", "grocery", "supermarket", "food", "market", "store", "grocery store", "fresh food",
                "азық", "түсім", "шаруашылық", "dollars", " supermarket", "hypermarket"
            )) -> TransactionCategory.FOOD

            containsAny(lower, listOf(
                "такси", "яндекс", "uber", "метро", "транспорт", "авиа", "жд", "самолёт", "поезд",
                "transport", "taxi", "bus", "metro", "train", "flight", "airport",
                "көлік", "автобус", "поезд", "ұшақ", "метро", " rail", " aviation"
            )) -> TransactionCategory.TRANSPORT

            containsAny(lower, listOf(
                "коммуналь", "жкх", "электроэнерг", "газ", "вод", "отоплен", "квартплата",
                "utilities", "housing", "electricity", "gas", "water", "heating", "rent", "billing",
                " коммуналды", "жылу", "газ", "су", "communal"
            )) -> TransactionCategory.UTILITIES

            containsAny(lower, listOf(
                "подписк", "subscription", "spotify", "netflix", "ivi", "youtube", "apple", "google one",
                "подписки", "memberships", "premium", "会员", "subscription fee",
                "жазылым", "ошибка", " month", " year", "annual", "monthly", "recurring"
            )) -> TransactionCategory.SUBSCRIPTION

            containsAny(lower, listOf(
                "аптек", "лекарств", "больниц", "клиник", "doctor", "medic", "hospital", "pharmacy",
                "medicine", "drugstore", "health", "clinic", "medical", "treatment",
                "дәрі", "емхана", "аурухана", "дәріхана", "медицина", "терапия"
            )) -> TransactionCategory.HEALTHCARE

            containsAny(lower, listOf(
                "школа", "универ", "курс", "образование", "книг", "skillbox", "netology",
                "education", "school", "university", "course", "book", "learn", "training",
                "білім", "университет", "курс", "оқу", "lecture", "seminar", "webinar"
            )) -> TransactionCategory.EDUCATION

            containsAny(lower, listOf(
                "одежд", "обувь", "clothes", "shoes", "nike", "adidas", "zara", "h&m",
                "fashion", "wear", "apparel", "footwear", "clothing", "brand",
                "киім", "аяқ киим", "шапан", "dress", "jeans", "jacket"
            )) -> TransactionCategory.SHOPPING

            containsAny(lower, listOf(
                "общепит", "ресторан", "кафе", "доставка еды", "delivery", "wolt", "deliveroo",
                "restaurant", "cafe", "coffee", "pizza", "burger", "food delivery", "eats",
                "мәшинен", "асхана", "дәм", "базар", "кухня", "столовая"
            )) -> TransactionCategory.FOOD

            containsAny(lower, listOf(
                "зарплат", "salary", "жалақы", "income", "перевод", "npfl", "аванс",
                "жалғыз", "transfer", "deposit", "начисление", "оклад", "wage", "payroll"
            )) -> TransactionCategory.SALARY

            containsAny(lower, listOf(
                "перевод", "transfer", "аударым", "between accounts", "send money", "receive"
            )) -> TransactionCategory.TRANSFER

            containsAny(lower, listOf(
                "банк", "bank", "банковск", "card", "visa", "mastercard", " дебет", "credit",
                "кредит", "ипотек", " mortgage", "loan", "финанс", " finance"
            )) -> TransactionCategory.OTHER

            else -> TransactionCategory.OTHER
        }
    }

    private fun containsAny(text: String, list: List<String>): Boolean =
        list.any { text.contains(it) }
}
