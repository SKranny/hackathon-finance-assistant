package com.finance.assistant.ui.screens.viewmodel;

import com.finance.assistant.data.repository.ChatRepository;
import com.finance.assistant.domain.usecase.AssistantUseCase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
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
public final class AssistantViewModel_Factory implements Factory<AssistantViewModel> {
  private final Provider<ChatRepository> chatRepositoryProvider;

  private final Provider<AssistantUseCase> assistantUseCaseProvider;

  public AssistantViewModel_Factory(Provider<ChatRepository> chatRepositoryProvider,
      Provider<AssistantUseCase> assistantUseCaseProvider) {
    this.chatRepositoryProvider = chatRepositoryProvider;
    this.assistantUseCaseProvider = assistantUseCaseProvider;
  }

  @Override
  public AssistantViewModel get() {
    return newInstance(chatRepositoryProvider.get(), assistantUseCaseProvider.get());
  }

  public static AssistantViewModel_Factory create(Provider<ChatRepository> chatRepositoryProvider,
      Provider<AssistantUseCase> assistantUseCaseProvider) {
    return new AssistantViewModel_Factory(chatRepositoryProvider, assistantUseCaseProvider);
  }

  public static AssistantViewModel newInstance(ChatRepository chatRepository,
      AssistantUseCase assistantUseCase) {
    return new AssistantViewModel(chatRepository, assistantUseCase);
  }
}
