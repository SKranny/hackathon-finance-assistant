package com.finance.assistant.service

import android.content.ContentResolver
import android.net.Uri
import android.provider.DocumentsContract
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class DocumentScanner @Inject constructor(
    private val contentResolver: ContentResolver,
) {

    fun scanFinanceDocuments(): List<String> {
        val documents = mutableListOf<String>()

        val rootsUri = DocumentsContract.buildRootsUri("com.android.externalstorage.documents")
        try {
            val cursor = contentResolver.query(rootsUri, null, null, null, null)
            cursor?.use {
                while (it.moveToNext()) {

                }
            }
        } catch (_: SecurityException) {
        }

        return documents
    }
}
