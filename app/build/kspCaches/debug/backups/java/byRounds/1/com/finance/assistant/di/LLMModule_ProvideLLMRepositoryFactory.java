package com.finance.assistant.di;

import com.finance.assistant.data.remote.OllamaApiService;
import com.finance.assistant.data.repository.LLMRepository;
import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("javax.inject.Named")
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
public final class LLMModule_ProvideLLMRepositoryFactory implements Factory<LLMRepository> {
  private final Provider<OllamaApiService> apiServiceProvider;

  private final Provider<Gson> gsonProvider;

  private final Provider<String> modelNameProvider;

  public LLMModule_ProvideLLMRepositoryFactory(Provider<OllamaApiService> apiServiceProvider,
      Provider<Gson> gsonProvider, Provider<String> modelNameProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.gsonProvider = gsonProvider;
    this.modelNameProvider = modelNameProvider;
  }

  @Override
  public LLMRepository get() {
    return provideLLMRepository(apiServiceProvider.get(), gsonProvider.get(), modelNameProvider.get());
  }

  public static LLMModule_ProvideLLMRepositoryFactory create(
      Provider<OllamaApiService> apiServiceProvider, Provider<Gson> gsonProvider,
      Provider<String> modelNameProvider) {
    return new LLMModule_ProvideLLMRepositoryFactory(apiServiceProvider, gsonProvider, modelNameProvider);
  }

  public static LLMRepository provideLLMRepository(OllamaApiService apiService, Gson gson,
      String modelName) {
    return Preconditions.checkNotNullFromProvides(LLMModule.INSTANCE.provideLLMRepository(apiService, gson, modelName));
  }
}
