package com.finance.assistant.domain.usecase;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000h\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u000bJD\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u00102\f\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\u00120\r2\f\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J\u001e\u0010\u0018\u001a\u00020\u00192\u0006\u0010\u001a\u001a\u00020\u001b2\u0006\u0010\u001c\u001a\u00020\nH\u0086@\u00a2\u0006\u0002\u0010\u001dJ\u001e\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00140\r2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0017\u001a\u00020\u0016H\u0002J$\u0010\u001f\u001a\u0010\u0012\u0004\u0012\u00020\u0016\u0012\u0004\u0012\u00020\u001b\u0018\u00010 2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u0002J&\u0010\"\u001a\b\u0012\u0004\u0012\u00020#0\r2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u0002J\u001e\u0010$\u001a\u00020\u001b2\f\u0010!\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\u0006\u0010%\u001a\u00020\u0016H\u0002R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/finance/assistant/domain/usecase/BalanceForecastUseCase;", "", "userRepository", "Lcom/finance/assistant/data/repository/UserRepository;", "expenseRepository", "Lcom/finance/assistant/data/repository/ExpenseRepository;", "(Lcom/finance/assistant/data/repository/UserRepository;Lcom/finance/assistant/data/repository/ExpenseRepository;)V", "calculateForecast", "Lcom/finance/assistant/domain/model/forecast/BalanceForecast;", "daysAhead", "", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateForecastPoints", "", "Lcom/finance/assistant/domain/model/forecast/ForecastPoint;", "profile", "Lcom/finance/assistant/domain/model/profile/UserProfile;", "expenses", "Lcom/finance/assistant/domain/model/expense/UpcomingExpense;", "salaryDates", "Lcom/finance/assistant/domain/model/forecast/SalaryDate;", "startDate", "Ljava/time/LocalDate;", "endDate", "calculateGapClosure", "Lcom/finance/assistant/domain/model/forecast/GapClosureSuggestion;", "amount", "", "daysAvailable", "(DILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateSalaryDates", "findNegativeBalanceDate", "Lkotlin/Pair;", "points", "generateRecommendations", "", "getTotalExpensesForDate", "date", "app_debug"})
public final class BalanceForecastUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.ExpenseRepository expenseRepository = null;
    
    @javax.inject.Inject()
    public BalanceForecastUseCase(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.ExpenseRepository expenseRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object calculateForecast(int daysAhead, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.assistant.domain.model.forecast.BalanceForecast> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object calculateGapClosure(double amount, int daysAvailable, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.assistant.domain.model.forecast.GapClosureSuggestion> $completion) {
        return null;
    }
    
    private final java.util.List<com.finance.assistant.domain.model.forecast.SalaryDate> calculateSalaryDates(com.finance.assistant.domain.model.profile.UserProfile profile, java.time.LocalDate endDate) {
        return null;
    }
    
    private final java.util.List<com.finance.assistant.domain.model.forecast.ForecastPoint> calculateForecastPoints(com.finance.assistant.domain.model.profile.UserProfile profile, java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense> expenses, java.util.List<com.finance.assistant.domain.model.forecast.SalaryDate> salaryDates, java.time.LocalDate startDate, java.time.LocalDate endDate) {
        return null;
    }
    
    private final kotlin.Pair<java.time.LocalDate, java.lang.Double> findNegativeBalanceDate(java.util.List<com.finance.assistant.domain.model.forecast.ForecastPoint> points) {
        return null;
    }
    
    private final double getTotalExpensesForDate(java.util.List<com.finance.assistant.domain.model.forecast.ForecastPoint> points, java.time.LocalDate date) {
        return 0.0;
    }
    
    private final java.util.List<java.lang.String> generateRecommendations(java.util.List<com.finance.assistant.domain.model.forecast.ForecastPoint> points, com.finance.assistant.domain.model.profile.UserProfile profile) {
        return null;
    }
}