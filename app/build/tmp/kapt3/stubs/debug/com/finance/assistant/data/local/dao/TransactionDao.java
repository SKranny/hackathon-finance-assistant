package com.finance.assistant.data.local.dao;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0010\u000e\n\u0002\b\u0005\bg\u0018\u00002\u00020\u0001J\u0016\u0010\u0002\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u000e\u0010\u0007\u001a\u00020\u0003H\u00a7@\u00a2\u0006\u0002\u0010\bJ\u0014\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\'J\u0014\u0010\f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\nH\'J \u0010\r\u001a\n\u0012\u0006\u0012\u0004\u0018\u00010\u000e0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\'J$\u0010\u0012\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u0010H\'J\u001c\u0010\u0013\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00050\u000b0\n2\u0006\u0010\u0014\u001a\u00020\u0015H\'J\u0016\u0010\u0016\u001a\u00020\u00032\u0006\u0010\u0004\u001a\u00020\u0005H\u00a7@\u00a2\u0006\u0002\u0010\u0006J\u001c\u0010\u0017\u001a\u00020\u00032\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00050\u000bH\u00a7@\u00a2\u0006\u0002\u0010\u0019\u00a8\u0006\u001a"}, d2 = {"Lcom/finance/assistant/data/local/dao/TransactionDao;", "", "delete", "", "transaction", "Lcom/finance/assistant/data/local/entity/TransactionEntity;", "(Lcom/finance/assistant/data/local/entity/TransactionEntity;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteAll", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getAllTransactions", "Lkotlinx/coroutines/flow/Flow;", "", "getRecurringTransactions", "getTotalBetween", "", "startMillis", "", "endMillis", "getTransactionsBetween", "getTransactionsByCategory", "category", "", "insert", "insertAll", "transactions", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
@androidx.room.Dao()
public abstract interface TransactionDao {
    
    @androidx.room.Query(value = "SELECT * FROM transactions ORDER BY dateMillis DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.data.local.entity.TransactionEntity>> getAllTransactions();
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE dateMillis BETWEEN :startMillis AND :endMillis ORDER BY dateMillis ASC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.data.local.entity.TransactionEntity>> getTransactionsBetween(long startMillis, long endMillis);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE category = :category ORDER BY dateMillis DESC")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.data.local.entity.TransactionEntity>> getTransactionsByCategory(@org.jetbrains.annotations.NotNull()
    java.lang.String category);
    
    @androidx.room.Query(value = "SELECT SUM(amount) FROM transactions WHERE dateMillis BETWEEN :startMillis AND :endMillis")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.lang.Double> getTotalBetween(long startMillis, long endMillis);
    
    @androidx.room.Query(value = "SELECT * FROM transactions WHERE isRecurring = 1")
    @org.jetbrains.annotations.NotNull()
    public abstract kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.data.local.entity.TransactionEntity>> getRecurringTransactions();
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.local.entity.TransactionEntity transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Insert(onConflict = 1)
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.data.local.entity.TransactionEntity> transactions, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Delete()
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object delete(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.local.entity.TransactionEntity transaction, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
    
    @androidx.room.Query(value = "DELETE FROM transactions")
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object deleteAll(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion);
}