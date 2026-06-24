package com.finance.assistant.ui.screens;

@kotlin.Metadata(mv = {1, 9, 0}, k = 2, xi = 48, d1 = {"\u0000T\n\u0000\n\u0002\u0010\u0002\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010 \n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\u000b\n\u0002\b\u0005\n\u0002\u0010$\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\u001a\u001e\u0010\u0000\u001a\u00020\u00012\u0006\u0010\u0002\u001a\u00020\u00032\f\u0010\u0004\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001a\b\u0010\u0006\u001a\u00020\u0001H\u0003\u001a\u001c\u0010\u0007\u001a\u00020\u00012\b\b\u0002\u0010\b\u001a\u00020\t2\b\b\u0002\u0010\n\u001a\u00020\u0003H\u0007\u001a2\u0010\u000b\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\r2\f\u0010\u000e\u001a\b\u0012\u0004\u0012\u00020\u00100\u000f2\u0012\u0010\u0011\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u0012H\u0003\u001a:\u0010\u0013\u001a\u00020\u00012\u0006\u0010\u0014\u001a\u00020\u00032\u0006\u0010\u0015\u001a\u00020\u00162\u0012\u0010\u0017\u001a\u000e\u0012\u0004\u0012\u00020\u0003\u0012\u0004\u0012\u00020\u00010\u00122\f\u0010\u0018\u001a\b\u0012\u0004\u0012\u00020\u00010\u0005H\u0003\u001aT\u0010\u0019\u001a\u00020\u00012\f\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\r0\u000f2\u0018\u0010\u001b\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\n\u0012\b\u0012\u0004\u0012\u00020\u00100\u000f0\u001c2\u0018\u0010\u0011\u001a\u0014\u0012\u0004\u0012\u00020\u001d\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00010\u001e2\b\b\u0002\u0010\u001f\u001a\u00020 H\u0003\u001a\b\u0010!\u001a\u00020\u0001H\u0003\u001a\u0010\u0010\"\u001a\u00020\u00012\u0006\u0010\f\u001a\u00020\rH\u0003\u00a8\u0006#"}, d2 = {"ActionButton", "", "label", "", "onClick", "Lkotlin/Function0;", "AssistantHeader", "AssistantScreen", "viewModel", "Lcom/finance/assistant/ui/screens/viewmodel/AssistantViewModel;", "initialInputText", "BotMessageBubble", "message", "Lcom/finance/assistant/domain/model/assistant/ChatMessage;", "actions", "", "Lcom/finance/assistant/domain/model/assistant/AssistantAction;", "onActionClick", "Lkotlin/Function1;", "ChatInputBar", "inputText", "isLoading", "", "onInputChanged", "onSend", "ChatMessageList", "messages", "messageActions", "", "", "Lkotlin/Function2;", "modifier", "Landroidx/compose/ui/Modifier;", "LoadingIndicator", "UserMessageBubble", "app_debug"})
public final class AssistantScreenKt {
    
    @androidx.compose.runtime.Composable()
    public static final void AssistantScreen(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.ui.screens.viewmodel.AssistantViewModel viewModel, @org.jetbrains.annotations.NotNull()
    java.lang.String initialInputText) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void LoadingIndicator() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void AssistantHeader() {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ChatMessageList(java.util.List<com.finance.assistant.domain.model.assistant.ChatMessage> messages, java.util.Map<java.lang.Long, ? extends java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction>> messageActions, kotlin.jvm.functions.Function2<? super java.lang.Long, ? super com.finance.assistant.domain.model.assistant.AssistantAction, kotlin.Unit> onActionClick, androidx.compose.ui.Modifier modifier) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void BotMessageBubble(com.finance.assistant.domain.model.assistant.ChatMessage message, java.util.List<com.finance.assistant.domain.model.assistant.AssistantAction> actions, kotlin.jvm.functions.Function1<? super com.finance.assistant.domain.model.assistant.AssistantAction, kotlin.Unit> onActionClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void UserMessageBubble(com.finance.assistant.domain.model.assistant.ChatMessage message) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ActionButton(java.lang.String label, kotlin.jvm.functions.Function0<kotlin.Unit> onClick) {
    }
    
    @androidx.compose.runtime.Composable()
    private static final void ChatInputBar(java.lang.String inputText, boolean isLoading, kotlin.jvm.functions.Function1<? super java.lang.String, kotlin.Unit> onInputChanged, kotlin.jvm.functions.Function0<kotlin.Unit> onSend) {
    }
}