package com.finance.assistant.domain.usecase;

import com.finance.assistant.data.repository.CaseRepository;
import com.finance.assistant.data.repository.ChatRepository;
import com.finance.assistant.data.repository.ExpenseRepository;
import com.finance.assistant.data.repository.LLMRepository;
import com.finance.assistant.data.repository.UserRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata
@DaggerGenerated
@Generated(
    value = "dagger.internal.codegen.ComponentProcessor",
    comments = "https://dagger.dev"
)
@SuppressWarnings({
    "unchecked",
    "rawtypes",
    "KotlinInternal",
    "KotlinInternalInJava",
    "cast",
    "deprecation",
    "nullness:initialization.field.uninitialized"
})
public final class AssistantUseCase_Factory implements Factory<AssistantUseCase> {
  private final Provider<ChatRepository> chatRepositoryProvider;

  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<ExpenseRepository> expenseRepositoryProvider;

  private final Provider<CaseRepository> caseRepositoryProvider;

  private final Provider<BalanceForecastUseCase> balanceForecastUseCaseProvider;

  private final Provider<LLMRepository> llmRepositoryProvider;

  public AssistantUseCase_Factory(Provider<ChatRepository> chatRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<CaseRepository> caseRepositoryProvider,
      Provider<BalanceForecastUseCase> balanceForecastUseCaseProvider,
      Provider<LLMRepository> llmRepositoryProvider) {
    this.chatRepositoryProvider = chatRepositoryProvider;
    this.userRepositoryProvider = userRepositoryProvider;
    this.expenseRepositoryProvider = expenseRepositoryProvider;
    this.caseRepositoryProvider = caseRepositoryProvider;
    this.balanceForecastUseCaseProvider = balanceForecastUseCaseProvider;
    this.llmRepositoryProvider = llmRepositoryProvider;
  }

  @Override
  public AssistantUseCase get() {
    return newInstance(chatRepositoryProvider.get(), userRepositoryProvider.get(), expenseRepositoryProvider.get(), caseRepositoryProvider.get(), balanceForecastUseCaseProvider.get(), llmRepositoryProvider.get());
  }

  public static AssistantUseCase_Factory create(Provider<ChatRepository> chatRepositoryProvider,
      Provider<UserRepository> userRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<CaseRepository> caseRepositoryProvider,
      Provider<BalanceForecastUseCase> balanceForecastUseCaseProvider,
      Provider<LLMRepository> llmRepositoryProvider) {
    return new AssistantUseCase_Factory(chatRepositoryProvider, userRepositoryProvider, expenseRepositoryProvider, caseRepositoryProvider, balanceForecastUseCaseProvider, llmRepositoryProvider);
  }

  public static AssistantUseCase newInstance(ChatRepository chatRepository,
      UserRepository userRepository, ExpenseRepository expenseRepository,
      CaseRepository caseRepository, BalanceForecastUseCase balanceForecastUseCase,
      LLMRepository llmRepository) {
    return new AssistantUseCase(chatRepository, userRepository, expenseRepository, caseRepository, balanceForecastUseCase, llmRepository);
  }
}
