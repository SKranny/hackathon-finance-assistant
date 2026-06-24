package com.finance.assistant.data.remote;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000L\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0004\b\u0007\u0018\u0000 \u001d2\u00020\u0001:\u0001\u001dB!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\b\u0001\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\u000b0\n2\u0006\u0010\f\u001a\u00020\rH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u000e\u0010\u000fJ$\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00110\n2\u0006\u0010\f\u001a\u00020\u0012H\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J\u0016\u0010\u0015\u001a\u00020\u00162\u0006\u0010\u0017\u001a\u00020\u0005H\u0096@\u00a2\u0006\u0002\u0010\u0018J\u001c\u0010\u0019\u001a\b\u0012\u0004\u0012\u00020\u001a0\nH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001b\u0010\u001cR\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001e"}, d2 = {"Lcom/finance/assistant/data/remote/OllamaApiServiceImpl;", "Lcom/finance/assistant/data/remote/OllamaApiService;", "okHttpClient", "Lokhttp3/OkHttpClient;", "baseUrl", "", "gson", "Lcom/google/gson/Gson;", "(Lokhttp3/OkHttpClient;Ljava/lang/String;Lcom/google/gson/Gson;)V", "chat", "Lkotlin/Result;", "Lcom/finance/assistant/data/remote/OllamaChatResponse;", "request", "Lcom/finance/assistant/data/remote/OllamaChatRequest;", "chat-gIAlu-s", "(Lcom/finance/assistant/data/remote/OllamaChatRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generate", "Lcom/finance/assistant/data/remote/OllamaResponse;", "Lcom/finance/assistant/data/remote/OllamaGenerateRequest;", "generate-gIAlu-s", "(Lcom/finance/assistant/data/remote/OllamaGenerateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isModelAvailable", "", "modelName", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listModels", "Lcom/finance/assistant/data/remote/OllamaModelsResponse;", "listModels-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "Companion", "app_debug"})
public final class OllamaApiServiceImpl implements com.finance.assistant.data.remote.OllamaApiService {
    @org.jetbrains.annotations.NotNull()
    private final okhttp3.OkHttpClient okHttpClient = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String baseUrl = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String API_GENERATE = "/api/generate";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String API_CHAT = "/api/chat";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String API_TAGS = "/api/tags";
    @org.jetbrains.annotations.NotNull()
    private static final okhttp3.MediaType JSON_MEDIA_TYPE = null;
    @org.jetbrains.annotations.NotNull()
    public static final com.finance.assistant.data.remote.OllamaApiServiceImpl.Companion Companion = null;
    
    @javax.inject.Inject()
    public OllamaApiServiceImpl(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @javax.inject.Named(value = "ollama_base_url")
    @org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object isModelAvailable(@org.jetbrains.annotations.NotNull()
    java.lang.String modelName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u001a\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0007\u001a\u00020\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\t"}, d2 = {"Lcom/finance/assistant/data/remote/OllamaApiServiceImpl$Companion;", "", "()V", "API_CHAT", "", "API_GENERATE", "API_TAGS", "JSON_MEDIA_TYPE", "Lokhttp3/MediaType;", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}