package com.finance.assistant.service

import android.service.notification.NotificationListenerService
import android.service.notification.StatusBarNotification
import com.finance.assistant.domain.model.Transaction
import com.finance.assistant.domain.model.TransactionCategory
import com.finance.assistant.domain.model.TransactionSource
import java.time.LocalDate
import java.util.regex.Pattern

class NotificationInterceptorService : NotificationListenerService() {

    private val parsingLogic = NotificationParsingLogic()

    override fun onNotificationPosted(sbn: StatusBarNotification?) {
        sbn ?: return

        val packageName = sbn.packageName ?: return
        val notification = sbn.notification ?: return
        val extras = notification.extras ?: return

        val title = extras.getCharSequence("android.title")?.toString() ?: ""
        val text = extras.getCharSequence("android.text")?.toString() ?: ""

        if (title.isBlank() && text.isBlank()) return

        val fullText = "$title\n$text"
        val transaction = parsingLogic.parse(fullText, packageName, sbn.postTime)

        if (transaction != null) {
            NotificationEventBus.emit(transaction)
        }
    }

    override fun onNotificationRemoved(sbn: StatusBarNotification?) {}
}

object NotificationEventBus {
    private val listeners = mutableListOf<(Transaction) -> Unit>()

    fun subscribe(listener: (Transaction) -> Unit) {
        listeners.add(listener)
    }

    fun unsubscribe(listener: (Transaction) -> Unit) {
        listeners.remove(listener)
    }

    fun emit(transaction: Transaction) {
        listeners.forEach { it(transaction) }
    }
}

class NotificationParsingLogic {

    private val bankPatterns = listOf(
        BankPattern("Sberbank", listOf("sberbank", "сбербанк", "сбер", "sber"), null),
        BankPattern("Т-Банк", listOf("tbank", "тбанк"), null),
        BankPattern("Alfa-Bank", listOf("alfa", "альфа", "alfabank"), null),
        BankPattern("VTB", listOf("vtb", "втб"), null),
        BankPattern("Kaspi", listOf("kaspi", "каспи", "қаспы"), null),
        BankPattern("Halyk Bank", listOf("halyk", "халык", "halykbank"), null),
    )

    private val skipPackagePatterns = listOf(
        "telega", "telegram", "whatsapp", "signal", "viber",
        "instagram", "facebook", "vk", "twitter", "tiktok",
        "chrome", "browser", "mail", "gmail",
        "calendar", "календарь", "keep", "notes",
        "spotify", "youtube", "netflix",
    )

    data class BankPattern(
        val name: String,
        val keywords: List<String>,
        val competitor: String? = null,
    )

    private val amountPatterns = listOf(
        Pattern.compile("""(?:списано|spent|debit|оплата|payment|жұмсалды)(?:[\s:]*)([\d\s]+[.,]\d{2})\s*(?:₽|р|руб|₸|тг|kzt| тенге|р\.)?""", Pattern.CASE_INSENSITIVE),
        Pattern.compile("""([\d\s]+[.,]\d{2})\s*(?:₽|р|руб|₸|тг|kzt)(?:\s|$)""", Pattern.CASE_INSENSITIVE),
        Pattern.compile("""(?:на\s+сумму\s+)([\d\s]+[.,]\d{2})""", Pattern.CASE_INSENSITIVE),
        Pattern.compile("""[\d\s]*([\d\s]+[.,]\d{2})\s*(?:тенге|kzt|сум)""", Pattern.CASE_INSENSITIVE),
        Pattern.compile("""\$([\d\s]+[.,]\d{2})""", Pattern.CASE_INSENSITIVE),
        Pattern.compile("""€([\d\s]+[.,]\d{2})""", Pattern.CASE_INSENSITIVE),
        Pattern.compile("""([\d\s]+[.,]\d{2})\s*(?:USD|EUR)""", Pattern.CASE_INSENSITIVE),
    )

    private val skipKeywords = listOf(
        "pin", "код", "code", "verify", "подтверд", "sms", "смс",
        "promo", "реклам", "advert", "спам", "бонус", "bonus",
        "скидка", "discount", "promocode", "промокод",
    )

    fun parse(text: String, packageName: String, timestamp: Long): Transaction? {
        if (skipPackagePatterns.any { packageName.contains(it, ignoreCase = true) }) {
            return null
        }

        val lowerText = text.lowercase()
        if (skipKeywords.any { lowerText.contains(it) }) {
            return null
        }

        val amount = extractAmount(text) ?: return null
        val bank = detectBank(lowerText)
        val title = extractTitle(text, bank)
        val category = guessCategory(lowerText, bank)

        return Transaction(
            title = title,
            amount = amount,
            category = category,
            date = java.time.LocalDate.now(),
            source = TransactionSource.NOTIFICATION,
            description = "from $packageName"
        )
    }

