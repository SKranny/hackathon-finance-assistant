package com.finance.assistant.di

import com.finance.assistant.data.objectbox.ObjectBoxManager
import com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity
import com.finance.assistant.data.objectbox.entity.UserProfileEntity
import com.finance.assistant.data.objectbox.entity.case.ChatMessageEntity
import com.finance.assistant.data.objectbox.entity.case.FinanceCaseEntity
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import io.objectbox.Box
import io.objectbox.BoxStore
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object ObjectBoxModule {

    @Provides
    @Singleton
    fun provideBoxStore(manager: ObjectBoxManager): BoxStore = manager.boxStore

    @Provides
    @Singleton
    fun provideUpcomingExpenseBox(boxStore: BoxStore): Box<UpcomingExpenseEntity> =
        boxStore.boxFor(UpcomingExpenseEntity::class.java)

    @Provides
    @Singleton
    fun provideRecurringExpenseBox(boxStore: BoxStore): Box<RecurringExpenseEntity> =
        boxStore.boxFor(RecurringExpenseEntity::class.java)

    @Provides
    @Singleton
    fun provideUserProfileBox(boxStore: BoxStore): Box<UserProfileEntity> =
        boxStore.boxFor(UserProfileEntity::class.java)

    @Provides
    @Singleton
    fun provideFinanceCaseBox(boxStore: BoxStore): Box<FinanceCaseEntity> =
        boxStore.boxFor(FinanceCaseEntity::class.java)

    @Provides
    @Singleton
    fun provideChatMessageBox(boxStore: BoxStore): Box<ChatMessageEntity> =
        boxStore.boxFor(ChatMessageEntity::class.java)
}
