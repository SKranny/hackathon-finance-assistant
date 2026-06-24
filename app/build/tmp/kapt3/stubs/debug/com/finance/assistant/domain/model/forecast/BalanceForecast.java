package com.finance.assistant.domain.model.forecast;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000D\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\f\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u0012\b\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\u0010\u000b\u001a\u0004\u0018\u00010\f\u0012\b\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\u0002\u0010\u0010J\t\u0010\u001d\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u001e\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000f\u0010\u001f\u001a\b\u0012\u0004\u0012\u00020\b0\u0005H\u00c6\u0003J\u000b\u0010 \u001a\u0004\u0018\u00010\nH\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\fH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003J\u000f\u0010#\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u00c6\u0003Jg\u0010$\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\u000e\b\u0002\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u00052\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\u000e\b\u0002\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0005H\u00c6\u0001J\u0013\u0010%\u001a\u00020&2\b\u0010\'\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010(\u001a\u00020)H\u00d6\u0001J\t\u0010*\u001a\u00020\fH\u00d6\u0001R\u0013\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0017\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\f0\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u0016R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u0016\u00a8\u0006+"}, d2 = {"Lcom/finance/assistant/domain/model/forecast/BalanceForecast;", "", "currentBalance", "", "salaryDates", "", "Lcom/finance/assistant/domain/model/forecast/SalaryDate;", "forecastPoints", "Lcom/finance/assistant/domain/model/forecast/ForecastPoint;", "negativeBalanceDate", "Ljava/time/LocalDate;", "negativeBalanceReason", "", "cashGapWarning", "Lcom/finance/assistant/domain/model/forecast/CashGapWarning;", "recommendations", "(DLjava/util/List;Ljava/util/List;Ljava/time/LocalDate;Ljava/lang/String;Lcom/finance/assistant/domain/model/forecast/CashGapWarning;Ljava/util/List;)V", "getCashGapWarning", "()Lcom/finance/assistant/domain/model/forecast/CashGapWarning;", "getCurrentBalance", "()D", "getForecastPoints", "()Ljava/util/List;", "getNegativeBalanceDate", "()Ljava/time/LocalDate;", "getNegativeBalanceReason", "()Ljava/lang/String;", "getRecommendations", "getSalaryDates", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
public final class BalanceForecast {
    private final double currentBalance = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.domain.model.forecast.SalaryDate> salaryDates = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.domain.model.forecast.ForecastPoint> forecastPoints = null;
    @org.jetbrains.annotations.Nullable()
    private final java.time.LocalDate negativeBalanceDate = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String negativeBalanceReason = null;
    @org.jetbrains.annotations.Nullable()
    private final com.finance.assistant.domain.model.forecast.CashGapWarning cashGapWarning = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> recommendations = null;
    
    public final double component1() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.forecast.SalaryDate> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.forecast.ForecastPoint> component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.forecast.CashGapWarning component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.forecast.BalanceForecast copy(double currentBalance, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.forecast.SalaryDate> salaryDates, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.forecast.ForecastPoint> forecastPoints, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate negativeBalanceDate, @org.jetbrains.annotations.Nullable()
    java.lang.String negativeBalanceReason, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.forecast.CashGapWarning cashGapWarning, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> recommendations) {
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
    
    public BalanceForecast(double currentBalance, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.forecast.SalaryDate> salaryDates, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.forecast.ForecastPoint> forecastPoints, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate negativeBalanceDate, @org.jetbrains.annotations.Nullable()
    java.lang.String negativeBalanceReason, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.forecast.CashGapWarning cashGapWarning, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> recommendations) {
        super();
    }
    
    public final double getCurrentBalance() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.forecast.SalaryDate> getSalaryDates() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.forecast.ForecastPoint> getForecastPoints() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getNegativeBalanceDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getNegativeBalanceReason() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.forecast.CashGapWarning getCashGapWarning() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getRecommendations() {
        return null;
    }
}