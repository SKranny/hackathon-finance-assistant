package com.finance.assistant.ui.screens.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0002\b%\b\u0087\b\u0018\u00002\u00020\u0001B\u0085\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0005\u0012\b\b\u0002\u0010\u0010\u001a\u00020\u0005\u0012\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\r\u0012\b\b\u0002\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\u0002\u0010\u0014J\t\u0010\'\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010(\u001a\b\u0012\u0004\u0012\u00020\t0\rH\u00c6\u0003J\t\u0010)\u001a\u00020\u0013H\u00c6\u0003J\t\u0010*\u001a\u00020\u0005H\u00c6\u0003J\u0010\u0010+\u001a\u0004\u0018\u00010\u0005H\u00c6\u0003\u00a2\u0006\u0002\u0010\u001fJ\u000b\u0010,\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\u000b\u0010-\u001a\u0004\u0018\u00010\tH\u00c6\u0003J\t\u0010.\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010/\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\t\u00100\u001a\u00020\u0005H\u00c6\u0003J\t\u00101\u001a\u00020\u0005H\u00c6\u0003J\u008e\u0001\u00102\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\b\b\u0002\u0010\u000f\u001a\u00020\u00052\b\b\u0002\u0010\u0010\u001a\u00020\u00052\u000e\b\u0002\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\r2\b\b\u0002\u0010\u0012\u001a\u00020\u0013H\u00c6\u0001\u00a2\u0006\u0002\u00103J\u0013\u00104\u001a\u00020\u00132\b\u00105\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u00106\u001a\u00020\u000bH\u00d6\u0001J\t\u00107\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0013\u0010\b\u001a\u0004\u0018\u00010\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0017\u0010\u0011\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0012\u001a\u00020\u0013\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u001dR\u0015\u0010\u0006\u001a\u0004\u0018\u00010\u0005\u00a2\u0006\n\n\u0002\u0010 \u001a\u0004\b\u001e\u0010\u001fR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0011\u0010\u0010\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u001aR\u0011\u0010\u000f\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u001aR\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010\u001cR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\"\u00a8\u00068"}, d2 = {"Lcom/finance/assistant/ui/screens/viewmodel/HomeUiState;", "", "userName", "", "freeBalance", "", "shortfallAmount", "shortfallDate", "cashGapWarning", "Lcom/finance/assistant/domain/model/FinancialInsight;", "cashGapDays", "", "upcomingExpenses", "", "Lcom/finance/assistant/domain/model/expense/UpcomingExpense;", "totalIncome", "totalExpenses", "insights", "isLoading", "", "(Ljava/lang/String;DLjava/lang/Double;Ljava/lang/String;Lcom/finance/assistant/domain/model/FinancialInsight;ILjava/util/List;DDLjava/util/List;Z)V", "getCashGapDays", "()I", "getCashGapWarning", "()Lcom/finance/assistant/domain/model/FinancialInsight;", "getFreeBalance", "()D", "getInsights", "()Ljava/util/List;", "()Z", "getShortfallAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getShortfallDate", "()Ljava/lang/String;", "getTotalExpenses", "getTotalIncome", "getUpcomingExpenses", "getUserName", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;DLjava/lang/Double;Ljava/lang/String;Lcom/finance/assistant/domain/model/FinancialInsight;ILjava/util/List;DDLjava/util/List;Z)Lcom/finance/assistant/ui/screens/viewmodel/HomeUiState;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class HomeUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userName = null;
    private final double freeBalance = 0.0;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double shortfallAmount = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String shortfallDate = null;
    @org.jetbrains.annotations.Nullable()
    private final com.finance.assistant.domain.model.FinancialInsight cashGapWarning = null;
    private final int cashGapDays = 0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense> upcomingExpenses = null;
    private final double totalIncome = 0.0;
    private final double totalExpenses = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.domain.model.FinancialInsight> insights = null;
    private final boolean isLoading = false;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.FinancialInsight> component10() {
        return null;
    }
    
    public final boolean component11() {
        return false;
    }
    
    public final double component2() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.FinancialInsight component5() {
        return null;
    }
    
    public final int component6() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense> component7() {
        return null;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final double component9() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.ui.screens.viewmodel.HomeUiState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, double freeBalance, @org.jetbrains.annotations.Nullable()
    java.lang.Double shortfallAmount, @org.jetbrains.annotations.Nullable()
    java.lang.String shortfallDate, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.FinancialInsight cashGapWarning, int cashGapDays, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense> upcomingExpenses, double totalIncome, double totalExpenses, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.FinancialInsight> insights, boolean isLoading) {
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
    
    public HomeUiState(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, double freeBalance, @org.jetbrains.annotations.Nullable()
    java.lang.Double shortfallAmount, @org.jetbrains.annotations.Nullable()
    java.lang.String shortfallDate, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.FinancialInsight cashGapWarning, int cashGapDays, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense> upcomingExpenses, double totalIncome, double totalExpenses, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.FinancialInsight> insights, boolean isLoading) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserName() {
        return null;
    }
    
    public final double getFreeBalance() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getShortfallAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getShortfallDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.FinancialInsight getCashGapWarning() {
        return null;
    }
    
    public final int getCashGapDays() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.expense.UpcomingExpense> getUpcomingExpenses() {
        return null;
    }
    
    public final double getTotalIncome() {
        return 0.0;
    }
    
    public final double getTotalExpenses() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.FinancialInsight> getInsights() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public HomeUiState() {
        super();
    }
}