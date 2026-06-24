package com.finance.assistant.domain.model.assistant;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000B\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0019\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001BO\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\b\b\u0002\u0010\b\u001a\u00020\t\u0012\b\b\u0002\u0010\n\u001a\u00020\u000b\u0012\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u0012\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\u0002\u0010\u0011J\t\u0010\u001f\u001a\u00020\u0003H\u00c6\u0003J\t\u0010 \u001a\u00020\u0005H\u00c6\u0003J\t\u0010!\u001a\u00020\u0007H\u00c6\u0003J\t\u0010\"\u001a\u00020\tH\u00c6\u0003J\t\u0010#\u001a\u00020\u000bH\u00c6\u0003J\u000f\u0010$\u001a\b\u0012\u0004\u0012\u00020\u000e0\rH\u00c6\u0003J\u000b\u0010%\u001a\u0004\u0018\u00010\u0010H\u00c6\u0003JW\u0010&\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00052\b\b\u0002\u0010\u0006\u001a\u00020\u00072\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u000b2\u000e\b\u0002\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r2\n\b\u0002\u0010\u000f\u001a\u0004\u0018\u00010\u0010H\u00c6\u0001J\u0013\u0010\'\u001a\u00020\u000b2\b\u0010(\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010)\u001a\u00020*H\u00d6\u0001J\t\u0010+\u001a\u00020\u0007H\u00d6\u0001R\u0013\u0010\u000f\u001a\u0004\u0018\u00010\u0010\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\u000e0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0011\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017R\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0018\u0010\u0019R\u0011\u0010\n\u001a\u00020\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u001aR\u0011\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001b\u0010\u001cR\u0011\u0010\b\u001a\u00020\t\u00a2\u0006\b\n\u0000\u001a\u0004\b\u001d\u0010\u001e\u00a8\u0006,"}, d2 = {"Lcom/finance/assistant/domain/model/assistant/ChatMessage;", "", "id", "", "role", "Lcom/finance/assistant/domain/model/assistant/MessageRole;", "content", "", "timestamp", "Ljava/time/LocalDateTime;", "isRead", "", "attachments", "", "Lcom/finance/assistant/domain/model/assistant/MessageAttachment;", "action", "Lcom/finance/assistant/domain/model/assistant/ChatAction;", "(JLcom/finance/assistant/domain/model/assistant/MessageRole;Ljava/lang/String;Ljava/time/LocalDateTime;ZLjava/util/List;Lcom/finance/assistant/domain/model/assistant/ChatAction;)V", "getAction", "()Lcom/finance/assistant/domain/model/assistant/ChatAction;", "getAttachments", "()Ljava/util/List;", "getContent", "()Ljava/lang/String;", "getId", "()J", "()Z", "getRole", "()Lcom/finance/assistant/domain/model/assistant/MessageRole;", "getTimestamp", "()Ljava/time/LocalDateTime;", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class ChatMessage {
    private final long id = 0L;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.domain.model.assistant.MessageRole role = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String content = null;
    @org.jetbrains.annotations.NotNull()
    private final java.time.LocalDateTime timestamp = null;
    private final boolean isRead = false;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.domain.model.assistant.MessageAttachment> attachments = null;
    @org.jetbrains.annotations.Nullable()
    private final com.finance.assistant.domain.model.assistant.ChatAction action = null;
    
    public final long component1() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.assistant.MessageRole component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime component4() {
        return null;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.assistant.MessageAttachment> component6() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.assistant.ChatAction component7() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.assistant.ChatMessage copy(long id, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.assistant.MessageRole role, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime timestamp, boolean isRead, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.assistant.MessageAttachment> attachments, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.assistant.ChatAction action) {
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
    
    public ChatMessage(long id, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.assistant.MessageRole role, @org.jetbrains.annotations.NotNull()
    java.lang.String content, @org.jetbrains.annotations.NotNull()
    java.time.LocalDateTime timestamp, boolean isRead, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.assistant.MessageAttachment> attachments, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.domain.model.assistant.ChatAction action) {
        super();
    }
    
    public final long getId() {
        return 0L;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.domain.model.assistant.MessageRole getRole() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getContent() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.time.LocalDateTime getTimestamp() {
        return null;
    }
    
    public final boolean isRead() {
        return false;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.assistant.MessageAttachment> getAttachments() {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.domain.model.assistant.ChatAction getAction() {
        return null;
    }
}