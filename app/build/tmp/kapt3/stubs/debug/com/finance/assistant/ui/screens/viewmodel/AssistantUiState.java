package com.finance.assistant.ui.screens.viewmodel;

@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00008\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0015\n\u0002\u0010\b\n\u0002\b\u0002\b\u0087\b\u0018\u00002\u00020\u0001B[\u0012\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u0012\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0006\u0012\b\b\u0002\u0010\t\u001a\u00020\n\u0012\b\b\u0002\u0010\u000b\u001a\u00020\f\u0012\b\b\u0002\u0010\r\u001a\u00020\f\u0012\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\u0002\u0010\u000fJ\u000f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003H\u00c6\u0003J\u001b\u0010\u0019\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0006H\u00c6\u0003J\t\u0010\u001a\u001a\u00020\nH\u00c6\u0003J\t\u0010\u001b\u001a\u00020\fH\u00c6\u0003J\t\u0010\u001c\u001a\u00020\fH\u00c6\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\nH\u00c6\u0003J_\u0010\u001e\u001a\u00020\u00002\u000e\b\u0002\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u00032\u001a\b\u0002\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u00062\b\b\u0002\u0010\t\u001a\u00020\n2\b\b\u0002\u0010\u000b\u001a\u00020\f2\b\b\u0002\u0010\r\u001a\u00020\f2\n\b\u0002\u0010\u000e\u001a\u0004\u0018\u00010\nH\u00c6\u0001J\u0013\u0010\u001f\u001a\u00020\f2\b\u0010 \u001a\u0004\u0018\u00010\u0001H\u00d6\u0003J\t\u0010!\u001a\u00020\"H\u00d6\u0001J\t\u0010#\u001a\u00020\nH\u00d6\u0001R\u0013\u0010\u000e\u001a\u0004\u0018\u00010\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0011\u0010\t\u001a\u00020\n\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0011\u0010\u000b\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\u0013R\u0011\u0010\r\u001a\u00020\f\u00a2\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u0013R#\u0010\u0005\u001a\u0014\u0012\u0004\u0012\u00020\u0007\u0012\n\u0012\b\u0012\u0004\u0012\u00020\b0\u00030\u0006\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0015R\u0017\u0010\u0002\u001a\b\u0012\u0004\u0012\u00020\u00040\u0003\u00a2\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u0017\u00a8\u0006$"}, d2 = {"Lcom/finance/assistant/ui/screens/viewmodel/AssistantUiState;", "", "messages", "", "Lcom/finance/assistant/domain/model/assistant/ChatMessage;", "messageActions", "", "", "Lcom/finance/assistant/domain/model/assistant/AssistantAction;", "inputText", "", "isLoading", "", "isUsingLLM", "errorMessage", "(Ljava/util/List;Ljava/util/Map;Ljava/lang/String;ZZLjava/lang/String;)V", "getErrorMessage", "()Ljava/lang/String;", "getInputText", "()Z", "getMessageActions", "()Ljava/util/Map;", "getMessages", "()Ljava/util/List;", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "other", "hashCode", "", "toString", "app_debug"})
public final class AssistantUiState {
    @org.jetbrains.annotations.NotNull()
    private final java.util.List<com.finance.assistant.domain.model.assistant.ChatMessage> messages = null;
    @org.jetbrains.annotations.NotNull()
    private final java.util.Map<java.lang.Long, java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction>> messageActions = null;
    @org.jetbrains.annotations.NotNull()
    private final java.lang.String inputText = null;
    private final boolean isLoading = false;
    private final boolean isUsingLLM = false;
    @org.jetbrains.annotations.Nullable()
    private final java.lang.String errorMessage = null;
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.assistant.ChatMessage> component1() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Long, java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction>> component2() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String component3() {
        return null;
    }
    
    public final boolean component4() {
        return false;
    }
    
    public final boolean component5() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String component6() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.ui.screens.viewmodel.AssistantUiState copy(@org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.assistant.ChatMessage> messages, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Long, ? extends java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction>> messageActions, @org.jetbrains.annotations.NotNull()
    java.lang.String inputText, boolean isLoading, boolean isUsingLLM, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
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
    
    public AssistantUiState(@org.jetbrains.annotations.NotNull()
    java.util.List<com.finance.assistant.domain.model.assistant.ChatMessage> messages, @org.jetbrains.annotations.NotNull()
    java.util.Map<java.lang.Long, ? extends java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction>> messageActions, @org.jetbrains.annotations.NotNull()
    java.lang.String inputText, boolean isLoading, boolean isUsingLLM, @org.jetbrains.annotations.Nullable()
    java.lang.String errorMessage) {
        super();
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.List<com.finance.assistant.domain.model.assistant.ChatMessage> getMessages() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.util.Map<java.lang.Long, java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction>> getMessageActions() {
        return null;
    }
    
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String getInputText() {
        return null;
    }
    
    public final boolean isLoading() {
        return false;
    }
    
    public final boolean isUsingLLM() {
        return false;
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.String getErrorMessage() {
        return null;
    }
    
    public AssistantUiState() {
        super();
    }
}