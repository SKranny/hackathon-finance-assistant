package com.finance.assistant.data.remote;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000>\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0003\bf\u0018\u00002\u00020\u0001J$\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u0006\u0010\u0005\u001a\u00020\u0006H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0007\u0010\bJ$\u0010\t\u001a\b\u0012\u0004\u0012\u00020\n0\u00032\u0006\u0010\u0005\u001a\u00020\u000bH\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\f\u0010\rJ\u0018\u0010\u000e\u001a\u00020\u000f2\b\b\u0002\u0010\u0010\u001a\u00020\u0011H\u00a6@\u00a2\u0006\u0002\u0010\u0012J\u001c\u0010\u0013\u001a\b\u0012\u0004\u0012\u00020\u00140\u0003H\u00a6@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0015\u0010\u0016\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u0006\u0017"}, d2 = {"Lcom/finance/assistant/data/remote/OllamaApiService;", "", "chat", "Lkotlin/Result;", "Lcom/finance/assistant/data/remote/OllamaChatResponse;", "request", "Lcom/finance/assistant/data/remote/OllamaChatRequest;", "chat-gIAlu-s", "(Lcom/finance/assistant/data/remote/OllamaChatRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generate", "Lcom/finance/assistant/data/remote/OllamaResponse;", "Lcom/finance/assistant/data/remote/OllamaGenerateRequest;", "generate-gIAlu-s", "(Lcom/finance/assistant/data/remote/OllamaGenerateRequest;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "isModelAvailable", "", "modelName", "", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "listModels", "Lcom/finance/assistant/data/remote/OllamaModelsResponse;", "listModels-IoAF18A", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public abstract interface OllamaApiService {
    
    @org.jetbrains.annotations.Nullable()
    public abstract java.lang.Object isModelAvailable(@org.jetbrains.annotations.NotNull()
    java.lang.String modelName, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super java.lang.Boolean> $completion);
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 3, xi = 48)
    public static final class DefaultImpls {
    }
}