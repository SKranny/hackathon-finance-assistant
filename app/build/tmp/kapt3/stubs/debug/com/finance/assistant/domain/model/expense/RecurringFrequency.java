package com.finance.assistant.domain.model.expense;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001c\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\u0006\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\u000e\u0010\u0003\u001a\u00020\u00042\u0006\u0010\u0005\u001a\u00020\u0004J\u0006\u0010\u0006\u001a\u00020\u0007j\u0002\b\bj\u0002\b\tj\u0002\b\nj\u0002\b\u000bj\u0002\b\f\u00a8\u0006\r"}, d2 = {"Lcom/finance/assistant/domain/model/expense/RecurringFrequency;", "", "(Ljava/lang/String;I)V", "calculateNextDate", "Ljava/time/LocalDate;", "from", "getDaysInterval", "", "DAILY", "WEEKLY", "MONTHLY", "QUARTERLY", "YEARLY", "app_debug"})
public enum RecurringFrequency {
    /*public static final*/ DAILY /* = new DAILY() */,
    /*public static final*/ WEEKLY /* = new WEEKLY() */,
    /*public static final*/ MONTHLY /* = new MONTHLY() */,
    /*public static final*/ QUARTERLY /* = new QUARTERLY() */,
    /*public static final*/ YEARLY /* = new YEARLY() */;
    
    RecurringFrequency() {
    }
    
    public final long getDaysInterval() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDate calculateNextDate(@org.jetbrains.annotations.NotNull()
    java.time.LocalDate from) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.finance.assistant.domain.model.expense.RecurringFrequency> getEntries() {
        return null;
    }
}