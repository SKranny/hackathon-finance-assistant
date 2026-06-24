package com.finance.assistant.service;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0005\u00a2\u0006\u0002\u0010\u0002J\u001e\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\r0\u0004H\u0002J\u0017\u0010\u000f\u001a\u0004\u0018\u00010\u00102\u0006\u0010\f\u001a\u00020\rH\u0002\u00a2\u0006\u0002\u0010\u0011J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0014\u001a\u00020\r2\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rH\u0002J\u0010\u0010\u0016\u001a\u00020\u00172\u0006\u0010\f\u001a\u00020\rH\u0002J\u0018\u0010\u0018\u001a\u0004\u0018\u00010\u00192\u0006\u0010\f\u001a\u00020\r2\u0006\u0010\u0015\u001a\u00020\rR\u001c\u0010\u0003\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0007\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\b0\b0\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\t\u001a\u0010\u0012\f\u0012\n \u0006*\u0004\u0018\u00010\u00050\u00050\u0004X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001a"}, d2 = {"Lcom/finance/assistant/service/DocumentParsingLogic;", "", "()V", "amountPatterns", "", "Ljava/util/regex/Pattern;", "kotlin.jvm.PlatformType", "datePatterns", "Ljava/time/format/DateTimeFormatter;", "merchantPatterns", "containsAny", "", "text", "", "list", "extractAmount", "", "(Ljava/lang/String;)Ljava/lang/Double;", "extractDate", "Ljava/time/LocalDate;", "extractTitle", "fileName", "guessCategory", "Lcom/finance/assistant/domain/model/TransactionCategory;", "parse", "Lcom/finance/assistant/domain/model/Transaction;", "app_debug"})
public final class DocumentParsingLogic {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.regex.Pattern> amountPatterns = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.time.format.DateTimeFormatter> datePatterns = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.util.regex.Pattern> merchantPatterns = null;
    
    public DocumentParsingLogic() {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.Transaction parse(@org.jetbrains.annotations.NotNull()
    java.lang.String text, @org.jetbrains.annotations.NotNull()
    java.lang.String fileName) {
        return null;
    }
    
    private final java.lang.Double extractAmount(java.lang.String text) {
        return null;
    }
    
    private final java.time.LocalDate extractDate(java.lang.String text) {
        return null;
    }
    
    private final java.lang.String extractTitle(java.lang.String text, java.lang.String fileName) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.TransactionCategory guessCategory(java.lang.String text) {
        return null;
    }
    
    private final boolean containsAny(java.lang.String text, java.util.List<java.lang.String> list) {
        return false;
    }
}