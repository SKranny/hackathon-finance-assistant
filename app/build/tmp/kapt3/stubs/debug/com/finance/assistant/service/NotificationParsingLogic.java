package com.finance.assistant.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u001dB\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\f\u001a\u00020\r2\u0006\u0010\u000e\u001a\u00020\n2\f\u0010\u000f\u001a\b\u0012\u0004\u0012\u00020\n0\u0004H\u0002J\u0012\u0010\u0010\u001a\u0004\u0018\u00010\b2\u0006\u0010\u000e\u001a\u00020\nH\u0002J\u0017\u0010\u0011\u001a\u0004\u0018\u00010\u00122\u0006\u0010\u000e\u001a\u00020\nH\u0002\u00a2\u0006\u0002\u0010\u0013J\u001a\u0010\u0014\u001a\u00020\n2\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0002J\u001a\u0010\u0016\u001a\u00020\u00172\u0006\u0010\u000e\u001a\u00020\n2\b\u0010\u0015\u001a\u0004\u0018\u00010\bH\u0002J \u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\u000e\u001a\u00020\n2\u0006\u0010\u001a\u001a\u00020\n2\u0006\u0010\u001b\u001a\u00020\u001cR\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0014\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\n0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001e"}, d2 = {"Lcom/finance/assistant/service/NotificationParsingLogic;", "", "()V", "amountPatterns", "", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "bankPatterns", "Lcom/finance/assistant/service/NotificationParsingLogic$BankPattern;", "skipKeywords", "", "skipPackagePatterns", "containsAny", "", "text", "list", "detectBank", "extractAmount", "", "(Ljava/lang/String;)Ljava/lang/Double;", "extractTitle", "bank", "guessCategory", "Lcom/finance/assistant/domain/model/TransactionCategory;", "parse", "Lcom/finance/assistant/domain/model/Transaction;", "packageName", "timestamp", "", "BankPattern", "app_debug"})
public final class NotificationParsingLogic {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.service.NotificationParsingLogic.BankPattern> bankPatterns = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> skipPackagePatterns = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.regex.Pattern> amountPatterns = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.lang.String> skipKeywords = null;
    
    public NotificationParsingLogic() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.Transaction parse(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String packageName, long timestamp) {
        return null;
    }
    
    private final com.finance.assistant.service.NotificationParsingLogic.BankPattern detectBank(java.lang.String text) {
        return null;
    }
    
    private final java.lang.Double extractAmount(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractTitle(java.lang.String text, com.finance.assistant.service.NotificationParsingLogic.BankPattern bank) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.TransactionCategory guessCategory(java.lang.String text, com.finance.assistant.service.NotificationParsingLogic.BankPattern bank) {
        return null;
    }
    
    private final boolean containsAny(java.lang.String text, java.util.List<java.lang.String> list) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J/\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/finance/assistant/service/NotificationParsingLogic$BankPattern;", "", "name", "", "keywords", "", "competitor", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCompetitor", "()Ljava/lang/String;", "getKeywords", "()Ljava/util/List;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class BankPattern {
        @org.jetbrains.annotations.NotNull()
        private final java.lang.String name = null;
        @org.jetbrains.annotations.NotNull()
        private final java.util.List<java.lang.String> keywords = null;
        @org.jetbrains.annotations.Nullable()
        private final java.lang.String competitor = null;
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String component1() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> component2() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String component3() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final com.finance.assistant.service.NotificationParsingLogic.BankPattern copy(@org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> keywords, @org.jetbrains.annotations.Nullable()
        java.lang.String competitor) {
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
        
        public BankPattern(@org.jetbrains.annotations.NotNull()
        java.lang.String name, @org.jetbrains.annotations.NotNull()
        java.util.List<java.lang.String> keywords, @org.jetbrains.annotations.Nullable()
        java.lang.String competitor) {
            super();
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.lang.String getName() {
            return null;
        }
        
        @org.jetbrains.annotations.NotNull()
        public final java.util.List<java.lang.String> getKeywords() {
            return null;
        }
        
        @org.jetbrains.annotations.Nullable()
        public final java.lang.String getCompetitor() {
            return null;
        }
    }
}