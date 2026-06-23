package com.finance.assistant.data.privacy

import android.content.Context
import androidx.datastore.core.DataStore
import androidx.datastore.preferences.core.Preferences
import androidx.datastore.preferences.core.booleanPreferencesKey
import androidx.datastore.preferences.core.edit
import androidx.datastore.preferences.core.longPreferencesKey
import androidx.datastore.preferences.core.stringPreferencesKey
import androidx.datastore.preferences.preferencesDataStore
import com.finance.assistant.data.objectbox.ObjectBoxManager
import com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity
import com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity_
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity_
import com.finance.assistant.data.objectbox.entity.UserProfileEntity
import com.finance.assistant.data.objectbox.entity.session.ChatMessageEntity
import com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity
import dagger.hilt.android.qualifiers.ApplicationContext
import io.objectbox.Box
import io.objectbox.BoxStore
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.first
import kotlinx.coroutines.flow.map
import kotlinx.coroutines.withContext
import javax.inject.Inject
import javax.inject.Singleton

private val Context.privacyDataStore: DataStore<Preferences> by preferencesDataStore(name = "privacy_settings")

@Singleton
class DataDeletionService @Inject constructor(
    @ApplicationContext private val context: Context,
    private val boxStore: BoxStore,
    private val objectBoxManager: ObjectBoxManager,
) {

    private val dataStore = context.privacyDataStore

    private val upcomingExpenseBox: Box<UpcomingExpenseEntity> by lazy {
        boxStore.boxFor(UpcomingExpenseEntity::class.java)
    }

    private val recurringExpenseBox: Box<RecurringExpenseEntity> by lazy {
        boxStore.boxFor(RecurringExpenseEntity::class.java)
    }

    private val userProfileBox: Box<UserProfileEntity> by lazy {
        boxStore.boxFor(UserProfileEntity::class.java)
    }

    private val chatMessageBox: Box<ChatMessageEntity> by lazy {
        boxStore.boxFor(ChatMessageEntity::class.java)
    }

    private val financeCaseBox: Box<FinanceCaseEntity> by lazy {
        boxStore.boxFor(FinanceCaseEntity::class.java)
    }

    private val consentKey = booleanPreferencesKey("data_consent_given")
    private val lastDeletionKey = longPreferencesKey("last_deletion_time")
    private val deletionCountKey = longPreferencesKey("deletion_count")
    private val analyticsKey = booleanPreferencesKey("analytics_enabled")
    private val crashReportsKey = booleanPreferencesKey("crash_reports_enabled")

    suspend fun hasUserConsent(): Boolean {
        return dataStore.data.first()[consentKey] ?: false
    }

    suspend fun setUserConsent(granted: Boolean) {
        dataStore.edit { prefs ->
            prefs[consentKey] = granted
        }
    }

    suspend fun deleteAllUserData(): DeletionResult = withContext(Dispatchers.IO) {
        try {
            upcomingExpenseBox.removeAll()
            recurringExpenseBox.removeAll()
            userProfileBox.removeAll()
            chatMessageBox.removeAll()
            financeCaseBox.removeAll()

            val now = System.currentTimeMillis()
            dataStore.edit { prefs ->
                prefs[lastDeletionKey] = now
                val count = prefs[deletionCountKey] ?: 0L
                prefs[deletionCountKey] = count + 1
            }

            objectBoxManager.deleteAllData()

            DeletionResult.Success(
                deletedRecords = 5,
                deletedAt = now,
            )
        } catch (e: Exception) {
            DeletionResult.Error(e.message ?: "Unknown error")
        }
    }

    suspend fun deleteTransactionsOnly() {
        withContext(Dispatchers.IO) {
            upcomingExpenseBox.removeAll()
        }
    }

    suspend fun deleteRecurringExpensesOnly() {
        withContext(Dispatchers.IO) {
            recurringExpenseBox.removeAll()
        }
    }

    suspend fun deleteUserProfileOnly() {
        withContext(Dispatchers.IO) {
            userProfileBox.removeAll()
        }
    }

    suspend fun deleteChatHistory() {
        withContext(Dispatchers.IO) {
            chatMessageBox.removeAll()
        }
    }

    suspend fun deleteAnalyticsData(): Boolean = withContext(Dispatchers.IO) {
        dataStore.edit { prefs ->
            prefs[analyticsKey] = false
        }
        true
    }

    fun isAnalyticsEnabled(): Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[analyticsKey] ?: false
    }

    suspend fun setAnalyticsEnabled(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[analyticsKey] = enabled
        }
    }

    suspend fun setCrashReportsEnabled(enabled: Boolean) {
        dataStore.edit { prefs ->
            prefs[crashReportsKey] = enabled
        }
    }

    fun isCrashReportsEnabled(): Flow<Boolean> = dataStore.data.map { prefs ->
        prefs[crashReportsKey] ?: false
    }

    suspend fun getDeletionHistory(): List<DeletionRecord> {
        return dataStore.data.map { prefs ->
            val lastDeletion = prefs[lastDeletionKey]
            val count = prefs[deletionCountKey] ?: 0L
            listOf(
                DeletionRecord(
                    timestamp = lastDeletion,
                    recordCount = 0,
                    type = DeletionType.FULL,
                )
            )
        }.first()
    }

    suspend fun getPrivacyStatus(): PrivacyStatus {
        val prefs = dataStore.data.first()
        val hasConsent = prefs[consentKey] ?: false
        val analyticsEnabled = prefs[analyticsKey] ?: false
        val crashReportsEnabled = prefs[crashReportsKey] ?: false
        val deletionCount = prefs[deletionCountKey] ?: 0L
        val lastDeletion = prefs[lastDeletionKey]

        val transactionCount = upcomingExpenseBox.count().toInt() +
                recurringExpenseBox.count().toInt()
        val profileExists = userProfileBox.count() > 0L
        val chatMessageCount = chatMessageBox.count().toInt()

        return PrivacyStatus(
            hasUserConsent = hasConsent,
            isAnalyticsEnabled = analyticsEnabled,
            isCrashReportsEnabled = crashReportsEnabled,
            totalDeletions = deletionCount.toInt(),
            lastDeletionTime = lastDeletion,
            hasUserData = transactionCount > 0 || profileExists || chatMessageCount > 0,
            transactionCount = transactionCount,
            profileExists = profileExists,
            chatMessageCount = chatMessageCount,
        )
    }

    suspend fun exportDataSummary(): DataExportSummary {
        val transactionCount = upcomingExpenseBox.count().toInt() +
                recurringExpenseBox.count().toInt()
        val profileExists = userProfileBox.count() > 0L
        val chatMessageCount = chatMessageBox.count().toInt()

        return DataExportSummary(
            hasUserProfile = profileExists,
            transactionCount = transactionCount,
            chatMessageCount = chatMessageCount,
            hasSubscriptionData = recurringExpenseBox.count() > 0L,
        )
    }
}

sealed class DeletionResult {
    data class Success(val deletedRecords: Long, val deletedAt: Long) : DeletionResult()
    data class Error(val message: String) : DeletionResult()
}

data class DeletionRecord(
    val timestamp: Long?,
    val recordCount: Int,
    val type: DeletionType,
)

enum class DeletionType {
    FULL, TRANSACTIONS_ONLY, PROFILE_ONLY, CHAT_ONLY
}

data class PrivacyStatus(
    val hasUserConsent: Boolean,
    val isAnalyticsEnabled: Boolean,
    val isCrashReportsEnabled: Boolean,
    val totalDeletions: Int,
    val lastDeletionTime: Long?,
    val hasUserData: Boolean,
    val transactionCount: Int,
    val profileExists: Boolean,
    val chatMessageCount: Int,
)

data class DataExportSummary(
    val hasUserProfile: Boolean,
    val transactionCount: Int,
    val chatMessageCount: Int,
    val hasSubscriptionData: Boolean,
)
