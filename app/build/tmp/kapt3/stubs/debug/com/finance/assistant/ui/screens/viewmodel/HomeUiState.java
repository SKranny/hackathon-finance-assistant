package com.finance.assistant.ui.screens.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00004\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0006\n\u0002\b\u0003\n\u0002\u0010\b\n\u0002\b\u0004\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0002\b.\b\u0087\b\u0018\u00002\u00020\u0001B\u009d\u0001\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0004\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u0005\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0007\u001a\u00020\u0003\u0012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u0006\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u0012\b\b\u0002\u0010\f\u001a\u00020\u0003\u0012\b\b\u0002\u0010\r\u001a\u00020\u0003\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u0012\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u0012\b\b\u0002\u0010\u0013\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0014\u001a\u00020\u0006\u0012\b\b\u0002\u0010\u0015\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0016J\t\u0010,\u001a\u00020\u0003H\u00c6\u0003J\t\u0010-\u001a\u00020\u000fH\u00c6\u0003J\u000f\u0010.\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011H\u00c6\u0003J\t\u0010/\u001a\u00020\u0006H\u00c6\u0003J\t\u00100\u001a\u00020\u0006H\u00c6\u0003J\t\u00101\u001a\u00020\u000fH\u00c6\u0003J\t\u00102\u001a\u00020\u0003H\u00c6\u0003J\t\u00103\u001a\u00020\u0006H\u00c6\u0003J\t\u00104\u001a\u00020\u0003H\u00c6\u0003J\u0010\u00105\u001a\u0004\u0018\u00010\u0006H\u00c6\u0003\u00a2\u0006\u0002\u0010!J\u0010\u00106\u001a\u0004\u0018\u00010\nH\u00c6\u0003\u00a2\u0006\u0002\u0010%J\u000b\u00107\u001a\u0004\u0018\u00010\u0003H\u00c6\u0003J\t\u00108\u001a\u00020\u0003H\u00c6\u0003J\t\u00109\u001a\u00020\u0003H\u00c6\u0003J\u00a6\u0001\u0010:\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00062\b\b\u0002\u0010\u0007\u001a\u00020\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00062\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\n\b\u0002\u0010\u000b\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\f\u001a\u00020\u00032\b\b\u0002\u0010\r\u001a\u00020\u00032\b\b\u0002\u0010\u000e\u001a\u00020\u000f2\u000e\b\u0002\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\b\b\u0002\u0010\u0013\u001a\u00020\u00062\b\b\u0002\u0010\u0014\u001a\u00020\u00062\b\b\u0002\u0010\u0015\u001a\u00020\u000fH\u00c6\u0001\u00a2\u0006\u0002\u0010;J\u0013\u0010<\u001a\u00020\u000f2\b\u0010=\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010>\u001a\u00020\nH\u00d6\u0001J\t\u0010?\u001a\u00020\u0003H\u00d6\u0001R\u0011\u0010\u0004\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0018R\u0011\u0010\r\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0019\u0010\u0018R\u0011\u0010\f\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u0018R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\u0007\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u0018R\u0011\u0010\u0005\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001e\u0010\u001fR\u0011\u0010\u0015\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u001cR\u0015\u0010\b\u001a\u0004\u0018\u00010\u0006\u00a2\u0006\n\n\u0002\u0010\"\u001a\u0004\b \u0010!R\u0013\u0010\u000b\u001a\u0004\u0018\u00010\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b#\u0010\u0018R\u0015\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\n\n\u0002\u0010&\u001a\u0004\b$\u0010%R\u0011\u0010\u0014\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\'\u0010\u001fR\u0011\u0010\u0013\u001a\u00020\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b(\u0010\u001fR\u0017\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u0011\u00a2\u0006\b\n\u0000\u001a\u0004\b)\u0010*R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b+\u0010\u0018\u00a8\u0006@"}, d2 = {"Lcom/finance/assistant/ui/screens/viewmodel/HomeUiState;", "", "userName", "", "avatarInitial", "freeBalance", "", "currency", "shortfallAmount", "shortfallDays", "", "shortfallDate", "cashGapTitle", "cashGapBody", "cashGapVisible", "", "upcomingEvents", "", "Lcom/finance/assistant/data/model/UpcomingEventData;", "totalIncome", "totalExpenses", "isLoading", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;DDZ)V", "getAvatarInitial", "()Ljava/lang/String;", "getCashGapBody", "getCashGapTitle", "getCashGapVisible", "()Z", "getCurrency", "getFreeBalance", "()D", "getShortfallAmount", "()Ljava/lang/Double;", "Ljava/lang/Double;", "getShortfallDate", "getShortfallDays", "()Ljava/lang/Integer;", "Ljava/lang/Integer;", "getTotalExpenses", "getTotalIncome", "getUpcomingEvents", "()Ljava/util/List;", "getUserName", "component1", "component10", "component11", "component12", "component13", "component14", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "component9", "copy", "(Ljava/lang/String;Ljava/lang/String;DLjava/lang/String;Ljava/lang/Double;Ljava/lang/Integer;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;ZLjava/util/List;DDZ)Lcom/finance/assistant/ui/screens/viewmodel/HomeUiState;", "equals", "other", "hashCode", "toString", "app_debug"})
public final class HomeUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String userName = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String avatarInitial = null;
    private final double freeBalance = 0.0;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String currency = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Double shortfallAmount = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.Integer shortfallDays = null;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String shortfallDate = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cashGapTitle = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String cashGapBody = null;
    private final boolean cashGapVisible = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.data.model.UpcomingEventData> upcomingEvents = null;
    private final double totalIncome = 0.0;
    private final double totalExpenses = 0.0;
    private final boolean isLoading = false;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    public final boolean component10() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.data.model.UpcomingEventData> component11() {
        return null;
    }
    
    public final double component12() {
        return 0.0;
    }
    
    public final double component13() {
        return 0.0;
    }
    
    public final boolean component14() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component2() {
        return null;
    }
    
    public final double component3() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component4() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double component5() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component8() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component9() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.ui.screens.viewmodel.HomeUiState copy(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String avatarInitial, double freeBalance, @org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.Nullable()
    java.lang.Double shortfallAmount, @org.jetbrains.annotations.Nullable()
    java.lang.Integer shortfallDays, @org.jetbrains.annotations.Nullable()
    java.lang.String shortfallDate, @org.jetbrains.annotations.NotNull()
    java.lang.String cashGapTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String cashGapBody, boolean cashGapVisible, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.data.model.UpcomingEventData> upcomingEvents, double totalIncome, double totalExpenses, boolean isLoading) {
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
    
    public HomeUiState(@org.jetbrains.annotations.NotNull()
    java.lang.String userName, @org.jetbrains.annotations.NotNull()
    java.lang.String avatarInitial, double freeBalance, @org.jetbrains.annotations.NotNull()
    java.lang.String currency, @org.jetbrains.annotations.Nullable()
    java.lang.Double shortfallAmount, @org.jetbrains.annotations.Nullable()
    java.lang.Integer shortfallDays, @org.jetbrains.annotations.Nullable()
    java.lang.String shortfallDate, @org.jetbrains.annotations.NotNull()
    java.lang.String cashGapTitle, @org.jetbrains.annotations.NotNull()
    java.lang.String cashGapBody, boolean cashGapVisible, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.data.model.UpcomingEventData> upcomingEvents, double totalIncome, double totalExpenses, boolean isLoading) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getUserName() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getAvatarInitial() {
        return null;
    }
    
    public final double getFreeBalance() {
        return 0.0;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCurrency() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Double getShortfallAmount() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Integer getShortfallDays() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getShortfallDate() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCashGapTitle() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getCashGapBody() {
        return null;
    }
    
    public final boolean getCashGapVisible() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.data.model.UpcomingEventData> getUpcomingEvents() {
        return null;
    }
    
    public final double getTotalIncome() {
        return 0.0;
    }
    
    public final double getTotalExpenses() {
        return 0.0;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public HomeUiState() {
        super();
    }
}