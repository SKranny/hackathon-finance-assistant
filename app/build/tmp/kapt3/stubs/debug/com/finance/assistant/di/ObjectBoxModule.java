package com.finance.assistant.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u0010\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006H\u0007J\u0016\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0016\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\f0\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0016\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000e0\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0016\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\u00100\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007J\u0016\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\b2\u0006\u0010\n\u001a\u00020\u0004H\u0007\u00a8\u0006\u0013"}, d2 = {"Lcom/finance/assistant/di/ObjectBoxModule;", "", "()V", "provideBoxStore", "Lio/objectbox/BoxStore;", "manager", "Lcom/finance/assistant/data/objectbox/ObjectBoxManager;", "provideChatMessageBox", "Lio/objectbox/Box;", "Lcom/finance/assistant/data/objectbox/entity/session/ChatMessageEntity;", "boxStore", "provideFinanceCaseBox", "Lcom/finance/assistant/data/objectbox/entity/session/FinanceCaseEntity;", "provideRecurringExpenseBox", "Lcom/finance/assistant/data/objectbox/entity/RecurringExpenseEntity;", "provideUpcomingExpenseBox", "Lcom/finance/assistant/data/objectbox/entity/UpcomingExpenseEntity;", "provideUserProfileBox", "Lcom/finance/assistant/data/objectbox/entity/UserProfileEntity;", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class ObjectBoxModule {
    @org.jetbrains.annotations.NotNull()
    public static final com.finance.assistant.di.ObjectBoxModule INSTANCE = null;
    
    private ObjectBoxModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final io.objectbox.BoxStore provideBoxStore(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.objectbox.ObjectBoxManager manager) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity> provideUpcomingExpenseBox(@org.jetbrains.annotations.NotNull()
    io.objectbox.BoxStore boxStore) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity> provideRecurringExpenseBox(@org.jetbrains.annotations.NotNull()
    io.objectbox.BoxStore boxStore) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UserProfileEntity> provideUserProfileBox(@org.jetbrains.annotations.NotNull()
    io.objectbox.BoxStore boxStore) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity> provideFinanceCaseBox(@org.jetbrains.annotations.NotNull()
    io.objectbox.BoxStore boxStore) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.session.ChatMessageEntity> provideChatMessageBox(@org.jetbrains.annotations.NotNull()
    io.objectbox.BoxStore boxStore) {
        return null;
    }
}