package com.finance.assistant.domain.model.forecast;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001e\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0005\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\b7\u0018\u00002\u00020\u0001:\u0004\u0003\u0004\u0005\u0006B\u0007\b\u0004\u00a2\u0006\u0002\u0010\u0002\u0082\u0001\u0004\u0007\b\t\n\u00a8\u0006\u000b"}, d2 = {"Lcom/finance/assistant/domain/model/forecast/GapClosureMethod;", "", "()V", "DelayExpense", "ExtraIncome", "ReduceExpense", "SavingsPlan", "Lcom/finance/assistant/domain/model/forecast/GapClosureMethod$DelayExpense;", "Lcom/finance/assistant/domain/model/forecast/GapClosureMethod$ExtraIncome;", "Lcom/finance/assistant/domain/model/forecast/GapClosureMethod$ReduceExpense;", "Lcom/finance/assistant/domain/model/forecast/GapClosureMethod$SavingsPlan;", "app_debug"})
public abstract class GapClosureMethod {
    
    private GapClosureMethod() {
        super();
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001f\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\u0002\u0010\bJ\t\u0010\u000f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u0010\u001a\u00020\u0005H\u00c6\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0007H\u00c6\u0003J)\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0007H\u00c6\u0001J\u0013\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0016H\u00d6\u0003J\t\u0010\u0017\u001a\u00020\u0018H\u00d6\u0001J\t\u0010\u0019\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000e\u00a8\u0006\u001a"}, d2 = {"Lcom/finance/assistant/domain/model/forecast/GapClosureMethod$DelayExpense;", "Lcom/finance/assistant/domain/model/forecast/GapClosureMethod;", "expenseTitle", "", "amount", "", "newDate", "Ljava/time/LocalDate;", "(Ljava/lang/String;DLjava/time/LocalDate;)V", "getAmount", "()D", "getExpenseTitle", "()Ljava/lang/String;", "getNewDate", "()Ljava/time/LocalDate;", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class DelayExpense extends com.finance.assistant.domain.model.forecast.GapClosureMethod {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String expenseTitle = null;
        private final double amount = 0.0;
        @org.jetbrains.annotations.Nullable()
        private final java.time.LocalDate newDate = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.time.LocalDate component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finance.assistant.domain.model.forecast.GapClosureMethod.DelayExpense copy(@org.jetbrains.annotations.NotNull()
        java.lang.String expenseTitle, double amount, @org.jetbrains.annotations.Nullable()
        java.time.LocalDate newDate) {
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
        
        public DelayExpense(@org.jetbrains.annotations.NotNull()
        java.lang.String expenseTitle, double amount, @org.jetbrains.annotations.Nullable()
        java.time.LocalDate newDate) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getExpenseTitle() {
            return null;
        }
        
        public final double getAmount() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.time.LocalDate getNewDate() {
            return null;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0013H\u00d6\u0001J\t\u0010\u0014\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/finance/assistant/domain/model/forecast/GapClosureMethod$ExtraIncome;", "Lcom/finance/assistant/domain/model/forecast/GapClosureMethod;", "title", "", "amount", "", "(Ljava/lang/String;D)V", "getAmount", "()D", "getTitle", "()Ljava/lang/String;", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class ExtraIncome extends com.finance.assistant.domain.model.forecast.GapClosureMethod {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String title = null;
        private final double amount = 0.0;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finance.assistant.domain.model.forecast.GapClosureMethod.ExtraIncome copy(@org.jetbrains.annotations.NotNull()
        java.lang.String title, double amount) {
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
        
        public ExtraIncome(@org.jetbrains.annotations.NotNull()
        java.lang.String title, double amount) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getTitle() {
            return null;
        }
        
        public final double getAmount() {
            return 0.0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\f\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\u001d\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\u000e\u001a\u00020\u0005H\u00c6\u0003J\t\u0010\u000f\u001a\u00020\u0005H\u00c6\u0003J\'\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0014H\u00d6\u0003J\t\u0010\u0015\u001a\u00020\u0016H\u00d6\u0001J\t\u0010\u0017\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0006\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000b\u00a8\u0006\u0018"}, d2 = {"Lcom/finance/assistant/domain/model/forecast/GapClosureMethod$ReduceExpense;", "Lcom/finance/assistant/domain/model/forecast/GapClosureMethod;", "expenseTitle", "", "originalAmount", "", "reducedAmount", "(Ljava/lang/String;DD)V", "getExpenseTitle", "()Ljava/lang/String;", "getOriginalAmount", "()D", "getReducedAmount", "component1", "component2", "component3", "copy", "equals", "", "other", "", "hashCode", "", "toString", "app_debug"})
    public static final class ReduceExpense extends com.finance.assistant.domain.model.forecast.GapClosureMethod {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String expenseTitle = null;
        private final double originalAmount = 0.0;
        private final double reducedAmount = 0.0;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        public final double component2() {
            return 0.0;
        }
        
        public final double component3() {
            return 0.0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finance.assistant.domain.model.forecast.GapClosureMethod.ReduceExpense copy(@org.jetbrains.annotations.NotNull()
        java.lang.String expenseTitle, double originalAmount, double reducedAmount) {
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
        
        public ReduceExpense(@org.jetbrains.annotations.NotNull()
        java.lang.String expenseTitle, double originalAmount, double reducedAmount) {
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getExpenseTitle() {
            return null;
        }
        
        public final double getOriginalAmount() {
            return 0.0;
        }
        
        public final double getReducedAmount() {
            return 0.0;
        }
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000,\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\b\n\u0002\b\t\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0087\b\u0018\u00002\u00020\u0001B\u0015\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\t\u0010\u000b\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\f\u001a\u00020\u0005H\u00c6\u0003J\u001d\u0010\r\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u0005H\u00c6\u0001J\u0013\u0010\u000e\u001a\u00020\u000f2\b\u0010\u0010\u001a\u0004\u0018\u00010\u0011H\u00d6\u0003J\t\u0010\u0012\u001a\u00020\u0005H\u00d6\u0001J\t\u0010\u0013\u001a\u00020\u0014H\u00d6\u0001R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\t\u0010\n\u00a8\u0006\u0015"}, d2 = {"Lcom/finance/assistant/domain/model/forecast/GapClosureMethod$SavingsPlan;", "Lcom/finance/assistant/domain/model/forecast/GapClosureMethod;", "monthlySavings", "", "monthsToAccumulate", "", "(DI)V", "getMonthlySavings", "()D", "getMonthsToAccumulate", "()I", "component1", "component2", "copy", "equals", "", "other", "", "hashCode", "toString", "", "app_debug"})
    public static final class SavingsPlan extends com.finance.assistant.domain.model.forecast.GapClosureMethod {
        private final double monthlySavings = 0.0;
        private final int monthsToAccumulate = 0;
        
        public final double component1() {
            return 0.0;
        }
        
        public final int component2() {
            return 0;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finance.assistant.domain.model.forecast.GapClosureMethod.SavingsPlan copy(double monthlySavings, int monthsToAccumulate) {
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
        
        public SavingsPlan(double monthlySavings, int monthsToAccumulate) {
        }
        
        public final double getMonthlySavings() {
            return 0.0;
        }
        
        public final int getMonthsToAccumulate() {
            return 0;
        }
    }
}