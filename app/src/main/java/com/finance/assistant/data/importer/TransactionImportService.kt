package com.finance.assistant.data.importer

import android.content.Context
import android.net.Uri
import com.finance.assistant.domain.model.Transaction
import com.finance.assistant.domain.model.TransactionCategory
import com.finance.assistant.domain.model.TransactionSource
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext
import java.io.BufferedReader
import java.io.InputStreamReader
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.time.format.DateTimeParseException
import javax.inject.Inject
import javax.inject.Singleton

sealed class ImportResult {
    data class Success(val transactions: List<Transaction>, val imported: Int, val skipped: Int) : ImportResult()
    data class Error(val message: String, val line: Int? = null) : ImportResult()
}

data class CsvColumn(
    val date: Int,
    val amount: Int,
    val title: Int,
    val category: Int,
    val description: Int = -1,
)

@Singleton
class TransactionImportService @Inject constructor(
    @ApplicationContext private val context: Context,
) {

    private val dateFormatters = listOf(
        DateTimeFormatter.ofPattern("dd.MM.yyyy"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("MM/dd/yyyy"),
        DateTimeFormatter.ofPattern("dd-MM-yyyy"),
    )

    suspend fun importFromCsv(uri: Uri): ImportResult = withContext(Dispatchers.IO) {
        try {
            val inputStream = context.contentResolver.openInputStream(uri)
                ?: return@withContext ImportResult.Error("Не удалось открыть файл")

            val reader = BufferedReader(InputStreamReader(inputStream))
            val lines = reader.readLines()
            reader.close()

            if (lines.isEmpty()) {
                return@withContext ImportResult.Error("Файл пуст")
            }

            val header = lines.first()
            val columns = parseHeader(header)
            val transactions = mutableListOf<Transaction>()
            var skipped = 0

            for (i in 1 until lines.size) {
                val line = lines[i].trim()
                if (line.isEmpty()) continue

                val transaction = parseLine(line, columns, i + 1)
                if (transaction != null) {
                    transactions.add(transaction)
                } else {
                    skipped++
                }
            }

            ImportResult.Success(
                transactions = transactions,
                imported = transactions.size,
                skipped = skipped,
            )
        } catch (e: Exception) {
            ImportResult.Error("Ошибка импорта: ${e.message}")
        }
    }

    suspend fun importFromCsvString(csvContent: String): ImportResult = withContext(Dispatchers.IO) {
        try {
            val lines = csvContent.lines().filter { it.isNotBlank() }
            if (lines.isEmpty()) {
                return@withContext ImportResult.Error("Пустое содержимое")
            }

            val columns = parseHeader(lines.first())
            val transactions = mutableListOf<Transaction>()
            var skipped = 0

            for (i in 1 until lines.size) {
                val line = lines[i].trim()
                if (line.isEmpty()) continue

                val transaction = parseLine(line, columns, i + 1)
                if (transaction != null) {
                    transactions.add(transaction)
                } else {
                    skipped++
                }
            }

            ImportResult.Success(
                transactions = transactions,
                imported = transactions.size,
                skipped = skipped,
            )
        } catch (e: Exception) {
            ImportResult.Error("Ошибка импорта: ${e.message}")
        }
    }

    fun createManualTransaction(
        title: String,
        amount: Double,
        date: LocalDate,
        category: TransactionCategory,
        description: String = "",
    ): Transaction {
        return Transaction(
            title = title,
            amount = amount,
            date = date,
            category = category,
            source = TransactionSource.MANUAL,
            description = description,
        )
    }

    private fun parseHeader(header: String): CsvColumn {
        val columns = header.split(";").map { it.trim().lowercase() }

        return CsvColumn(
            date = columns.indexOfFirst { it in listOf("date", "дата", "день", "period") },
            amount = columns.indexOfFirst { it in listOf("amount", "sum", "сумма", "сум", "money", "ценa") },
            title = columns.indexOfFirst { it in listOf("title", "name", "description", "описание", "наименование", "comment") },
            category = columns.indexOfFirst { it in listOf("category", "категория", "type", "тип") },
            description = columns.indexOfFirst { it in listOf("note", "notes", "comment", "комментарий", "memo") },
        )
    }

    private fun parseLine(line: String, columns: CsvColumn, lineNumber: Int): Transaction? {
        val parts = parseCsvLine(line)
        if (parts.size < 3) return null

        val dateStr = if (columns.date >= 0 && columns.date < parts.size) parts[columns.date] else return null
        val amountStr = if (columns.amount >= 0 && columns.amount < parts.size) parts[columns.amount] else return null
        val title = if (columns.title >= 0 && columns.title < parts.size) parts[columns.title] else "Без названия"
        val description = if (columns.description >= 0 && columns.description < parts.size) parts[columns.description] else ""

        val date = parseDate(dateStr) ?: return null
        val amount = parseAmount(amountStr) ?: return null
        val category = if (columns.category >= 0 && columns.category < parts.size) {
            parseCategory(parts[columns.category])
        } else {
            TransactionCategory.OTHER
        }

        return Transaction(
            title = title.trim(),
            amount = amount,
            date = date,
            category = category,
            source = TransactionSource.MANUAL,
            description = description.trim(),
        )
    }

    private fun parseCsvLine(line: String): List<String> {
        val result = mutableListOf<String>()
        var current = StringBuilder()
        var inQuotes = false

        for (char in line) {
            when {
                char == '"' -> inQuotes = !inQuotes
                char == ';' && !inQuotes -> {
                    result.add(current.toString().trim())
                    current = StringBuilder()
                }
                else -> current.append(char)
            }
        }
        result.add(current.toString().trim())
        return result
    }

    private fun parseDate(dateStr: String): LocalDate? {
        val cleaned = dateStr.trim()
        for (formatter in dateFormatters) {
            try {
                return LocalDate.parse(cleaned, formatter)
            } catch (_: DateTimeParseException) {}
        }
        return null
    }

    private fun parseAmount(amountStr: String): Double? {
        val cleaned = amountStr
            .replace(" ", "")
            .replace(",", ".")
            .replace("₽", "")
            .replace("₸", "")
            .replace("$", "")
            .replace("р.", "")
            .replace("тенге", "")

        return cleaned.toDoubleOrNull()
    }

    private fun parseCategory(categoryStr: String): TransactionCategory {
        val lower = categoryStr.lowercase().trim()
        return when {
            lower.contains("еда") || lower.contains("food") || lower.contains("продукт") || lower.contains("grocery") ||
            lower.contains("шаш") || lower.contains("азық") -> TransactionCategory.FOOD

            lower.contains("транспорт") || lower.contains("transport") || lower.contains("такси") ||
            lower.contains("метро") || lower.contains("bus") || lower.contains("көлік") -> TransactionCategory.TRANSPORT

            lower.contains("жилье") || lower.contains("housing") || lower.contains("аренд") ||
            lower.contains("rent") || lower.contains("тұрғын") -> TransactionCategory.HOUSING

            lower.contains("коммуналь") || lower.contains("utilities") || lower.contains("жкх") ||
            lower.contains("коммуналды") -> TransactionCategory.UTILITIES

            lower.contains("развлеч") || lower.contains("entertainment") || lower.contains("кино") ||
            lower.contains("концерт") || lower.contains("ойын") -> TransactionCategory.ENTERTAINMENT

            lower.contains("медицин") || lower.contains("health") || lower.contains("аптек") ||
            lower.contains("дәрі") || lower.contains("medical") -> TransactionCategory.HEALTHCARE

            lower.contains("образование") || lower.contains("education") || lower.contains("курс") ||
            lower.contains("білім") || lower.contains("course") -> TransactionCategory.EDUCATION

            lower.contains("шопинг") || lower.contains("shopping") || lower.contains("одежд") ||
            lower.contains("clothes") || lower.contains("киім") -> TransactionCategory.SHOPPING

            lower.contains("подписк") || lower.contains("subscription") || lower.contains("netflix") ||
            lower.contains("spotify") || lower.contains("жазылым") -> TransactionCategory.SUBSCRIPTION

            lower.contains("зарплат") || lower.contains("salary") || lower.contains("жалақы") ||
            lower.contains("income") || lower.contains("перевод") -> TransactionCategory.SALARY

            lower.contains("перевод") || lower.contains("transfer") || lower.contains("аударым") -> TransactionCategory.TRANSFER

            else -> TransactionCategory.OTHER
        }
    }
}
