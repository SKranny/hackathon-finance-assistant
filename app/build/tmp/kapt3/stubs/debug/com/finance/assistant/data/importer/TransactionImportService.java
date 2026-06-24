package com.finance.assistant.data.importer;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000Z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u0006\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0018\u0002\n\u0002\b\u0004\n\u0002\u0010\b\n\u0000\b\u0007\u0018\u00002\u00020\u0001B\u0011\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J0\u0010\t\u001a\u00020\n2\u0006\u0010\u000b\u001a\u00020\f2\u0006\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00122\b\b\u0002\u0010\u0013\u001a\u00020\fJ\u0016\u0010\u0014\u001a\u00020\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0086@\u00a2\u0006\u0002\u0010\u0018J\u0016\u0010\u0019\u001a\u00020\u00152\u0006\u0010\u001a\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u001bJ\u0017\u0010\u001c\u001a\u0004\u0018\u00010\u000e2\u0006\u0010\u001d\u001a\u00020\fH\u0002\u00a2\u0006\u0002\u0010\u001eJ\u0010\u0010\u001f\u001a\u00020\u00122\u0006\u0010 \u001a\u00020\fH\u0002J\u0016\u0010!\u001a\b\u0012\u0004\u0012\u00020\f0\u00062\u0006\u0010\"\u001a\u00020\fH\u0002J\u0012\u0010#\u001a\u0004\u0018\u00010\u00102\u0006\u0010$\u001a\u00020\fH\u0002J\u0010\u0010%\u001a\u00020&2\u0006\u0010\'\u001a\u00020\fH\u0002J\"\u0010(\u001a\u0004\u0018\u00010\n2\u0006\u0010\"\u001a\u00020\f2\u0006\u0010)\u001a\u00020&2\u0006\u0010*\u001a\u00020+H\u0002R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u001c\u0010\u0005\u001a\u0010\u0012\f\u0012\n \b*\u0004\u0018\u00010\u00070\u00070\u0006X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006,"}, d2 = {"Lcom/finance/assistant/data/importer/TransactionImportService;", "", "context", "Landroid/content/Context;", "(Landroid/content/Context;)V", "dateFormatters", "", "Ljava/time/format/DateTimeFormatter;", "kotlin.jvm.PlatformType", "createManualTransaction", "Lcom/finance/assistant/domain/model/Transaction;", "title", "", "amount", "", "date", "Ljava/time/LocalDate;", "category", "Lcom/finance/assistant/domain/model/TransactionCategory;", "description", "importFromCsv", "Lcom/finance/assistant/data/importer/ImportResult;", "uri", "Landroid/net/Uri;", "(Landroid/net/Uri;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "importFromCsvString", "csvContent", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAmount", "amountStr", "(Ljava/lang/String;)Ljava/lang/Double;", "parseCategory", "categoryStr", "parseCsvLine", "line", "parseDate", "dateStr", "parseHeader", "Lcom/finance/assistant/data/importer/CsvColumn;", "header", "parseLine", "columns", "lineNumber", "", "app_debug"})
public final class TransactionImportService {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<java.time.format.DateTimeFormatter> dateFormatters = null;
    
    @javax.inject.Inject()
    public TransactionImportService(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object importFromCsv(@org.jetbrains.annotations.NotNull()
    android.net.Uri uri, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.assistant.data.importer.ImportResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object importFromCsvString(@org.jetbrains.annotations.NotNull()
    java.lang.String csvContent, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.assistant.data.importer.ImportResult> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.Transaction createManualTransaction(@org.jetbrains.annotations.NotNull()
    java.lang.String title, double amount, @org.jetbrains.annotations.NotNull()
    java.time.LocalDate date, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.TransactionCategory category, @org.jetbrains.annotations.NotNull()
    java.lang.String description) {
        return null;
    }
    
    private final com.finance.assistant.data.importer.CsvColumn parseHeader(java.lang.String header) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.Transaction parseLine(java.lang.String line, com.finance.assistant.data.importer.CsvColumn columns, int lineNumber) {
        return null;
    }
    
    private final java.util.List<java.lang.String> parseCsvLine(java.lang.String line) {
        return null;
    }
    
    private final java.time.LocalDate parseDate(java.lang.String dateStr) {
        return null;
    }
    
    private final java.lang.Double parseAmount(java.lang.String amountStr) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.TransactionCategory parseCategory(java.lang.String categoryStr) {
        return null;
    }
}