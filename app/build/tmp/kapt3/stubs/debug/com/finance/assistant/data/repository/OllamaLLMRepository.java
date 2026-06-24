package com.finance.assistant.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000@\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u0007\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0005\n\u0002\u0010\u000b\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B!\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\b\b\u0001\u0010\u0006\u001a\u00020\u0007\u00a2\u0006\u0002\u0010\bJ\u0010\u0010\t\u001a\u00020\u00072\u0006\u0010\n\u001a\u00020\u0007H\u0002J\u001e\u0010\u000b\u001a\b\u0012\u0004\u0012\u00020\u00070\f2\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0016J,\u0010\u0010\u001a\b\u0012\u0004\u0012\u00020\u00120\u00112\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0013\u0010\u0014J,\u0010\u0015\u001a\b\u0012\u0004\u0012\u00020\u00070\u00112\u0006\u0010\r\u001a\u00020\u00072\u0006\u0010\u000e\u001a\u00020\u000fH\u0096@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0016\u0010\u0014J\u000e\u0010\u0017\u001a\u00020\u0018H\u0096@\u00a2\u0006\u0002\u0010\u0019R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u001a"}, d2 = {"Lcom/finance/assistant/data/repository/OllamaLLMRepository;", "Lcom/finance/assistant/data/repository/LLMRepository;", "apiService", "Lcom/finance/assistant/data/remote/OllamaApiService;", "gson", "Lcom/google/gson/Gson;", "modelName", "", "(Lcom/finance/assistant/data/remote/OllamaApiService;Lcom/google/gson/Gson;Ljava/lang/String;)V", "cleanJsonResponse", "response", "generateStream", "Lkotlinx/coroutines/flow/Flow;", "prompt", "temperature", "", "generateStructuredJson", "Lkotlin/Result;", "Lcom/finance/assistant/data/remote/LLMInsightsResponse;", "generateStructuredJson-0E7RQCE", "(Ljava/lang/String;FLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateText", "generateText-0E7RQCE", "isAvailable", "", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class OllamaLLMRepository implements com.finance.assistant.data.repository.LLMRepository {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.remote.OllamaApiService apiService = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String modelName = null;
    
    @javax.inject.Inject()
    public OllamaLLMRepository(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.remote.OllamaApiService apiService, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @javax.inject.Named(value = "ollama_model")
    @org.jetbrains.annotations.NotNull()
    java.lang.String modelName) {
        super();
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.NotNull()
    public kotlinx.coroutines.flow.Flow<java.lang.String> generateStream(@org.jetbrains.annotations.NotNull()
    java.lang.String prompt, float temperature) {
        return null;
    }
    
    @java.lang.Override()
    @org.jetbrains.annotations.Nullable()
    public java.lang.Object isAvailable(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion) {
        return null;
    }
    
    private final java.lang.String cleanJsonResponse(java.lang.String response) {
        return null;
    }
}