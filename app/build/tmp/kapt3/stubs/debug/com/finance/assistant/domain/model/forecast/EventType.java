package com.finance.assistant.domain.model.forecast;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\f\n\u0002\u0018\u0002\n\u0002\u0010\u0010\n\u0002\b\u0007\b\u0086\u0081\u0002\u0018\u00002\b\u0012\u0004\u0012\u00020\u00000\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002j\u0002\b\u0003j\u0002\b\u0004j\u0002\b\u0005j\u0002\b\u0006j\u0002\b\u0007\u00a8\u0006\b"}, d2 = {"Lcom/finance/assistant/domain/model/forecast/EventType;", "", "(Ljava/lang/String;I)V", "SCHEDULED_EXPENSE", "RECURRING_EXPENSE", "INCOME", "SALARY", "SUBSCRIPTION", "app_debug"})
public enum EventType {
    /*public static final*/ SCHEDULED_EXPENSE /* = new SCHEDULED_EXPENSE() */,
    /*public static final*/ RECURRING_EXPENSE /* = new RECURRING_EXPENSE() */,
    /*public static final*/ INCOME /* = new INCOME() */,
    /*public static final*/ SALARY /* = new SALARY() */,
    /*public static final*/ SUBSCRIPTION /* = new SUBSCRIPTION() */;
    
    EventType() {
    }
    
    @org.jetbrains.annotations.NotNull()
    public static kotlin.enums.EnumEntries<com.finance.assistant.domain.model.forecast.EventType> getEntries() {
        return null;
    }
}