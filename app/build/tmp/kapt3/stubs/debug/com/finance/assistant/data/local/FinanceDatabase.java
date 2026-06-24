package com.finance.assistant.data.local;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\'\u0018\u0000 \u00072\u00020\u0001:\u0001\u0007B\u0005\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0003\u001a\u00020\u0004H&J\b\u0010\u0005\u001a\u00020\u0006H&\u00a8\u0006\b"}, d2 = {"Lcom/finance/assistant/data/local/FinanceDatabase;", "Landroidx/room/RoomDatabase;", "()V", "financialInsightDao", "Lcom/finance/assistant/data/local/dao/FinancialInsightDao;", "transactionDao", "Lcom/finance/assistant/data/local/dao/TransactionDao;", "Companion", "app_debug"})
@androidx.room.Database(entities = {com.finance.assistant.data.local.entity.TransactionEntity.class, com.finance.assistant.data.local.entity.FinancialInsightEntity.class}, version = 1, exportSchema = false)
public abstract class FinanceDatabase extends androidx.room.RoomDatabase {
    @org.jetbrains.annotations.NotNull()
    public static final com.finance.assistant.data.local.FinanceDatabase.Companion Companion = null;
    
    public FinanceDatabase() {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.finance.assistant.data.local.dao.TransactionDao transactionDao();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.finance.assistant.data.local.dao.FinancialInsightDao financialInsightDao();
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0018\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0006\u00a8\u0006\u0007"}, d2 = {"Lcom/finance/assistant/data/local/FinanceDatabase$Companion;", "", "()V", "buildDatabase", "Lcom/finance/assistant/data/local/FinanceDatabase;", "context", "Landroid/content/Context;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finance.assistant.data.local.FinanceDatabase buildDatabase(@org.jetbrains.annotations.NotNull()
        android.content.Context context) {
            return null;
        }
    }
}