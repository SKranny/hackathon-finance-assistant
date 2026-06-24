package com.finance.assistant.domain.model.alert;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b#\n\u0002\u0010\u0000\n\u0002\b\u0003\b\u0087\b\u0018\u00002\u00020\u0001Bq\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\u000e\u0012\u0006\u0010\u000f\u001a\u00020\n\u0012\b\u0010\u0010\u001a\u0004\u0018\u00010\b\u0012\u0006\u0010\u0011\u001a\u00020\u0012\u0012\u0006\u0010\u0013\u001a\u00020\n\u0012\u0006\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\u0002\u0010\u0016J\t\u0010*\u001a\u00020\u0003H\u00c6\u0003J\t\u0010+\u001a\u00020\u0012H\u00c6\u0003J\t\u0010,\u001a\u00020\nH\u00c6\u0003J\t\u0010-\u001a\u00020\u0015H\u00c6\u0003J\t\u0010.\u001a\u00020\u0005H\u00c6\u0003J\t\u0010/\u001a\u00020\u0005H\u00c6\u0003J\u000b\u00100\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\t\u00101\u001a\u00020\nH\u00c6\u0003J\t\u00102\u001a\u00020\fH\u00c6\u0003J\t\u00103\u001a\u00020\u000eH\u00c6\u0003J\t\u00104\u001a\u00020\nH\u00c6\u0003J\u000b\u00105\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u0085\u0001\u00106\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\n2\n\b\u0002\u0010\u0010\u001a\u0004\u0018\u00010\b2\b\b\u0002\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\n2\b\b\u0002\u0010\u0014\u001a\u00020\u0015H\u00c6\u0001J\u0013\u00107\u001a\u00020\u000e2\b\u00108\u001a\u0004\u0018\u000109H\u00d6\u0003J\t\u0010:\u001a\u00020\u0012H\u00d6\u0001J\t\u0010;\u001a\u00020\u0005H\u00d6\u0001R\u0014\u0010\t\u001a\u00020\nX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\u0011\u001a\u00020\u0012\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u001aR\u0014\u0010\u0006\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0016\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001eR\u0014\u0010\u0002\u001a\u00020\u0003X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 R\u0014\u0010\r\u001a\u00020\u000eX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010!R\u0013\u0010\u0010\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\"\u0010\u001eR\u0011\u0010\u000f\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0014\u0010\u000b\u001a\u00020\fX\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b$\u0010%R\u0011\u0010\u0014\u001a\u00020\u0015\u00a2\u0006\b\n\u0000\u001a\u0004\b&\u0010\'R\u0014\u0010\u0004\u001a\u00020\u0005X\u0096\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001cR\u0011\u0010\u0013\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010\u0018\u00a8\u0006<"}, d2 = {"Lcom/finance/assistant/domain/model/alert/ZombieSubscriptionCase;", "Lcom/finance/assistant/domain/model/alert/FinanceCase;", "id", "", "title", "", "description", "dueDate", "Ljava/time/LocalDate;", "amount", "", "severity", "Lcom/finance/assistant/domain/model/alert/CaseSeverity;", "isResolved", "", "monthlyAmount", "lastUsageDate", "daysSinceLastUsage", "", "yearlyCost", "suggestedAction", "Lcom/finance/assistant/domain/model/alert/SubscriptionAction;", "(JLjava/lang/String;Ljava/lang/String;Ljava/time/LocalDate;DLcom/finance/assistant/domain/model/alert/CaseSeverity;ZDLjava/time/LocalDate;IDLcom/finance/assistant/domain/model/alert/SubscriptionAction;)V", "getAmount", "()D", "getDaysSinceLastUsage", "()I", "getDescription", "()Ljava/lang/String;", "getDueDate", "()Ljava/time/LocalDate;", "getId", "()J", "()Z", "getLastUsageDate", "getMonthlyAmount", "getSeverity", "()Lcom/finance/assistant/domain/model/alert/CaseSeverity;", "getSuggestedAction", "()Lcom/finance/assistant/domain/model/alert/SubscriptionAction;", "getTitle", "getYearlyCost", "component1", "component10", "component11", "component12", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "equals", "other", "", "hashCode", "toString", "app_debug"})
public final class ZombieSubscriptionCase extends com.finance.assistant.domain.model.alert.FinanceCase {
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.Nullable()
    private final java.time.LocalDate dueDate = null;
    private final double amount = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.domain.model.alert.CaseSeverity severity = null;
    private final boolean isResolved = false;
    private final double monthlyAmount = 0.0;
    @org.jetbrains.annotations.Nullable()
    private final java.time.LocalDate lastUsageDate = null;
    private final int daysSinceLastUsage = 0;
    private final double yearlyCost = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.domain.model.alert.SubscriptionAction suggestedAction = null;
    
    public final long component1() {
        return 0L;
    }
    
    public final int component10() {
        return 0;
    }
    
    public final double component11() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.alert.SubscriptionAction component12() {
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
    
    @org.jetbrains.annotations.Nullable()
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
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.alert.ZombieSubscriptionCase copy(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate dueDate, double amount, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.alert.CaseSeverity severity, boolean isResolved, double monthlyAmount, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate lastUsageDate, int daysSinceLastUsage, double yearlyCost, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.alert.SubscriptionAction suggestedAction) {
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
    
    public ZombieSubscriptionCase(long id, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate dueDate, double amount, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.alert.CaseSeverity severity, boolean isResolved, double monthlyAmount, @org.jetbrains.annotations.Nullable()
    java.time.LocalDate lastUsageDate, int daysSinceLastUsage, double yearlyCost, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.alert.SubscriptionAction suggestedAction) {
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
    @org.jetbrains.annotations.Nullable()
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
    
    public final double getMonthlyAmount() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.time.LocalDate getLastUsageDate() {
        return null;
    }
    
    public final int getDaysSinceLastUsage() {
        return 0;
    }
    
    public final double getYearlyCost() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.alert.SubscriptionAction getSuggestedAction() {
        return null;
    }
}