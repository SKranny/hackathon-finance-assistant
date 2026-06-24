package com.finance.assistant.domain.model.forecast;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0000\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\u0005\u0012\f\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0015\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u0017\u001a\u00020\u0005H\u00c6\u0003J\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0003JA\u0010\u0019\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\u00052\u000e\b\u0002\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\tH\u00c6\u0001J\u0013\u0010\u001a\u001a\u00020\u001b2\b\u0010\u001c\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001d\u001a\u00020\u001eH\u00d6\u0001J\t\u0010\u001f\u001a\u00020 H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0017\u0010\b\u001a\b\u0012\u0004\u0012\u00020\n0\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\rR\u0011\u0010\u0007\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\r\u00a8\u0006!"}, d2 = {"Lcom/finance/assistant/domain/model/forecast/ForecastPoint;", "", "date", "Ljava/time/LocalDate;", "balance", "", "projectedExpenses", "projectedIncome", "events", "", "Lcom/finance/assistant/domain/model/forecast/BalanceEvent;", "(Ljava/time/LocalDate;DDDLjava/util/List;)V", "getBalance", "()D", "getDate", "()Ljava/time/LocalDate;", "getEvents", "()Ljava/util/List;", "getProjectedExpenses", "getProjectedIncome", "component1", "component2", "component3", "component4", "component5", "copy", "equals", "", "other", "hashCode", "", "toString", "", "app_debug"})
public final class ForecastPoint {
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDate date = null;
    private final double balance = 0.0;
    private final double projectedExpenses = 0.0;
    private final double projectedIncome = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.domain.model.forecast.BalanceEvent> events = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component1() {
        return null;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final double component4() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.forecast.BalanceEvent> component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.forecast.ForecastPoint copy(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, double balance, double projectedExpenses, double projectedIncome, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.forecast.BalanceEvent> events) {
        return null;
    }
    
    @java.lang.Override()
    public boolean equals(@org.jetbrains.annotations.Nullable()
    java.lang.Object other) {
        return false;
    }
    
    @java.lang.Override()
    public int hashCode() {
        return 0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String toString() {
        return null;
    }
    
    public ForecastPoint(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, double balance, double projectedExpenses, double projectedIncome, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.forecast.BalanceEvent> events) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getDate() {
        return null;
    }
    
    public final double getBalance() {
        return 0.0;
    }
    
    public final double getProjectedExpenses() {
        return 0.0;
    }
    
    public final double getProjectedIncome() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.forecast.BalanceEvent> getEvents() {
        return null;
    }
}