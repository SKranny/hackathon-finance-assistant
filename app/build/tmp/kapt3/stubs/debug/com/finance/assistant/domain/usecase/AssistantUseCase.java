package com.finance.assistant.domain.usecase;

@javax.inject.Singleton()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000z\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010\t\n\u0002\b\u0004\n\u0002\u0018\u0002\n\u0000\n\u0002\u0010$\n\u0002\b\u0004\n\u0002\u0010\u0006\n\u0002\b\u0007\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0002\b\u0006\b\u0007\u0018\u0000 82\u00020\u0001:\u00018B7\b\u0007\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0005\u0012\u0006\u0010\u0006\u001a\u00020\u0007\u0012\u0006\u0010\b\u001a\u00020\t\u0012\u0006\u0010\n\u001a\u00020\u000b\u0012\u0006\u0010\f\u001a\u00020\r\u00a2\u0006\u0002\u0010\u000eJ\u0018\u0010\u000f\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J$\u0010\u0014\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0006\u0010\u0016\u001a\u00020\u0017H\u0082@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u0018\u0010\u0019J8\u0010\u001a\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0006\u0010\u001b\u001a\u00020\u001c2\u0012\u0010\u001d\u001a\u000e\u0012\u0004\u0012\u00020\u0010\u0012\u0004\u0012\u00020\u00100\u001eH\u0086@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b\u001f\u0010 J\u0010\u0010!\u001a\u00020\u00102\u0006\u0010\"\u001a\u00020#H\u0002J \u0010$\u001a\u0004\u0018\u00010\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@\u00a2\u0006\u0002\u0010%J\u001e\u0010&\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0082@\u00a2\u0006\u0002\u0010%J\u0018\u0010\'\u001a\u00020\u00102\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J\u000e\u0010(\u001a\u00020\u0013H\u0082@\u00a2\u0006\u0002\u0010)J\u001a\u0010*\u001a\u0004\u0018\u00010+2\u0006\u0010\u0011\u001a\u00020\u00102\u0006\u0010\u0012\u001a\u00020\u0013H\u0002J,\u0010,\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0006\u0010-\u001a\u00020\u00172\u0006\u0010.\u001a\u00020/H\u0082@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b0\u00101J\u0016\u00102\u001a\u0002032\u0006\u0010\u0011\u001a\u00020\u0010H\u0086@\u00a2\u0006\u0002\u00104J,\u00105\u001a\b\u0012\u0004\u0012\u00020\u00100\u00152\u0006\u0010-\u001a\u00020\u00172\u0006\u00106\u001a\u00020/H\u0082@\u00f8\u0001\u0000\u00f8\u0001\u0001\u00a2\u0006\u0004\b7\u00101R\u000e\u0010\n\u001a\u00020\u000bX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\b\u001a\u00020\tX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0002\u001a\u00020\u0003X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0006\u001a\u00020\u0007X\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\f\u001a\u00020\rX\u0082\u0004\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0004\u001a\u00020\u0005X\u0082\u0004\u00a2\u0006\u0002\n\u0000\u0082\u0002\u000b\n\u0002\b!\n\u0005\b\u00a1\u001e0\u0001\u00a8\u00069"}, d2 = {"Lcom/finance/assistant/domain/usecase/AssistantUseCase;", "", "chatRepository", "Lcom/finance/assistant/data/repository/ChatRepository;", "userRepository", "Lcom/finance/assistant/data/repository/UserRepository;", "expenseRepository", "Lcom/finance/assistant/data/repository/ExpenseRepository;", "caseRepository", "Lcom/finance/assistant/data/repository/CaseRepository;", "balanceForecastUseCase", "Lcom/finance/assistant/domain/usecase/BalanceForecastUseCase;", "llmRepository", "Lcom/finance/assistant/data/repository/LLMRepository;", "(Lcom/finance/assistant/data/repository/ChatRepository;Lcom/finance/assistant/data/repository/UserRepository;Lcom/finance/assistant/data/repository/ExpenseRepository;Lcom/finance/assistant/data/repository/CaseRepository;Lcom/finance/assistant/domain/usecase/BalanceForecastUseCase;Lcom/finance/assistant/data/repository/LLMRepository;)V", "buildChatPrompt", "", "userMessage", "context", "Lcom/finance/assistant/domain/model/assistant/AssistantContext;", "cancelSubscription", "Lkotlin/Result;", "subscriptionId", "", "cancelSubscription-gIAlu-s", "(JLkotlin/coroutines/Continuation;)Ljava/lang/Object;", "executeAction", "actionType", "Lcom/finance/assistant/domain/model/assistant/ActionType;", "params", "", "executeAction-0E7RQCE", "(Lcom/finance/assistant/domain/model/assistant/ActionType;Ljava/util/Map;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "formatMoney", "amount", "", "generateLLMResponse", "(Ljava/lang/String;Lcom/finance/assistant/domain/model/assistant/AssistantContext;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "generateResponse", "generateRuleBasedResponse", "getContext", "(Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "parseAction", "Lcom/finance/assistant/domain/model/assistant/AssistantAction;", "rescheduleExpense", "expenseId", "newDate", "Ljava/time/LocalDate;", "rescheduleExpense-0E7RQCE", "(JLjava/time/LocalDate;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "sendMessage", "Lcom/finance/assistant/domain/model/assistant/AssistantResponse;", "(Ljava/lang/String;Lkotlin/coroutines/Continuation;)Ljava/lang/Object;", "setReminder", "reminderDate", "setReminder-0E7RQCE", "Companion", "app_debug"})
public final class AssistantUseCase {
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.ChatRepository chatRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.UserRepository userRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.ExpenseRepository expenseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.CaseRepository caseRepository = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.domain.usecase.BalanceForecastUseCase balanceForecastUseCase = null;
    @org.jetbrains.annotations.NotNull()
    private final com.finance.assistant.data.repository.LLMRepository llmRepository = null;
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String TAG = "AssistantUseCase";
    @org.jetbrains.annotations.NotNull()
    public static final com.finance.assistant.domain.usecase.AssistantUseCase.Companion Companion = null;
    
    @javax.inject.Inject()
    public AssistantUseCase(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.ChatRepository chatRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.UserRepository userRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.ExpenseRepository expenseRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.CaseRepository caseRepository, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.domain.usecase.BalanceForecastUseCase balanceForecastUseCase, @org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.repository.LLMRepository llmRepository) {
        super();
    }
    
    @org.jetbrains.annotations.Nullable()
    public final java.lang.Object sendMessage(@org.jetbrains.annotations.NotNull()
    java.lang.String userMessage, @org.jetbrains.annotations.NotNull()
    kotlin.coroutines.Continuation<? super com.finance.assistant.domain.model.assistant.AssistantResponse> $completion) {
        return null;
    }
    
    private final java.lang.Object getContext(kotlin.coroutines.Continuation<? super com.finance.assistant.domain.model.assistant.AssistantContext> $completion) {
        return null;
    }
    
    private final java.lang.Object generateResponse(java.lang.String userMessage, com.finance.assistant.domain.model.assistant.AssistantContext context, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final java.lang.Object generateLLMResponse(java.lang.String userMessage, com.finance.assistant.domain.model.assistant.AssistantContext context, kotlin.coroutines.Continuation<? super java.lang.String> $completion) {
        return null;
    }
    
    private final java.lang.String buildChatPrompt(java.lang.String userMessage, com.finance.assistant.domain.model.assistant.AssistantContext context) {
        return null;
    }
    
    private final java.lang.String generateRuleBasedResponse(java.lang.String userMessage, com.finance.assistant.domain.model.assistant.AssistantContext context) {
        return null;
    }
    
    private final com.finance.assistant.domain.model.assistant.AssistantAction parseAction(java.lang.String userMessage, com.finance.assistant.domain.model.assistant.AssistantContext context) {
        return null;
    }
    
    private final java.lang.String formatMoney(double amount) {
        return null;
    }
    
    @kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u0000\u0012\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0000\b\u0086\u0003\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0005"}, d2 = {"Lcom/finance/assistant/domain/usecase/AssistantUseCase$Companion;", "", "()V", "TAG", "", "app_debug"})
    public static final class Companion {
        
        private Companion() {
            super();
        }
    }
}