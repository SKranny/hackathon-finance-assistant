package com.finance.assistant.data.objectbox

import android.content.Context
import com.finance.assistant.data.objectbox.entity.MyObjectBox
import io.objectbox.BoxStore
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ObjectBoxManager @Inject constructor(
    @ApplicationContext private val context: Context,
) {
    val boxStore: BoxStore = MyObjectBox.builder()
        .androidContext(context.applicationContext)
        .build()

    fun close() {
        boxStore.close()
    }

    suspend fun deleteAllData(): Boolean {
        return try {
            close()
            context.deleteDatabase("my-objectbox-db")
            true
        } catch (e: Exception) {
            false
        }
    }

    companion object {
        @Volatile
        private var instance: ObjectBoxManager? = null

        fun getInstance(context: Context): ObjectBoxManager {
            return instance ?: synchronized(this) {
                instance ?: ObjectBoxManager(context).also { instance = it }
            }
        }
    }
}
