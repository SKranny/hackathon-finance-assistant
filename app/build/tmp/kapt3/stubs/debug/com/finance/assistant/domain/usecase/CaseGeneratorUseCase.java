package com.finance.assistant.domain.usecase;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000P\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u001f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ0\u0010\t\u001a\u0004\u0018\u00010\n2\b\u0010\u000b\u001a\u0004\u0018\u00010\f2\f\u0010\r\u001a\b\u0012\u0004\u0012\u00020\u000f0\u000e2\f\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0002J\u001c\u0010\u0012\u001a\b\u0012\u0004\u0012\u00020\u00130\u000e2\f\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00110\u000eH\u0002J\u0014\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00160\u000eH\u0086@\u00a2\u0006\u0002\u0010\u0017J\u000e\u0010\u0018\u001a\u00020\u0019H\u0086@\u00a2\u0006\u0002\u0010\u0017R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/finance/assistant/domain/usecase/CaseGeneratorUseCase;", "", "userRepository", "Lcom/finance/assistant/data/repository/UserRepository;", "expenseRepository", "Lcom/finance/assistant/data/repository/ExpenseRepository;", "caseRepository", "Lcom/finance/assistant/data/repository/CaseRepository;", "(Lcom/finance/assistant/data/repository/UserRepository;Lcom/finance/assistant/data/repository/ExpenseRepository;Lcom/finance/assistant/data/repository/CaseRepository;)V", "detectCashGap", "Lcom/finance/assistant/domain/model/alert/CashGapCase;", "profile", "Lcom/finance/assistant/domain/model/profile/UserProfile;", "upcomingExpenses", "", "Lcom/finance/assistant/domain/model/expense/UpcomingExpense;", "recurringExpenses", "Lcom/finance/assistant/domain/model/expense/RecurringExpense;", "detectZombieSubscriptions", "Lcom/finance/assistant/domain/model/alert/ZombieSubscriptionCase;", "expenses", "generateAllCases", "Lcom/finance/assistant/domain/model/alert/FinanceCase;", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "saveGeneratedCases", "", "app_debug"})
public final class CaseGeneratorUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.CaseRepository caseRepository = null;
    
    @javax.inject.Inject()
    public CaseGeneratorUseCase(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.CaseRepository caseRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object generateAllCases(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<? extends com.finance.assistant.domain.model.alert.FinanceCase>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object saveGeneratedCases(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Unit> $completion) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.alert.CashGapCase detectCashGap(com.finance.assistant.domain.model.profile.UserProfile profile, java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense> upcomingExpenses, java.util.List<com.finance.assistant.domain.model.expense.RecurringExpense> recurringExpenses) {
        return null;
    }
    
    private final java.util.List<com.finance.assistant.domain.model.alert.ZombieSubscriptionCase> detectZombieSubscriptions(java.util.List<com.finance.assistant.domain.model.expense.RecurringExpense> expenses) {
        return null;
    }
}