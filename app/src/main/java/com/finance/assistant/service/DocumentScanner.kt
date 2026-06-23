package com.finance.assistant.service

import android.content.ContentResolver
import android.content.Context
import android.graphics.Bitmap
import android.graphics.BitmapFactory
import android.net.Uri
import android.os.Environment
import android.provider.MediaStore
import com.finance.assistant.domain.model.Transaction
import com.finance.assistant.domain.model.TransactionCategory
import com.finance.assistant.domain.model.TransactionSource
import com.google.mlkit.vision.common.InputImage
import com.google.mlkit.vision.text.TextRecognition
import com.google.mlkit.vision.text.latin.TextRecognizerOptions
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.suspendCancellableCoroutine
import kotlinx.coroutines.withContext
import java.io.File
import java.time.LocalDate
import java.time.format.DateTimeFormatter
import java.util.regex.Pattern
import javax.inject.Inject
import javax.inject.Singleton
import kotlin.coroutines.resume

@Singleton
class DocumentScanner @Inject constructor(
    @ApplicationContext private val context: Context,
    private val contentResolver: ContentResolver,
) {

    private val textRecognizer = TextRecognition.getClient(TextRecognizerOptions.DEFAULT_OPTIONS)
    private val parsingLogic = DocumentParsingLogic()

    private val supportedExtensions = listOf("jpg", "jpeg", "png", "webp", "pdf")

    private val scanFolders = listOf(
        Environment.DIRECTORY_DOWNLOADS,
        Environment.DIRECTORY_DOCUMENTS,
        "${Environment.DIRECTORY_PICTURES}/Receipts",
        "${Environment.DIRECTORY_PICTURES}/Screenshots",
    )

    suspend fun scanDocuments(): List<Transaction> = withContext(Dispatchers.IO) {
        val transactions = mutableListOf<Transaction>()

        for (folder in scanFolders) {
            val folderTransactions = scanFolder(folder)
            transactions.addAll(folderTransactions)
        }

        transactions.distinctBy { "${it.title}_${it.amount}_${it.date}" }
    }

    private suspend fun scanFolder(folderType: String): List<Transaction> {
        val transactions = mutableListOf<Transaction>()

        val collection = when {
            folderType.startsWith(Environment.DIRECTORY_PICTURES) ->
                MediaStore.Images.Media.EXTERNAL_CONTENT_URI
            else -> MediaStore.Files.getContentUri("external")
        }

        val projection = arrayOf(
            MediaStore.Files.FileColumns._ID,
            MediaStore.Files.FileColumns.DISPLAY_NAME,
            MediaStore.Files.FileColumns.DATA,
            MediaStore.Files.FileColumns.DATE_ADDED,
            MediaStore.Files.FileColumns.MIME_TYPE,
        )

        val selection = "${MediaStore.Files.FileColumns.RELATIVE_PATH} LIKE ?"
        val selectionArgs = arrayOf("%$folderType%")

        val sortOrder = "${MediaStore.Files.FileColumns.DATE_ADDED} DESC"

        contentResolver.query(collection, projection, selection, selectionArgs, sortOrder)?.use { cursor ->
            val idColumn = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns._ID)
            val nameColumn = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.DISPLAY_NAME)
            val mimeColumn = cursor.getColumnIndexOrThrow(MediaStore.Files.FileColumns.MIME_TYPE)

            while (cursor.moveToNext()) {
                val id = cursor.getLong(idColumn)
                val name = cursor.getString(nameColumn) ?: continue
                val mime = cursor.getString(mimeColumn) ?: continue

                if (!isSupportedFile(name, mime)) continue

                val uri = Uri.withAppendedPath(collection, id.toString())
                val transaction = processFile(uri, name)
                if (transaction != null) {
                    transactions.add(transaction)
                }
            }
        }

        return transactions
    }

    private fun isSupportedFile(name: String, mime: String): Boolean {
        val extension = name.substringAfterLast('.', "").lowercase()
        return extension in supportedExtensions ||
                mime.startsWith("image/") ||
                mime == "application/pdf"
    }

    private suspend fun processFile(uri: Uri, fileName: String): Transaction? =
        withContext(Dispatchers.IO) {
            try {
                val text = extractTextFromFile(uri) ?: return@withContext null
                val parsed = parsingLogic.parse(text, fileName) ?: return@withContext null
                parsed.copy(source = TransactionSource.DOCUMENT)
            } catch (e: Exception) {
                null
            }
        }

    private suspend fun extractTextFromFile(uri: Uri): String? =
        suspendCancellableCoroutine { continuation ->
            try {
                when {
                    uri.toString().contains("image") || isImageUri(uri) -> {
                        val bitmap = contentResolver.openInputStream(uri)?.use {
                            BitmapFactory.decodeStream(it)
                        } ?: run {
                            continuation.resume(null)
                            return@suspendCancellableCoroutine
                        }

                        val image = InputImage.fromBitmap(bitmap, 0)
                        textRecognizer.process(image)
                            .addOnSuccessListener { visionText ->
                                continuation.resume(visionText.text)
                            }
                            .addOnFailureListener {
                                continuation.resume(null)
                            }
                    }
                    else -> continuation.resume(null)
                }
            } catch (e: Exception) {
                continuation.resume(null)
            }
        }

    private fun isImageUri(uri: Uri): Boolean {
        val mime = contentResolver.getType(uri)
        return mime?.startsWith("image/") == true
    }
}

