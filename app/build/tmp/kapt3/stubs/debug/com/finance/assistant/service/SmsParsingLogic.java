package com.finance.assistant.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000:\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0005\n\u0002\u0010\u0006\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001:\u0001\u0017B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\u0006\u001a\u00020\u00072\u0006\u0010\b\u001a\u00020\t2\f\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u0004H\u0002J\u001a\u0010\u000b\u001a\u0004\u0018\u00010\u00052\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tH\u0002J\u0017\u0010\u000e\u001a\u0004\u0018\u00010\u000f2\u0006\u0010\b\u001a\u00020\tH\u0002\u00a2\u0006\u0002\u0010\u0010J\u001a\u0010\u0011\u001a\u00020\t2\u0006\u0010\f\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u001a\u0010\u0013\u001a\u00020\u00142\u0006\u0010\b\u001a\u00020\t2\b\u0010\u0012\u001a\u0004\u0018\u00010\u0005H\u0002J\u0018\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\f\u001a\u00020\t2\u0006\u0010\r\u001a\u00020\tR\u0014\u0010\u0003\u001a\b\u0012\u0004\u0012\u00020\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/finance/assistant/service/SmsParsingLogic;", "", "()V", "marketplacePatterns", "", "Lcom/finance/assistant/service/SmsParsingLogic$MarketplacePattern;", "containsAny", "", "text", "", "list", "detectMarketplace", "body", "address", "extractAmount", "", "(Ljava/lang/String;)Ljava/lang/Double;", "extractTitle", "marketplace", "guessCategory", "Lcom/finance/assistant/domain/model/TransactionCategory;", "parse", "Lcom/finance/assistant/domain/model/Transaction;", "MarketplacePattern", "app_debug"})
public final class SmsParsingLogic {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.service.SmsParsingLogic.MarketplacePattern> marketplacePatterns = null;
    
    public SmsParsingLogic() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.Transaction parse(@org.jetbrains.annotations.NotNull()
    java.lang.String body, @org.jetbrains.annotations.NotNull()
    java.lang.String address) {
        return null;
    }
    
    private final com.finance.assistant.service.SmsParsingLogic.MarketplacePattern detectMarketplace(java.lang.String body, java.lang.String address) {
        return null;
    }
    
    private final java.lang.Double extractAmount(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractTitle(java.lang.String body, com.finance.assistant.service.SmsParsingLogic.MarketplacePattern marketplace) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.TransactionCategory guessCategory(java.lang.String text, com.finance.assistant.service.SmsParsingLogic.MarketplacePattern marketplace) {
        return null;
    }
    
    private final boolean containsAny(java.lang.String text, java.util.List<java.lang.String> list) {
        return false;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000(\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\b\f\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B\'\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\u0002\u0010\u0007J\t\u0010\r\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005H\u00c6\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J/\u0010\u0010\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003H\u00c6\u0001J\u0013\u0010\u0011\u001a\u00020\u00122\b\u0010\u0013\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u0014\u001a\u00020\u0015H\u00d6\u0001J\t\u0010\u0016\u001a\u00020\u0003H\u00d6\u0001R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\b\u0010\tR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00030\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\t\u00a8\u0006\u0017"}, d2 = {"Lcom/finance/assistant/service/SmsParsingLogic$MarketplacePattern;", "", "name", "", "keywords", "", "competitor", "(Ljava/lang/String;Ljava/util/List;Ljava/lang/String;)V", "getCompetitor", "()Ljava/lang/String;", "getKeywords", "()Ljava/util/List;", "getName", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "app_debug"})
    public static final class MarketplacePattern {
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
        public final com.finance.assistant.service.SmsParsingLogic.MarketplacePattern copy(@org.jetbrains.annotations.NotNull()
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
        
        public MarketplacePattern(@org.jetbrains.annotations.NotNull()
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