    private fun detectBank(text: String): BankPattern? {
        for (bank in bankPatterns) {
            if (bank.keywords.any { text.contains(it) }) {
                return bank
            }
        }
        return null
    }

    private fun extractAmount(text: String): Double? {
        for (pattern in amountPatterns) {
            val matcher = pattern.matcher(text)
            if (matcher.find()) {
                val amountStr = matcher.group(1)
                    ?.replace(" ", "")
                    ?.replace(",", ".")
                    ?: continue
                amountStr.toDoubleOrNull()?.let { return it }
            }
        }
        return null
    }

    private fun extractTitle(text: String, bank: BankPattern?): String {
        val lines = text.split("\n").map { it.trim() }.filter { it.isNotEmpty() }

        val skipPatterns = listOf(
            "оплата", "payment", "списание", "debit", "перевод", "transfer",
            "баланс", "balance", "остаток", "жұмсалды", "spent", "төлем",
            "к оплате", "к списанию", "amount", "сумма", "жалпы", "итого"
        )

        for (line in lines) {
            val lowerLine = line.lowercase()
            if (skipPatterns.any { lowerLine.contains(it) }) continue

            val amountInLine = extractAmount(line)
            if (amountInLine == null && line.length in 5..80) {
                return line.take(60)
            }
        }

        val cleanedBody = text
            .replace(Regex("""[\d\s]+[.,]\d{2}\s*(?:₽|р|руб|₸|тг|kzt| тенге|\$|€)?"""), "")
            .replace(Regex("""\b\d{4,}\b"""), "")
            .replace(Regex("""\b\w{1,3}\b"""), " ")
            .trim()
            .replace(Regex("""\s+"""), " ")

        return cleanedBody.take(60).ifEmpty { "Payment" }
    }

    private fun guessCategory(text: String, bank: BankPattern?): TransactionCategory {
        return when {
            containsAny(text, listOf(
                "продукт", "магазин", "супермаркет", "пятёрочка", "магнит", "ашан", "лента",
                "product", "grocery", "supermarket", "food", "market", "store",
                "азық", "түсім", "dollars", "hypermarket"
            )) -> TransactionCategory.FOOD

            containsAny(text, listOf(
                "такси", "uber", "метро", "транспорт", "авиа", "поезд", "самолёт",
                "taxi", "transport", "bus", "metro", "train", "flight",
                "көлік", "автобус", "поезд", "ұшақ", " rail"
            )) -> TransactionCategory.TRANSPORT

            containsAny(text, listOf(
                "жкх", "коммуналь", "электроэнерг", "газ", "вод", "отоплен",
                "utilities", "housing", "electricity", "gas", "water", "heating",
                " коммуналды", "жылу", "communal", "billing"
            )) -> TransactionCategory.UTILITIES

            containsAny(text, listOf(
                "подписк", "subscription", "spotify", "netflix", "ivi", "youtube premium",
                "memberships", "premium", "month", "year", "annual", "recurring",
                "жазылым"
            )) -> TransactionCategory.SUBSCRIPTION

            containsAny(text, listOf(
                "аптек", "лекарств", "больниц", "клиник", "doctor", "hospital", "pharmacy",
                "medicine", "health", "clinic", "medical",
                "дәрі", "емхана", "аурухана", "дәріхана", "медицина"
            )) -> TransactionCategory.HEALTHCARE

            containsAny(text, listOf(
                "школа", "универ", "курс", "образование", "книг", "education", "course",
                "school", "university", "book", "training", "lecture", "webinar",
                "білім", "университет", "курс", "оқу"
            )) -> TransactionCategory.EDUCATION

            containsAny(text, listOf(
                "одежд", "обувь", "clothes", "shoes", "nike", "adidas", "zara",
                "fashion", "wear", "apparel", "footwear", "clothing",
                "киім", "аяқ киім", "dress", "jeans"
            )) -> TransactionCategory.SHOPPING

            containsAny(text, listOf(
                "ресторан", "кафе", "общепит", "delivery", "wolt", "deliveroo",
                "restaurant", "cafe", "coffee", "pizza", "burger", "food delivery",
                "мәшинен", "асхана", "базар", "кухня"
            )) -> TransactionCategory.FOOD

            containsAny(text, listOf(
                "зарплат", "salary", "жалақы", "income", "аванс", "начисление", "оклад",
                "wage", "payroll", "deposit"
            )) -> TransactionCategory.SALARY

            containsAny(text, listOf(
                "перевод", "transfer", "аударым", "send money", "receive",
                "между счетами", "between accounts"
            )) -> TransactionCategory.TRANSFER

            else -> TransactionCategory.OTHER
        }
    }

    private fun containsAny(text: String, list: List<String>): Boolean =
        list.any { text.contains(it) }
}
