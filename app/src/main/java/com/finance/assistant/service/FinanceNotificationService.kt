package com.finance.assistant.service

import android.app.NotificationChannel
import android.app.NotificationManager
import android.content.Context
import androidx.core.app.NotificationCompat
import com.finance.assistant.domain.model.FinancialInsight
import com.finance.assistant.domain.model.InsightSeverity
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class FinanceNotificationService @Inject constructor(
    @ApplicationContext private val context: Context,
    private val notificationManager: NotificationManager,
) {

    fun showInsightNotification(insight: FinancialInsight) {
        val channelId = when (insight.severity) {
            InsightSeverity.CRITICAL -> CHANNEL_CRITICAL
            InsightSeverity.WARNING -> CHANNEL_WARNING
            InsightSeverity.INFO -> CHANNEL_INFO
        }

        val notification = NotificationCompat.Builder(context, channelId)
            .setSmallIcon(android.R.drawable.ic_dialog_info)
            .setContentTitle(insight.title)
            .setContentText(insight.description)
            .setAutoCancel(true)
            .setPriority(
                when (insight.severity) {
                    InsightSeverity.CRITICAL -> NotificationCompat.PRIORITY_HIGH
                    InsightSeverity.WARNING -> NotificationCompat.PRIORITY_DEFAULT
                    InsightSeverity.INFO -> NotificationCompat.PRIORITY_LOW
                }
            )
            .build()

        notificationManager.notify(insight.id.toInt(), notification)
    }

    companion object {
        private const val CHANNEL_CRITICAL = "finance_critical"
        private const val CHANNEL_WARNING = "finance_warning"
        private const val CHANNEL_INFO = "finance_info"

        fun createNotificationChannels(context: Context) {
            val channels = listOf(
                NotificationChannel(
                    CHANNEL_CRITICAL,
                    "Критические уведомления",
                    NotificationManager.IMPORTANCE_HIGH,
                ).apply {
                    description = "Срочные финансовые предупреждения"
                },
                NotificationChannel(
                    CHANNEL_WARNING,
                    "Предупреждения",
                    NotificationManager.IMPORTANCE_DEFAULT,
                ).apply {
                    description = "Важные финансовые уведомления"
                },
                NotificationChannel(
                    CHANNEL_INFO,
                    "Информация",
                    NotificationManager.IMPORTANCE_LOW,
                ).apply {
                    description = "Информационные сообщения"
                },
            )

            val manager = context.getSystemService(Context.NOTIFICATION_SERVICE) as NotificationManager
            channels.forEach { manager.createNotificationChannel(it) }
        }
    }
}
