package com.finance.assistant.service;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000$\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\b\n\u0002\b\u0002\b\u0007\u0018\u0000 \n2\u00020\u0001:\u0001\nB\u000f\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\u0002\u0010\u0004J\u0016\u0010\u0005\u001a\b\u0012\u0004\u0012\u00020\u00070\u00062\b\b\u0002\u0010\b\u001a\u00020\tR\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u000b"}, d2 = {"Lcom/finance/assistant/service/CalendarScanner;", "", "contentResolver", "Landroid/content/ContentResolver;", "(Landroid/content/ContentResolver;)V", "scanUpcomingEvents", "", "Lcom/finance/assistant/domain/model/CalendarEvent;", "daysAhead", "", "Companion", "app_debug"})
public final class CalendarScanner {
    @org.jetbrains.annotations.NotNull()
    private final android.content.ContentResolver contentResolver = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "CalendarScanner";
    @org.jetbrains.annotations.NotNull()
    public static final com.finance.assistant.service.CalendarScanner.Companion Companion = null;
    
    @javax.inject.Inject()
    public CalendarScanner(@org.jetbrains.annotations.NotNull()
    android.content.ContentResolver contentResolver) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.CalendarEvent> scanUpcomingEvents(int daysAhead) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/finance/assistant/service/CalendarScanner$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}