package com.finance.assistant.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000^\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0006\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0010 \n\u0002\b\u0007\n\u0002\u0010\b\n\u0002\b\u0006\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u00002\u00020\u0001B#\b\u0007\u0012\f\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\f\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003\u00a2\u0006\u0002\u0010\u0007J\u0016\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010\r\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fJ\u000e\u0010\u0010\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u000e\u0010\u0013\u001a\u00020\u0011H\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0018\u0010\u0014\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0017\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0016\u0010\u0019\u001a\u00020\u00182\u0006\u0010\u0015\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010\u001a\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001c0\u001bJ\u0012\u0010\u001d\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000b0\u001c0\u001bJ\u0018\u0010\u001e\u001a\u0004\u0018\u00010\u000b2\u0006\u0010\u0015\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010\u001f\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001c0\u001bJ\u0018\u0010 \u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u0015\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u0016J\u0012\u0010!\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001c0\u001bJ\u001a\u0010\"\u001a\u000e\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u000e0\u001c0\u001b2\u0006\u0010#\u001a\u00020$J\u001c\u0010%\u001a\b\u0012\u0004\u0012\u00020\u000b0\u001c2\u0006\u0010&\u001a\u00020$H\u0086@\u00a2\u0006\u0002\u0010\'J\u0018\u0010(\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\tH\u0086@\u00a2\u0006\u0002\u0010\u0016J \u0010)\u001a\u0004\u0018\u00010\t2\u0006\u0010\u0015\u001a\u00020\t2\u0006\u0010*\u001a\u00020+H\u0086@\u00a2\u0006\u0002\u0010,J\u0016\u0010-\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000bH\u0086@\u00a2\u0006\u0002\u0010\fJ\u0016\u0010.\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000eH\u0086@\u00a2\u0006\u0002\u0010\u000fR\u0014\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00060\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006/"}, d2 = {"Lcom/finance/assistant/data/repository/ExpenseRepository;", "", "upcomingExpenseBox", "Lio/objectbox/Box;", "Lcom/finance/assistant/data/objectbox/entity/UpcomingExpenseEntity;", "recurringExpenseBox", "Lcom/finance/assistant/data/objectbox/entity/RecurringExpenseEntity;", "(Lio/objectbox/Box;Lio/objectbox/Box;)V", "addRecurringExpense", "", "expense", "Lcom/finance/assistant/domain/model/expense/RecurringExpense;", "(Lcom/finance/assistant/domain/model/expense/RecurringExpense;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "addUpcomingExpense", "Lcom/finance/assistant/domain/model/expense/UpcomingExpense;", "(Lcom/finance/assistant/domain/model/expense/UpcomingExpense;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateTotalRecurringExpenses", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "calculateTotalUpcomingExpenses", "deactivateRecurringExpense", "id", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "deleteRecurringExpense", "", "deleteUpcomingExpense", "getActiveRecurringExpenses", "Lkotlinx/coroutines/flow/Flow;", "", "getAllRecurringExpenses", "getRecurringExpenseById", "getUnpaidUpcomingExpenses", "getUpcomingExpenseById", "getUpcomingExpenses", "getUpcomingExpensesForDays", "days", "", "getUpcomingRecurringPayments", "limitDays", "(ILkotlin/coroutines/Continuation;)Ljava/lang/Object;", "markUpcomingExpenseAsPaid", "updateLastPaidDate", "date", "Ljava/time/LocalDate;", "(JLjava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "updateRecurringExpense", "updateUpcomingExpense", "app_debug"})
public final class ExpenseRepository {
    @org.jetbrains.annotations.NotNull()
    private final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity> upcomingExpenseBox = null;
    @org.jetbrains.annotations.NotNull()
    private final io.objectbox.Box<com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity> recurringExpenseBox = null;
    
    @javax.inject.Inject()
    public ExpenseRepository(@org.jetbrains.annotations.NotNull()
    io.objectbox.Box<com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity> upcomingExpenseBox, @org.jetbrains.annotations.NotNull()
    io.objectbox.Box<com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity> recurringExpenseBox) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addUpcomingExpense(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.expense.UpcomingExpense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateUpcomingExpense(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.expense.UpcomingExpense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteUpcomingExpense(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object markUpcomingExpenseAsPaid(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUpcomingExpenseById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.assistant.domain.model.expense.UpcomingExpense> $completion) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense>> getUpcomingExpenses() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense>> getUpcomingExpensesForDays(int days) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense>> getUnpaidUpcomingExpenses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object addRecurringExpense(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.expense.RecurringExpense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateRecurringExpense(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.expense.RecurringExpense expense, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deleteRecurringExpense(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object deactivateRecurringExpense(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getRecurringExpenseById(long id, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.assistant.domain.model.expense.RecurringExpense> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object updateLastPaidDate(long id, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Long> $completion) {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.expense.RecurringExpense>> getActiveRecurringExpenses() {
        return null;
    }
    
    @kotlin.OptIn(markerClass = {kotlinx.coroutines.ExperimentalCoroutinesApi.class})
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.Flow<java.util.List<com.finance.assistant.domain.model.expense.RecurringExpense>> getAllRecurringExpenses() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getUpcomingRecurringPayments(int limitDays, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.util.List<com.finance.assistant.domain.model.expense.RecurringExpense>> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object calculateTotalUpcomingExpenses(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object calculateTotalRecurringExpenses(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Double> $completion) {
        return null;
    }
}