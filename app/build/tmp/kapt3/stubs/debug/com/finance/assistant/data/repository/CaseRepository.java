package com.finance.assistant.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\t\n\u0002\u0018\u0002\n\u0002\b\f\b\u0007\u0018\u0000 42\u00020\u0001:\u00014B#\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0002\u0010\u0007J\u0018\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\rH\u0002J\u0016\u0010\u000e\u001a\u00020\u000f2\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u001e\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00150\u00142\u0006\u0010\u0016\u001a\u00020\u00172\u0006\u0010\n\u001a\u00020\u000bH\u0002J\u0012\u0010\u0018\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00140\u0019J\u001a\u0010\u001b\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00140\u00192\u0006\u0010\u001c\u001a\u00020\u0017J\"\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u00140\u00192\u0006\u0010\u001e\u001a\u00020\u001f2\u0006\u0010 \u001a\u00020\u001fJ\u0018\u0010!\u001a\u0004\u0018\u00010\u00112\u0006\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0019\u0010\"\u001a\u0004\u0018\u00010\u000b2\b\u0010#\u001a\u0004\u0018\u00010\u0017H\u0002\u00a2\u0006\u0002\u0010$J\u0019\u0010%\u001a\u0004\u0018\u00010\r2\b\u0010#\u001a\u0004\u0018\u00010\u0017H\u0002\u00a2\u0006\u0002\u0010&JJ\u0010\'\u001a\u00020\u00112\u0006\u0010(\u001a\u00020)2\u0006\u0010*\u001a\u00020\u00172\u0006\u0010+\u001a\u00020\u00172\b\u0010,\u001a\u0004\u0018\u00010\u001f2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010-\u001a\u00020\u00172\b\b\u0002\u0010.\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010/J\u0016\u00100\u001a\u0004\u0018\u00010\u0017*\u00020\u00042\u0006\u00101\u001a\u00020\u0017H\u0002J\u001a\u00102\u001a\b\u0012\u0004\u0012\u00020\u00170\u0014*\u00020\u00042\u0006\u00101\u001a\u00020\u0017H\u0002J\f\u00103\u001a\u00020\u001a*\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u00065"}, d2 = {"Lcom/finance/assistant/data/repository/CaseRepository;", "", "caseBox", "Lio/objectbox/Box;", "Lcom/finance/assistant/data/objectbox/entity/session/FinanceCaseEntity;", "upcomingExpenseBox", "Lcom/finance/assistant/data/objectbox/entity/UpcomingExpenseEntity;", "(Lio/objectbox/Box;Lio/objectbox/Box;)V", "createSavingsRecommendation", "Lcom/finance/assistant/domain/model/alert/SavingsRecommendation;", "amount", "", "daysUntil", "", "deleteCase", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateResolutionsForExpense", "", "Lcom/finance/assistant/domain/model/alert/CaseResolution;", "category", "", "getActiveCases", "Lkotlinx/coroutines/flow/Flow;", "Lcom/finance/assistant/domain/model/alert/FinanceCase;", "getCasesByType", "type", "getCasesForDateRange", "startDate", "Ljava/time/LocalDate;", "endDate", "markCaseResolved", "parseDouble", "value", "(Ljava/lang/String;)Ljava/lang/Double;", "parseInt", "(Ljava/lang/String;)Ljava/lang/Integer;", "saveCase", "severity", "Lcom/finance/assistant/domain/model/alert/CaseSeverity;", "title", "description", "dueDate", "alertType", "additionalData", "(Lcom/finance/assistant/domain/model/alert/CaseSeverity;Ljava/lang/String;Ljava/lang/String;Ljava/time/LocalDate;DLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAdditionalData", "key", "parseAdditionalDataList", "toDomainCase", "Companion", "app_debug"})
public final class CaseRepository {
    @org.jetbrains.annotations.NotNull()
    private final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity> caseBox = null;
    @org.jetbrains.annotations.NotNull()
    private final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity> upcomingExpenseBox = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.finance.assistant.data.repository.CaseRepository.Companion Companion = null;
    
    @javax.inject.Inject()
    public CaseRepository(@org.jetbrains.annotations.NotNull()
    io.objectbox.Box<com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity> caseBox, @org.jetbrains.annotations.NotNull()
    io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity> upcomingExpenseBox) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveCase(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.alert.CaseSeverity severity, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate dueDate, double amount, @org.jetbrains.annotations.NotNull()
    java.lang.String alertType, @org.jetbrains.annotations.NotNull()
    java.lang.String additionalData, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markCaseResolved(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteCase(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.alert.FinanceCase>> getActiveCases() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.alert.FinanceCase>> getCasesByType(@org.jetbrains.annotations.NotNull()
    java.lang.String type) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.alert.FinanceCase>> getCasesForDateRange(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate startDate, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate endDate) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.alert.FinanceCase toDomainCase(com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity $this$toDomainCase) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.alert.SavingsRecommendation createSavingsRecommendation(double amount, int daysUntil) {
        return null;
    }
    
    private final java.util.List<com.finance.assistant.domain.model.alert.CaseResolution> generateResolutionsForExpense(java.lang.String category, double amount) {
        return null;
    }
    
    private final java.lang.String parseAdditionalData(com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity $this$parseAdditionalData, java.lang.String key) {
        return null;
    }
    
    private final java.lang.Double parseDouble(java.lang.String value) {
        return null;
    }
    
    private final java.lang.Integer parseInt(java.lang.String value) {
        return null;
    }
    
    private final java.util.List<java.lang.String> parseAdditionalDataList(com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity $this$parseAdditionalDataList, java.lang.String key) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0011\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J7\u0010\u0003\u001a\u00020\u00042*\u0010\u0005\u001a\u0016\u0012\u0012\b\u0001\u0012\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u00070\u0006\"\u000e\u0012\u0004\u0012\u00020\u0004\u0012\u0004\u0012\u00020\u00040\u0007\u00a2\u0006\u0002\u0010\b\u00a8\u0006\t"}, d2 = {"Lcom/finance/assistant/data/repository/CaseRepository$Companion;", "", "()V", "createAdditionalData", "", "pairs", "", "Lkotlin/Pair;", "([Lkotlin/Pair;)Ljava/lang/String;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String createAdditionalData(@org.jetbrains.annotations.NotNull()
        kotlin.Pair<java.lang.String, java.lang.String>... pairs) {
            return null;
        }
    }
}