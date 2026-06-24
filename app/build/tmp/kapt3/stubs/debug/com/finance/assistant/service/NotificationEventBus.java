package com.finance.assistant.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0010\u0002\n\u0002\b\u0006\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\b\u001a\u00020\u00072\u0006\u0010\t\u001a\u00020\u0006J\u001a\u0010\n\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005J\u001a\u0010\f\u001a\u00020\u00072\u0012\u0010\u000b\u001a\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u0005R \u0010\u0003\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\u0006\u0012\u0004\u0012\u00020\u00070\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\r"}, d2 = {"Lcom/finance/assistant/service/NotificationEventBus;", "", "()V", "listeners", "", "Lkotlin/Function1;", "Lcom/finance/assistant/domain/model/Transaction;", "", "emit", "transaction", "subscribe", "listener", "unsubscribe", "app_debug"})
public final class NotificationEventBus {
    @org.jetbrains.annotations.NotNull()
    private static final java.util.List<kotlin.jvm.functions.Function1<com.finance.assistant.domain.model.Transaction, kotlin.Unit>> listeners = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.finance.assistant.service.NotificationEventBus INSTANCE = null;
    
    private NotificationEventBus() {
        super();
    }
    
    public final void subscribe(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.finance.assistant.domain.model.Transaction, kotlin.Unit> listener) {
    }
    
    public final void unsubscribe(@org.jetbrains.annotations.NotNull()
    kotlin.jvm.functions.Function1<? super com.finance.assistant.domain.model.Transaction, kotlin.Unit> listener) {
    }
    
    public final void emit(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.Transaction transaction) {
    }
}