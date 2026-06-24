package com.finance.assistant.domain.model.session;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000F\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0018\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\t\b\u0087\b\u0018\u00002\u00020\u0001BU\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\b\b\u0002\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\u0002\u0010\u0010J\u0006\u0010\u001e\u001a\u00020\u0000J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010 \u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\u000b\u0010!\u001a\u0004\u0018\u00010\bH\u00c6\u0003J\u000b\u0010\"\u001a\u0004\u0018\u00010\nH\u00c6\u0003J\t\u0010#\u001a\u00020\fH\u00c6\u0003J\t\u0010$\u001a\u00020\fH\u00c6\u0003J\t\u0010%\u001a\u00020\u000fH\u00c6\u0003JY\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\b\b\u0002\u0010\u000e\u001a\u00020\u000fH\u00c6\u0001J\u0013\u0010\'\u001a\u00020(2\b\u0010)\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010*\u001a\u00020+H\u00d6\u0001J\u0010\u0010,\u001a\u00020(2\b\b\u0002\u0010-\u001a\u00020+J\t\u0010.\u001a\u00020\u0003H\u00d6\u0001J\u000e\u0010/\u001a\u00020\u00002\u0006\u00100\u001a\u00020\u0006J\u0016\u00101\u001a\u00020\u00002\u0006\u00102\u001a\u00020\b2\u0006\u00103\u001a\u00020\nR\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u0012R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0014R\u0011\u0010\u000e\u001a\u00020\u000f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0016R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0017\u0010\u0012R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\b\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001a\u0010\u001bR\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001c\u0010\u001d\u00a8\u00064"}, d2 = {"Lcom/finance/assistant/domain/model/session/SessionContext;", "", "id", "", "messages", "", "Lcom/finance/assistant/domain/model/session/SessionMessage;", "lastQuery", "Lcom/finance/assistant/domain/model/session/ParsedQuery;", "lastResults", "Lcom/finance/assistant/domain/model/session/QueryResults;", "createdAt", "Ljava/time/LocalDateTime;", "lastActivity", "language", "Lcom/finance/assistant/domain/model/session/AppLanguage;", "(Ljava/lang/String;Ljava/util/List;Lcom/finance/assistant/domain/model/session/ParsedQuery;Lcom/finance/assistant/domain/model/session/QueryResults;Ljava/time/LocalDateTime;Ljava/time/LocalDateTime;Lcom/finance/assistant/domain/model/session/AppLanguage;)V", "getCreatedAt", "()Ljava/time/LocalDateTime;", "getId", "()Ljava/lang/String;", "getLanguage", "()Lcom/finance/assistant/domain/model/session/AppLanguage;", "getLastActivity", "getLastQuery", "()Lcom/finance/assistant/domain/model/session/ParsedQuery;", "getLastResults", "()Lcom/finance/assistant/domain/model/session/QueryResults;", "getMessages", "()Ljava/util/List;", "clearContext", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "", "other", "hashCode", "", "isExpired", "maxAgeMinutes", "toString", "withNewMessage", "message", "withQueryResult", "query", "results", "app_debug"})
public final class SessionContext {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String id = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.domain.model.session.SessionMessage> messages = null;
    @org.jetbrains.annotations.Nullable()
    private final com.finance.assistant.domain.model.session.ParsedQuery lastQuery = null;
    @org.jetbrains.annotations.Nullable()
    private final com.finance.assistant.domain.model.session.QueryResults lastResults = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDateTime createdAt = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDateTime lastActivity = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.domain.model.session.AppLanguage language = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.session.SessionMessage> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.session.ParsedQuery component3() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.session.QueryResults component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime component5() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.session.AppLanguage component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.session.SessionContext copy(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.session.SessionMessage> messages, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.session.ParsedQuery lastQuery, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.session.QueryResults lastResults, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime lastActivity, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.session.AppLanguage language) {
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
    
    public SessionContext(@org.jetbrains.annotations.NotNull()
    java.lang.String id, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.session.SessionMessage> messages, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.session.ParsedQuery lastQuery, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.session.QueryResults lastResults, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime createdAt, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime lastActivity, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.session.AppLanguage language) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getId() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.session.SessionMessage> getMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.session.ParsedQuery getLastQuery() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.session.QueryResults getLastResults() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getCreatedAt() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getLastActivity() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.session.AppLanguage getLanguage() {
        return null;
    }
    
    public final boolean isExpired(int maxAgeMinutes) {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.session.SessionContext withNewMessage(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.session.SessionMessage message) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.session.SessionContext withQueryResult(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.session.ParsedQuery query, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.session.QueryResults results) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.session.SessionContext clearContext() {
        return null;
    }
    
    public SessionContext() {
        super();
    }
}