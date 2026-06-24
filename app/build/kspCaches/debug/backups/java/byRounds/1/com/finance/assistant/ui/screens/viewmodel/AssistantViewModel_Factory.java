package com.finance.assistant.ui.screens.viewmodel;

import com.finance.assistant.data.repository.LLMRepository;
import com.finance.assistant.data.repository.MockAssistantRepository;
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
  private final Provider<MockAssistantRepository> mockAssistantRepositoryProvider;

  private final Provider<LLMRepository> llmRepositoryProvider;

  public AssistantViewModel_Factory(
      Provider<MockAssistantRepository> mockAssistantRepositoryProvider,
      Provider<LLMRepository> llmRepositoryProvider) {
    this.mockAssistantRepositoryProvider = mockAssistantRepositoryProvider;
    this.llmRepositoryProvider = llmRepositoryProvider;
  }

  @Override
  public AssistantViewModel get() {
    return newInstance(mockAssistantRepositoryProvider.get(), llmRepositoryProvider.get());
  }

  public static AssistantViewModel_Factory create(
      Provider<MockAssistantRepository> mockAssistantRepositoryProvider,
      Provider<LLMRepository> llmRepositoryProvider) {
    return new AssistantViewModel_Factory(mockAssistantRepositoryProvider, llmRepositoryProvider);
  }

  public static AssistantViewModel newInstance(MockAssistantRepository mockAssistantRepository,
      LLMRepository llmRepository) {
    return new AssistantViewModel(mockAssistantRepository, llmRepository);
  }
}
