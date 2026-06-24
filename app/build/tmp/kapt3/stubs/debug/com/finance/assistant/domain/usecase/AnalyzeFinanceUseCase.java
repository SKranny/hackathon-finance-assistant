package com.finance.assistant.domain.usecase;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B/\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u00a2\u0006\u0002\u0010\fJ\"\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eH\u0086B\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0011\u0010\u0012R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0013"}, d2 = {"Lcom/finance/assistant/domain/usecase/AnalyzeFinanceUseCase;", "", "aiModelManager", "Lcom/finance/assistant/ai/AIModelManager;", "transactionRepository", "Lcom/finance/assistant/data/repository/TransactionRepository;", "insightRepository", "Lcom/finance/assistant/data/repository/InsightRepository;", "calendarScanner", "Lcom/finance/assistant/service/CalendarScanner;", "transactionScanner", "Lcom/finance/assistant/service/TransactionScanner;", "(Lcom/finance/assistant/ai/AIModelManager;Lcom/finance/assistant/data/repository/TransactionRepository;Lcom/finance/assistant/data/repository/InsightRepository;Lcom/finance/assistant/service/CalendarScanner;Lcom/finance/assistant/service/TransactionScanner;)V", "invoke", "Lkotlin/Result;", "", "Lcom/finance/assistant/domain/model/FinancialInsight;", "invoke-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class AnalyzeFinanceUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.ai.AIModelManager aiModelManager = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.TransactionRepository transactionRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.InsightRepository insightRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.service.CalendarScanner calendarScanner = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.service.TransactionScanner transactionScanner = null;
    
    @javax.inject.Inject()
    public AnalyzeFinanceUseCase(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.ai.AIModelManager aiModelManager, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.TransactionRepository transactionRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.InsightRepository insightRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.service.CalendarScanner calendarScanner, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.service.TransactionScanner transactionScanner) {
        super();
    }
}