class DocumentParsingLogic {

    private val amountPatterns = listOf(
        Pattern.compile("""(?:итого|total|сумма|amount|жалпы|оплата|payment|жұмсалды)(?:[\s:]*)([\d\s]+[.,]\d{2})\s*(?:₽|р|руб|₸|тг|kzt)?""", Pattern.CASE_INSENSITIVE),
        Pattern.compile("""([\d\s]+[.,]\d{2})\s*(?:₽|р|руб|₸|тг|kzt)""", Pattern.CASE_INSENSITIVE),
        Pattern.compile("""(?:к\s+оплате|k\s+oplante|sum)\s*[:\s]*([\d\s]+[.,]\d{2})""", Pattern.CASE_INSENSITIVE),
    )

    private val datePatterns = listOf(
        DateTimeFormatter.ofPattern("dd.MM.yyyy"),
        DateTimeFormatter.ofPattern("dd/MM/yyyy"),
        DateTimeFormatter.ofPattern("yyyy-MM-dd"),
        DateTimeFormatter.ofPattern("dd MMM yyyy"),
    )

    private val merchantPatterns = listOf(
        Pattern.compile("""(?:магазин|маг\.|магазин\s+)([А-Яа-яёA-Za-z\s]+?)(?:\s*\n|\s*,)""", Pattern.CASE_INSENSITIVE),
        Pattern.compile("""(?:магазин|маг\.)[:\s]*([A-Za-zА-Яа-яё\s]+)""", Pattern.CASE_INSENSITIVE),
    )

    fun parse(text: String, fileName: String): Transaction? {
        val amount = extractAmount(text) ?: return null
        val date = extractDate(text)
        val title = extractTitle(text, fileName)
        val category = guessCategory(text)

        return Transaction(
            title = title,
            amount = amount,
            category = category,
            date = date,
            source = TransactionSource.DOCUMENT,
        )
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

    private fun extractDate(text: String): LocalDate {
        for (formatter in datePatterns) {
            try {
                val dateMatcher = Pattern.compile("""(\d{1,2}[./-]\d{1,2}[./-]\d{2,4})""").matcher(text)
                if (dateMatcher.find()) {
                    val dateStr = dateMatcher.group(1)
                    if (dateStr != null) {
                        val normalized = dateStr.replace("-", ".")
                        return LocalDate.parse(normalized, formatter)
                    }
                }
            } catch (_: Exception) {}
        }
        return LocalDate.now()
    }

    private fun extractTitle(text: String, fileName: String): String {
        for (pattern in merchantPatterns) {
            val matcher = pattern.matcher(text)
            if (matcher.find()) {
                val merchant = matcher.group(1)?.trim()
                if (!merchant.isNullOrBlank() && merchant.length > 2) {
                    return merchant.take(50)
                }
            }
        }

        val lines = text.split("\n")
            .map { it.trim() }
            .filter { it.isNotBlank() }
            .filter { it.length > 3 }
            .filter { !it.contains(Regex("""^\d+[.,]\d+""")) }

        lines.firstOrNull()?.let { return it.take(50) }

        val cleanFileName = fileName
            .substringBeforeLast(".")
            .replace("_", " ")
            .replace("-", " ")

        return cleanFileName.take(50).ifEmpty { "Receipt" }
    }

    private fun guessCategory(text: String): TransactionCategory {
        val lower = text.lowercase()

        return when {
            containsAny(lower, listOf(
                "продукт", "магазин", "супермаркет", "пятёрочка", "магнит", "ашан", "лента", "дикси",
                "product", "grocery", "supermarket", "food", "market",
                "азық", "түсім"
            )) -> TransactionCategory.FOOD

            containsAny(lower, listOf(
                "аптек", "лекарств", "больниц", "клиник", "pharmacy", "medicine",
                "дәрі", "дәріхана", "медицина"
            )) -> TransactionCategory.HEALTHCARE

            containsAny(lower, listOf(
                "одежд", "обувь", "clothes", "shoes", "fashion",
                "киім", "аяқ киім"
            )) -> TransactionCategory.SHOPPING

            containsAny(lower, listOf(
                "ресторан", "кафе", "restaurant", "cafe", "coffee",
                "мәшинен", "асхана"
            )) -> TransactionCategory.FOOD

            containsAny(lower, listOf(
                "подписк", "subscription", "spotify", "netflix",
                "жазылым"
            )) -> TransactionCategory.SUBSCRIPTION

            containsAny(lower, listOf(
                "такси", "uber", "taxi", "транспорт",
                "көлік", "автобус"
            )) -> TransactionCategory.TRANSPORT

            containsAny(lower, listOf(
                "жкх", "коммуналь", "utilities", "коммуналды"
            )) -> TransactionCategory.UTILITIES

            else -> TransactionCategory.OTHER
        }
    }

    private fun containsAny(text: String, list: List<String>): Boolean =
        list.any { text.contains(it) }
}
