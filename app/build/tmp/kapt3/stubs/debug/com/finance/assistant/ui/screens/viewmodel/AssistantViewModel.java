package com.finance.assistant.ui.screens.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\\\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0010\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0010\u0010\u0012\u001a\u00020\u00132\u0006\u0010\u0014\u001a\u00020\u0013H\u0002J\u0006\u0010\u0015\u001a\u00020\u0016J\u0016\u0010\u0017\u001a\u00020\u00162\u0006\u0010\u0018\u001a\u00020\u000b2\u0006\u0010\u0019\u001a\u00020\u001aJ\u0016\u0010\u001b\u001a\b\u0012\u0004\u0012\u00020\u001a0\u001c2\u0006\u0010\u001d\u001a\u00020\u0013H\u0002J(\u0010\u001e\u001a\u0014\u0012\u0004\u0012\u00020\u0013\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u001a0\u001c0\u001f2\u0006\u0010\u0014\u001a\u00020\u0013H\u0082@\u00a2\u0006\u0002\u0010 J\b\u0010!\u001a\u00020\u0016H\u0002J\u000e\u0010\"\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010#\u001a\u00020\u0016J\u000e\u0010$\u001a\u00020\u00162\u0006\u0010\u001d\u001a\u00020\u0013J\u0006\u0010%\u001a\u00020\u0016R\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u000e\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\f\u001a\b\u0012\u0004\u0012\u00020\t0\r\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u000e\u0010\u0010\u001a\u00020\u0011X\u0082\u000e\u00a2\u0006\u0002\n\u0000\u00a8\u0006&"}, d2 = {"Lcom/finance/assistant/ui/screens/viewmodel/AssistantViewModel;", "Landroidx/lifecycle/ViewModel;", "mockAssistantRepository", "Lcom/finance/assistant/data/repository/MockAssistantRepository;", "llmRepository", "Lcom/finance/assistant/data/repository/LLMRepository;", "(Lcom/finance/assistant/data/repository/MockAssistantRepository;Lcom/finance/assistant/data/repository/LLMRepository;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/finance/assistant/ui/screens/viewmodel/AssistantUiState;", "messageIdCounter", "", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "useRealLLM", "", "buildLLMPrompt", "", "userMessage", "dismissError", "", "executeAction", "messageId", "action", "Lcom/finance/assistant/domain/model/assistant/AssistantAction;", "extractActionsFromResponse", "", "text", "getLLMResponse", "Lkotlin/Pair;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "loadGreeting", "onInputChanged", "sendMessage", "setInitialTextAndSend", "toggleAssistantMode", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AssistantViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.MockAssistantRepository mockAssistantRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.LLMRepository llmRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.finance.assistant.ui.screens.viewmodel.AssistantUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.finance.assistant.ui.screens.viewmodel.AssistantUiState> uiState = null;
    private long messageIdCounter = 0L;
    private boolean useRealLLM = true;
    
    @javax.inject.Inject()
    public AssistantViewModel(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.MockAssistantRepository mockAssistantRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.LLMRepository llmRepository) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.finance.assistant.ui.screens.viewmodel.AssistantUiState> getUiState() {
        return null;
    }
    
    private final void loadGreeting() {
    }
    
    public final void onInputChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void setInitialTextAndSend(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void sendMessage() {
    }
    
    private final java.lang.Object getLLMResponse(java.lang.String userMessage, kotlin.coroutines.Continuation<? super kotlin.Pair<java.lang.String, ? extends java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction>>> $completion) {
        return null;
    }
    
    private final java.lang.String buildLLMPrompt(java.lang.String userMessage) {
        return null;
    }
    
    private final java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction> extractActionsFromResponse(java.lang.String text) {
        return null;
    }
    
    public final void executeAction(long messageId, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.assistant.AssistantAction action) {
    }
    
    public final void dismissError() {
    }
    
    public final void toggleAssistantMode() {
    }
}