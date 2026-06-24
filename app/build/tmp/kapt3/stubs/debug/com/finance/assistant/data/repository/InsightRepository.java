package com.finance.assistant.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0007\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0012\u0010\u0005\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0012\u0010\t\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00070\u0006J\u0016\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\rJ\u001c\u0010\u000e\u001a\u00020\u000b2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\b0\u0007H\u0086@\u00a2\u0006\u0002\u0010\u0010J\u0016\u0010\u0011\u001a\u00020\u000b2\u0006\u0010\u0012\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010\u0014J\f\u0010\u0015\u001a\u00020\b*\u00020\u0016H\u0002J\f\u0010\u0017\u001a\u00020\u0016*\u00020\bH\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/finance/assistant/data/repository/InsightRepository;", "", "insightDao", "Lcom/finance/assistant/data/local/dao/FinancialInsightDao;", "(Lcom/finance/assistant/data/local/dao/FinancialInsightDao;)V", "getAllInsights", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finance/assistant/domain/model/FinancialInsight;", "getUnreadInsights", "insert", "", "insight", "(Lcom/finance/assistant/domain/model/FinancialInsight;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "insertAll", "insights", "(Ljava/util/List;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markAsRead", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "toDomain", "Lcom/finance/assistant/data/local/entity/FinancialInsightEntity;", "toEntity", "app_debug"})
public final class InsightRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.local.dao.FinancialInsightDao insightDao = null;
    
    @javax.inject.Inject()
    public InsightRepository(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.local.dao.FinancialInsightDao insightDao) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.FinancialInsight>> getAllInsights() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.FinancialInsight>> getUnreadInsights() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insert(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.FinancialInsight insight, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object insertAll(@org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.FinancialInsight> insights, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markAsRead(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.FinancialInsight toDomain(com.finance.assistant.data.local.entity.FinancialInsightEntity $this$toDomain) {
        return null;
    }
    
    private final com.finance.assistant.data.local.entity.FinancialInsightEntity toEntity(com.finance.assistant.domain.model.FinancialInsight $this$toEntity) {
        return null;
    }
}