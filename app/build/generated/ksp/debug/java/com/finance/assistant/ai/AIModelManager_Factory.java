package com.finance.assistant.ai;

import android.content.Context;
import com.finance.assistant.data.repository.LLMRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class AIModelManager_Factory implements Factory<AIModelManager> {
  private final Provider<Context> contextProvider;

  private final Provider<LLMRepository> llmRepositoryProvider;

  public AIModelManager_Factory(Provider<Context> contextProvider,
      Provider<LLMRepository> llmRepositoryProvider) {
    this.contextProvider = contextProvider;
    this.llmRepositoryProvider = llmRepositoryProvider;
  }

  @Override
  public AIModelManager get() {
    return newInstance(contextProvider.get(), llmRepositoryProvider.get());
  }

  public static AIModelManager_Factory create(Provider<Context> contextProvider,
      Provider<LLMRepository> llmRepositoryProvider) {
    return new AIModelManager_Factory(contextProvider, llmRepositoryProvider);
  }

  public static AIModelManager newInstance(Context context, LLMRepository llmRepository) {
    return new AIModelManager(context, llmRepository);
  }
}
