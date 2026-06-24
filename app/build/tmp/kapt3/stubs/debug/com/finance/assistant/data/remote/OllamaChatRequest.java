package com.finance.assistant.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00000\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000b\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0011\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B3\u0012\b\b\u0002\u0010\u0002\u001a\u00020\u0003\u0012\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u0012\b\b\u0002\u0010\u0007\u001a\u00020\b\u0012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000bJ\t\u0010\u0014\u001a\u00020\u0003H\u00c6\u0003J\u000f\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005H\u00c6\u0003J\t\u0010\u0016\u001a\u00020\bH\u00c6\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\nH\u00c6\u0003J9\u0010\u0018\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\u000e\b\u0002\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u00052\b\b\u0002\u0010\u0007\u001a\u00020\b2\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u0019\u001a\u00020\b2\b\u0010\u001a\u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010\u001b\u001a\u00020\u001cH\u00d6\u0001J\t\u0010\u001d\u001a\u00020\u0003H\u00d6\u0001R\u0017\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00060\u0005\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\rR\u0011\u0010\u0002\u001a\u00020\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0013\u0010\t\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0016\u0010\u0007\u001a\u00020\b8\u0006X\u0087\u0004\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0013\u00a8\u0006\u001e"}, d2 = {"Lcom/finance/assistant/data/remote/OllamaChatRequest;", "", "model", "", "messages", "", "Lcom/finance/assistant/data/remote/OllamaMessage;", "stream", "", "options", "Lcom/finance/assistant/data/remote/OllamaOptions;", "(Ljava/lang/String;Ljava/util/List;ZLcom/finance/assistant/data/remote/OllamaOptions;)V", "getMessages", "()Ljava/util/List;", "getModel", "()Ljava/lang/String;", "getOptions", "()Lcom/finance/assistant/data/remote/OllamaOptions;", "getStream", "()Z", "component1", "component2", "component3", "component4", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class OllamaChatRequest {
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String model = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.data.remote.OllamaMessage> messages = null;
    @com.google.gson.annotations.SerializedName(value = "stream")
    private final boolean stream = false;
    @org.jetbrains.annotations.Nullable()
    private final com.finance.assistant.data.remote.OllamaOptions options = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.data.remote.OllamaMessage> component2() {
        return null;
    }
    
    public final boolean component3() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.data.remote.OllamaOptions component4() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.data.remote.OllamaChatRequest copy(@org.jetbrains.annotations.NotNull()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.data.remote.OllamaMessage> messages, boolean stream, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.data.remote.OllamaOptions options) {
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
    
    public OllamaChatRequest(@org.jetbrains.annotations.NotNull()
    java.lang.String model, @org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.data.remote.OllamaMessage> messages, boolean stream, @org.jetbrains.annotations.Nullable()
    com.finance.assistant.data.remote.OllamaOptions options) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getModel() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.data.remote.OllamaMessage> getMessages() {
        return null;
    }
    
    public final boolean getStream() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final com.finance.assistant.data.remote.OllamaOptions getOptions() {
        return null;
    }
}