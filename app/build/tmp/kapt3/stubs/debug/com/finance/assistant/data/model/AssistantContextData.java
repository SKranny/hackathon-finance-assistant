package com.finance.assistant.data.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0015\n\u0002\u0010\u000b\n\u0002\b\u0004\b\u0087\b\u0018\u00002\u00020\u0001B=\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\n\u00a2\u0006\u0002\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0018\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0019\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001b\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\u001c\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001d\u001a\u00020\nH\u00c6\u0003JO\u0010\u001e\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\nH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\"\u001a\u00020\u0007H\u00d6\u0001J\t\u0010#\u001a\u00020\nH\u00d6\u0001R\u0016\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0016\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0010R\u0016\u0010\u000b\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0016\u0010\u0005\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0010R\u0016\u0010\u0004\u001a\u00020\u00038\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0010R\u0016\u0010\t\u001a\u00020\n8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0012R\u0016\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e\u00a8\u0006$"}, d2 = {"Lcom/finance/assistant/data/model/AssistantContextData;", "", "currentBalance", "", "monthlyIncome", "monthlyExpenses", "upcomingExpensesCount", "", "activeCasesCount", "nextSalaryDate", "", "currentDate", "(DDDIILjava/lang/String;Ljava/lang/String;)V", "getActiveCasesCount", "()I", "getCurrentBalance", "()D", "getCurrentDate", "()Ljava/lang/String;", "getMonthlyExpenses", "getMonthlyIncome", "getNextSalaryDate", "getUpcomingExpensesCount", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "toString", "app_debug"})
public final class AssistantContextData {
    @com.google.gson.annotations.SerializedName(value = "currentBalance")
    private final double currentBalance = 0.0;
    @com.google.gson.annotations.SerializedName(value = "monthlyIncome")
    private final double monthlyIncome = 0.0;
    @com.google.gson.annotations.SerializedName(value = "monthlyExpenses")
    private final double monthlyExpenses = 0.0;
    @com.google.gson.annotations.SerializedName(value = "upcomingExpensesCount")
    private final int upcomingExpensesCount = 0;
    @com.google.gson.annotations.SerializedName(value = "activeCasesCount")
    private final int activeCasesCount = 0;
    @com.google.gson.annotations.SerializedName(value = "nextSalaryDate")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String nextSalaryDate = null;
    @com.google.gson.annotations.SerializedName(value = "currentDate")
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currentDate = null;
    
    public final double component1() {
        return 0.0;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    public final int component4() {
        return 0;
    }
    
    public final int component5() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.data.model.AssistantContextData copy(double currentBalance, double monthlyIncome, double monthlyExpenses, int upcomingExpensesCount, int activeCasesCount, @org.jetbrains.annotations.NotNull()
    java.lang.String nextSalaryDate, @org.jetbrains.annotations.NotNull()
    java.lang.String currentDate) {
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
    
    public AssistantContextData(double currentBalance, double monthlyIncome, double monthlyExpenses, int upcomingExpensesCount, int activeCasesCount, @org.jetbrains.annotations.NotNull()
    java.lang.String nextSalaryDate, @org.jetbrains.annotations.NotNull()
    java.lang.String currentDate) {
        super();
    }
    
    public final double getCurrentBalance() {
        return 0.0;
    }
    
    public final double getMonthlyIncome() {
        return 0.0;
    }
    
    public final double getMonthlyExpenses() {
        return 0.0;
    }
    
    public final int getUpcomingExpensesCount() {
        return 0;
    }
    
    public final int getActiveCasesCount() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getNextSalaryDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrentDate() {
        return null;
    }
}