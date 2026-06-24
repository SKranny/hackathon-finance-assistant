package com.finance.assistant.domain.model.alert;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000N\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002R\u0012\u0010\u0003\u001a\u00020\u0004X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0005\u0010\u0006R\u0012\u0010\u0007\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\t\u0010\nR\u0014\u0010\u000b\u001a\u0004\u0018\u00010\fX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\r\u0010\u000eR\u0012\u0010\u000f\u001a\u00020\u0010X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0011\u0010\u0012R\u0012\u0010\u0013\u001a\u00020\u0014X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0013\u0010\u0015R\u0012\u0010\u0016\u001a\u00020\u0017X\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u0018\u0010\u0019R\u0012\u0010\u001a\u001a\u00020\bX\u00a6\u0004\u00a2\u0006\u0006\u001a\u0004\b\u001b\u0010\n\u0082\u0001\u0004\u001c\u001d\u001e\u001f\u00a8\u0006 "}, d2 = {"Lcom/finance/assistant/domain/model/alert/FinanceCase;", "", "()V", "amount", "", "getAmount", "()D", "description", "", "getDescription", "()Ljava/lang/String;", "dueDate", "Ljava/time/LocalDate;", "getDueDate", "()Ljava/time/LocalDate;", "id", "", "getId", "()J", "isResolved", "", "()Z", "severity", "Lcom/finance/assistant/domain/model/alert/CaseSeverity;", "getSeverity", "()Lcom/finance/assistant/domain/model/alert/CaseSeverity;", "title", "getTitle", "Lcom/finance/assistant/domain/model/alert/CashGapCase;", "Lcom/finance/assistant/domain/model/alert/IncomeCase;", "Lcom/finance/assistant/domain/model/alert/ScheduledExpenseCase;", "Lcom/finance/assistant/domain/model/alert/ZombieSubscriptionCase;", "app_debug"})
public abstract class FinanceCase {
    
    private FinanceCase() {
        super();
    }
    
    public abstract long getId();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getTitle();
    
    @org.jetbrains.annotations.NotNull()
    public abstract java.lang.String getDescription();
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.time.LocalDate getDueDate();
    
    public abstract double getAmount();
    
    @org.jetbrains.annotations.NotNull()
    public abstract com.finance.assistant.domain.model.alert.CaseSeverity getSeverity();
    
    public abstract boolean isResolved();
}