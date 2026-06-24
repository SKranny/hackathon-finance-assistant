package com.finance.assistant.domain.model;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u001d\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BM\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\u0007\u0012\u0006\u0010\t\u001a\u00020\n\u0012\u0006\u0010\u000b\u001a\u00020\f\u0012\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e\u0012\b\b\u0002\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010!\u001a\u00020\u0003H\u00c6\u0003J\t\u0010\"\u001a\u00020\u0005H\u00c6\u0003J\t\u0010#\u001a\u00020\u0007H\u00c6\u0003J\t\u0010$\u001a\u00020\u0007H\u00c6\u0003J\t\u0010%\u001a\u00020\nH\u00c6\u0003J\t\u0010&\u001a\u00020\fH\u00c6\u0003J\u0010\u0010\'\u001a\u0004\u0018\u00010\u000eH\u00c6\u0003\u00a2\u0006\u0002\u0010\u001aJ\t\u0010(\u001a\u00020\u0010H\u00c6\u0003J`\u0010)\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\u00072\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\n\b\u0002\u0010\r\u001a\u0004\u0018\u00010\u000e2\b\b\u0002\u0010\u000f\u001a\u00020\u0010H\u00c6\u0001\u00a2\u0006\u0002\u0010*J\u0013\u0010+\u001a\u00020\u00102\b\u0010,\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010-\u001a\u00020.H\u00d6\u0001J\t\u0010/\u001a\u00020\u0007H\u00d6\u0001R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0011\u0010\b\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u000f\u001a\u00020\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u0018R\u0015\u0010\r\u001a\u0004\u0018\u00010\u000e\u00a2\u0006\n\n\u0002\u0010\u001b\u001a\u0004\b\u0019\u0010\u001aR\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001dR\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u0015R\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001f\u0010 \u00a8\u00060"}, d2 = {"Lcom/finance/assistant/domain/model/FinancialInsight;", "", "id", "", "type", "Lcom/finance/assistant/domain/model/InsightType;", "title", "", "description", "severity", "Lcom/finance/assistant/domain/model/InsightSeverity;", "date", "Ljava/time/LocalDate;", "relatedAmount", "", "isRead", "", "(JLcom/finance/assistant/domain/model/InsightType;Ljava/lang/String;Ljava/lang/String;Lcom/finance/assistant/domain/model/InsightSeverity;Ljava/time/LocalDate;Ljava/lang/Double;Z)V", "getDate", "()Ljava/time/LocalDate;", "getDescription", "()Ljava/lang/String;", "getId", "()J", "()Z", "getRelatedAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getSeverity", "()Lcom/finance/assistant/domain/model/InsightSeverity;", "getTitle", "getType", "()Lcom/finance/assistant/domain/model/InsightType;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "(JLcom/finance/assistant/domain/model/InsightType;Ljava/lang/String;Ljava/lang/String;Lcom/finance/assistant/domain/model/InsightSeverity;Ljava/time/LocalDate;Ljava/lang/Double;Z)Lcom/finance/assistant/domain/model/FinancialInsight;", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class FinancialInsight {
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.domain.model.InsightType type = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String title = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String description = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.domain.model.InsightSeverity severity = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDate date = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double relatedAmount = null;
    private final boolean isRead = false;
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.InsightType component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.InsightSeverity component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component7() {
        return null;
    }
    
    public final boolean component8() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.FinancialInsight copy(long id, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.InsightType type, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.InsightSeverity severity, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.Nullable()
    java.lang.Double relatedAmount, boolean isRead) {
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
    
    public FinancialInsight(long id, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.InsightType type, @org.jetbrains.annotations.NotNull()
    java.lang.String title, @org.jetbrains.annotations.NotNull()
    java.lang.String description, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.InsightSeverity severity, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.Nullable()
    java.lang.Double relatedAmount, boolean isRead) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.InsightType getType() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getDescription() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.InsightSeverity getSeverity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate getDate() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getRelatedAmount() {
        return null;
    }
    
    public final boolean isRead() {
        return false;
    }
}