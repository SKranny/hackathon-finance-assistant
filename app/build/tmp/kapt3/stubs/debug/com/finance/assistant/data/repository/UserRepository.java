package com.finance.assistant.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000<\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0005\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0015\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\u0002\u0010\u0005J\u0010\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u0086@\u00a2\u0006\u0002\u0010\bJ\u000e\u0010\t\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u00070\nJ\u0016\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u0007H\u0086@\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0013\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0014\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\f2\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0019"}, d2 = {"Lcom/finance/assistant/data/repository/UserRepository;", "", "userBox", "Lio/objectbox/Box;", "Lcom/finance/assistant/data/objectbox/entity/UserProfileEntity;", "(Lio/objectbox/Box;)V", "getProfile", "Lcom/finance/assistant/domain/model/profile/UserProfile;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "observeProfile", "Lkotlinx/coroutines/flow/Flow;", "saveProfile", "", "profile", "(Lcom/finance/assistant/domain/model/profile/UserProfile;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateBalance", "newBalance", "", "(DLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateSalary", "newSalary", "updateSalaryDay", "day", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class UserRepository {
    @org.jetbrains.annotations.NotNull()
    private final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UserProfileEntity> userBox = null;
    
    @javax.inject.Inject()
    public UserRepository(@org.jetbrains.annotations.NotNull()
    io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UserProfileEntity> userBox) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveProfile(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.profile.UserProfile profile, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getProfile(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.assistant.domain.model.profile.UserProfile> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateBalance(double newBalance, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateSalary(double newSalary, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateSalaryDay(int day, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<com.finance.assistant.domain.model.profile.UserProfile> observeProfile() {
        return null;
    }
}