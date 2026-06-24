package com.finance.assistant.data.repository;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000J\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010!\n\u0002\u0018\u0002\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010 \n\u0002\b\u0003\b\u0007\u0018\u00002\u00020\u0001B\u0019\b\u0007\u0012\b\b\u0001\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0018\u0010\r\u001a\u00020\u000e2\u0006\u0010\u000f\u001a\u00020\f2\u0006\u0010\u0010\u001a\u00020\bH\u0002J\u000e\u0010\u0011\u001a\u00020\bH\u0086@\u00a2\u0006\u0002\u0010\u0012J\u0006\u0010\u0013\u001a\u00020\fJ\u000e\u0010\u0014\u001a\u00020\bH\u0082@\u00a2\u0006\u0002\u0010\u0012J\u0012\u0010\u0015\u001a\u0004\u0018\u00010\u00162\u0006\u0010\u0017\u001a\u00020\u0018H\u0002J\u0010\u0010\u0019\u001a\u00020\f2\u0006\u0010\u001a\u001a\u00020\u000eH\u0002J(\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\f\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00160\u001c0\u000b2\u0006\u0010\u001d\u001a\u00020\fH\u0086@\u00a2\u0006\u0002\u0010\u001eR\u0010\u0010\u0007\u001a\u0004\u0018\u00010\bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R \u0010\t\u001a\u0014\u0012\u0010\u0012\u000e\u0012\u0004\u0012\u00020\f\u0012\u0004\u0012\u00020\f0\u000b0\nX\u0082\u0004\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u001f"}, d2 = {"Lcom/finance/assistant/data/repository/MockAssistantRepository;", "", "context", "Landroid/content/Context;", "gson", "Lcom/google/gson/Gson;", "(Landroid/content/Context;Lcom/google/gson/Gson;)V", "cachedData", "Lcom/finance/assistant/data/model/AssistantMockData;", "messageHistory", "", "Lkotlin/Pair;", "", "findMatchingResponse", "Lcom/finance/assistant/data/model/AssistantResponseData;", "message", "data", "getAssistantData", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "getGreeting", "loadFromAssets", "mapToAssistantAction", "Lcom/finance/assistant/domain/model/assistant/AssistantAction;", "actionData", "Lcom/finance/assistant/data/model/AssistantActionData;", "responseKey", "response", "sendMessage", "", "userMessage", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "app_debug"})
public final class MockAssistantRepository {
    @org.jetbrains.annotations.NotNull()
    private final android.content.Context context = null;
    @org.jetbrains.annotations.NotNull()
    private final com.google.gson.Gson gson = null;
    @org.jetbrains.annotations.Nullable()
    private com.finance.assistant.data.model.AssistantMockData cachedData;
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<kotlin.Pair<java.lang.String, java.lang.String>> messageHistory = null;
    
    @javax.inject.Inject()
    public MockAssistantRepository(@dagger.hilt.android.qualifiers.ApplicationContext()
    @org.jetbrains.annotations.NotNull()
    android.content.Context context, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object getAssistantData(@org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.assistant.data.model.AssistantMockData> $completion) {
        return null;
    }
    
    private final java.lang.Object loadFromAssets(kotlin.coroutines.Continuation<? super com.finance.assistant.data.model.AssistantMockData> $completion) {
        return null;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String userMessage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, ? extends java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction>>> $completion) {
        return null;
    }
    
    private final com.finance.assistant.data.model.AssistantResponseData findMatchingResponse(java.lang.String message, com.finance.assistant.data.model.AssistantMockData data) {
        return null;
    }
    
    private final java.lang.String responseKey(com.finance.assistant.data.model.AssistantResponseData response) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.assistant.AssistantAction mapToAssistantAction(com.finance.assistant.data.model.AssistantActionData actionData) {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getGreeting() {
        return null;
    }
}