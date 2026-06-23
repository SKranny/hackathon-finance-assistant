package com.finance.assistant

import android.app.Application
import com.finance.assistant.service.FinanceNotificationService
import dagger.hilt.android.HiltAndroidApp

@HiltAndroidApp
class FinanceAssistantApp : Application() {

    override fun onCreate() {
        super.onCreate()
        FinanceNotificationService.createNotificationChannels(this)
    }
}
