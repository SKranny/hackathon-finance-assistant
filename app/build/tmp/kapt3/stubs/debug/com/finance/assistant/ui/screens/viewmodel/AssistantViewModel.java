package com.finance.assistant.ui.screens.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000H\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000e\n\u0002\b\u0002\b\u0007\u0018\u00002\u00020\u0001B\u0017\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u00a2\u0006\u0002\u0010\u0006J\u0006\u0010\u000e\u001a\u00020\u000fJ\u0016\u0010\u0010\u001a\u00020\u000f2\u0006\u0010\u0011\u001a\u00020\u00122\u0006\u0010\u0013\u001a\u00020\u0014J\b\u0010\u0015\u001a\u00020\u000fH\u0002J\u000e\u0010\u0016\u001a\u00020\u000f2\u0006\u0010\u0017\u001a\u00020\u0018J\u0006\u0010\u0019\u001a\u00020\u000fR\u0014\u0010\u0007\u001a\b\u0012\u0004\u0012\u00020\t0\bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u0017\u0010\n\u001a\b\u0012\u0004\u0012\u00020\t0\u000b\u00a2\u0006\b\n\u0000\u001a\u0004\b\f\u0010\r\u00a8\u0006\u001a"}, d2 = {"Lcom/finance/assistant/ui/screens/viewmodel/AssistantViewModel;", "Landroidx/lifecycle/ViewModel;", "chatRepository", "Lcom/finance/assistant/data/repository/ChatRepository;", "assistantUseCase", "Lcom/finance/assistant/domain/usecase/AssistantUseCase;", "(Lcom/finance/assistant/data/repository/ChatRepository;Lcom/finance/assistant/domain/usecase/AssistantUseCase;)V", "_uiState", "Lkotlinx/coroutines/flow/MutableStateFlow;", "Lcom/finance/assistant/ui/screens/viewmodel/AssistantUiState;", "uiState", "Lkotlinx/coroutines/flow/StateFlow;", "getUiState", "()Lkotlinx/coroutines/flow/StateFlow;", "dismissError", "", "executeAction", "messageId", "", "action", "Lcom/finance/assistant/domain/model/assistant/AssistantAction;", "loadHistory", "onInputChanged", "text", "", "sendMessage", "app_debug"})
@dagger.hilt.android.lifecycle.HiltViewModel()
public final class AssistantViewModel extends androidx.lifecycle.ViewModel {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.ChatRepository chatRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.domain.usecase.AssistantUseCase assistantUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.MutableStateFlow<com.finance.assistant.ui.screens.viewmodel.AssistantUiState> _uiState = null;
    @org.jetbrains.annotations.NotNull()
    private final kotlinx.coroutines.flow.StateFlow<com.finance.assistant.ui.screens.viewmodel.AssistantUiState> uiState = null;
    
    @javax.inject.Inject()
    public AssistantViewModel(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.ChatRepository chatRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.usecase.AssistantUseCase assistantUseCase) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final kotlinx.coroutines.flow.StateFlow<com.finance.assistant.ui.screens.viewmodel.AssistantUiState> getUiState() {
        return null;
    }
    
    private final void loadHistory() {
    }
    
    public final void onInputChanged(@org.jetbrains.annotations.NotNull()
    java.lang.String text) {
    }
    
    public final void sendMessage() {
    }
    
    public final void executeAction(long messageId, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.model.assistant.AssistantAction action) {
    }
    
    public final void dismissError() {
    }
}