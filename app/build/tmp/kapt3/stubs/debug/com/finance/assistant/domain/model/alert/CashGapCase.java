package com.finance.assistant.domain.model.alert;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\b!\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bk\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\u0006\u0010\u0007\u001a\u00020\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\u0006\u0010\u0010\u001a\u00020\u0011\u0012\u0006\u0010\u0012\u001a\u00020\n\u0012\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u00a2\u0006\u0002\u0010\u0015J\t\u0010(\u001a\u00020\u0003H\u00c6\u0003J\t\u0010)\u001a\u00020\nH\u00c6\u0003J\u000f\u0010*\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u00c6\u0003J\t\u0010+\u001a\u00020\u0005H\u00c6\u0003J\t\u0010,\u001a\u00020\u0005H\u00c6\u0003J\t\u0010-\u001a\u00020\bH\u00c6\u0003J\t\u0010.\u001a\u00020\nH\u00c6\u0003J\t\u0010/\u001a\u00020\fH\u00c6\u0003J\t\u00100\u001a\u00020\u000eH\u00c6\u0003J\t\u00101\u001a\u00020\nH\u00c6\u0003J\t\u00102\u001a\u00020\u0011H\u00c6\u0003J}\u00103\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\b\b\u0002\u0010\u0010\u001a\u00020\u00112\b\b\u0002\u0010\u0012\u001a\u00020\n2\u000e\b\u0002\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014H\u00c6\u0001J\u0013\u00104\u001a\u00020\u000e2\b\u00105\u001a\u0004\u0018\u000106H\u00d6\u0003J\t\u00107\u001a\u00020\u0011H\u00d6\u0001J\t\u00108\u001a\u00020\u0005H\u00d6\u0001R\u0017\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00050\u0014\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\u0010\u001a\u00020\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0014\u0010\u0007\u001a\u00020\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b \u0010\u0019R\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b!\u0010\"R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010#R\u0011\u0010\u0012\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010\u0019R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b%\u0010&R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001d\u00a8\u00069"}, d2 = {"Lcom/finance/assistant/domain/model/alert/CashGapCase;", "Lcom/finance/assistant/domain/model/alert/FinanceCase;", "id", "", "title", "", "description", "dueDate", "Ljava/time/LocalDate;", "amount", "", "severity", "Lcom/finance/assistant/domain/model/alert/CaseSeverity;", "isResolved", "", "gapAmount", "daysUntilSalary", "", "recommendedSavingsPerDay", "affectedExpenses", "", "(JLjava/lang/String;Ljava/lang/String;Ljava/time/LocalDate;DLcom/finance/assistant/domain/model/alert/CaseSeverity;ZDIDLjava/util/List;)V", "getAffectedExpenses", "()Ljava/util/List;", "getAmount", "()D", "getDaysUntilSalary", "()I", "getDescription", "()Ljava/lang/String;", "getDueDate", "()Ljava/time/LocalDate;", "getGapAmount", "getId", "()J", "()Z", "getRecommendedSavingsPerDay", "getSeverity", "()Lcom/finance/assistant/domain/model/alert/CaseSeverity;", "getTitle", "component1", "component10", "component11", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_debug"})
public final class CashGapCase extends com.finance.assistant.domain.model.alert.FinanceCase {
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDate dueDate = null;
    private final double amount = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.domain.model.alert.CaseSeverity severity = null;
    private final boolean isResolved = false;
    private final double gapAmount = 0.0;
    private final int daysUntilSalary = 0;
    private final double recommendedSavingsPerDay = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> affectedExpenses = null;
    
    public final long component1() {
        return 0L;
    }
    
    public final double component10() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> component11() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component4() {
        return null;
    }
    
    public final double component5() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.alert.CaseSeverity component6() {
        return null;
    }
    
    public final boolean component7() {
        return false;
    }
    
    public final double component8() {
        return 0.0;
    }
    
    public final int component9() {
        return 0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.alert.CashGapCase copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate dueDate, double amount, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.alert.CaseSeverity severity, boolean isResolved, double gapAmount, int daysUntilSalary, double recommendedSavingsPerDay, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> affectedExpenses) {
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
    
    public CashGapCase(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate dueDate, double amount, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.alert.CaseSeverity severity, boolean isResolved, double gapAmount, int daysUntilSalary, double recommendedSavingsPerDay, @org.jetbrains.annotations.NotNull()
    java.util.List<java.lang.String> affectedExpenses) {
    }
    
    @java.lang.Override()
    public long getId() {
        return 0L;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getTitle() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.lang.String getDescription() {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public java.time.LocalDate getDueDate() {
        return null;
    }
    
    @java.lang.Override()
    public double getAmount() {
        return 0.0;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public com.finance.assistant.domain.model.alert.CaseSeverity getSeverity() {
        return null;
    }
    
    @java.lang.Override()
    public boolean isResolved() {
        return false;
    }
    
    public final double getGapAmount() {
        return 0.0;
    }
    
    public final int getDaysUntilSalary() {
        return 0;
    }
    
    public final double getRecommendedSavingsPerDay() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<java.lang.String> getAffectedExpenses() {
        return null;
    }
}