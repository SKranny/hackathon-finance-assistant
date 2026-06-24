package com.finance.assistant.service;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010 \n\u0000\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0018\u0010\t\u001a\u0004\u0018\u00010\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\fJ\u0016\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\n0\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0012"}, d2 = {"Lcom/finance/assistant/service/TransactionScanner;", "", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/ContentResolver;)V", "notificationParsingLogic", "Lcom/finance/assistant/service/NotificationParsingLogic;", "smsParsingLogic", "Lcom/finance/assistant/service/SmsParsingLogic;", "parseNotification", "Lcom/finance/assistant/domain/model/Transaction;", "text", "", "packageName", "scanSmsTransactions", "", "daysBack", "", "app_debug"})
public final class TransactionScanner {
    @org.jetbrains.annotations.NotNull()
    private final android.content.ContentResolver contentResolver = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.service.SmsParsingLogic smsParsingLogic = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.service.NotificationParsingLogic notificationParsingLogic = null;
    
    @javax.inject.Inject()
    public TransactionScanner(@org.jetbrains.annotations.NotNull()
    android.content.ContentResolver contentResolver) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.Transaction> scanSmsTransactions(int daysBack) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.Transaction parseNotification(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String packageName) {
        return null;
    }
}