package com.finance.assistant.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000b\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\t\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\r\b\u0007\u0018\u0000 .2\u00020\u0001:\u0001.B#\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0012\u0010\r\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000eJ\u001a\u0010\u0011\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0012\u001a\u00020\u0013J\"\u0010\u0014\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u000e2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0019\u0010\u0019\u001a\u0004\u0018\u00010\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0002\u0010\u001cJ\u0019\u0010\u001d\u001a\u0004\u0018\u00010\u001e2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0013H\u0002\u00a2\u0006\u0002\u0010\u001fJJ\u0010 \u001a\u00020\u000b2\u0006\u0010!\u001a\u00020\"2\u0006\u0010#\u001a\u00020\u00132\u0006\u0010$\u001a\u00020\u00132\b\u0010%\u001a\u0004\u0018\u00010\u00162\u0006\u0010&\u001a\u00020\u001a2\u0006\u0010\'\u001a\u00020\u00132\b\b\u0002\u0010(\u001a\u00020\u0013H\u0086@\u00a2\u0006\u0002\u0010)J\u0016\u0010*\u001a\u0004\u0018\u00010\u0013*\u00020\u00042\u0006\u0010+\u001a\u00020\u0013H\u0002J\u001a\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00130\u000f*\u00020\u00042\u0006\u0010+\u001a\u00020\u0013H\u0002J\f\u0010-\u001a\u00020\u0010*\u00020\u0004H\u0002R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/finance/assistant/data/repository/CaseRepository;", "", "caseBox", "Lio/objectbox/Box;", "Lcom/finance/assistant/data/objectbox/entity/session/FinanceCaseEntity;", "upcomingExpenseBox", "Lcom/finance/assistant/data/objectbox/entity/UpcomingExpenseEntity;", "(Lio/objectbox/Box;Lio/objectbox/Box;)V", "deleteCase", "", "id", "", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getActiveCases", "Lkotlinx/coroutines/flow/Flow;", "", "Lcom/finance/assistant/domain/model/alert/FinanceCase;", "getCasesByType", "type", "", "getCasesForDateRange", "startDate", "Ljava/time/LocalDate;", "endDate", "markCaseResolved", "parseDouble", "", "value", "(Ljava/lang/String;)Ljava/lang/Double;", "parseInt", "", "(Ljava/lang/String;)Ljava/lang/Integer;", "saveCase", "severity", "Lcom/finance/assistant/domain/model/alert/CaseSeverity;", "title", "description", "dueDate", "amount", "alertType", "additionalData", "(Lcom/finance/assistant/domain/model/alert/CaseSeverity;Ljava/lang/String;Ljava/lang/String;Ljava/time/LocalDate;DLjava/lang/String;Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAdditionalData", "key", "parseAdditionalDataList", "toDomainCase", "Companion", "app_debug"})
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