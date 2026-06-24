package com.finance.assistant.data.repository;

import com.finance.assistant.data.remote.OllamaApiService;
import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class OllamaLLMRepository_Factory implements Factory<OllamaLLMRepository> {
  private final Provider<OllamaApiService> apiServiceProvider;

  private final Provider<Gson> gsonProvider;

  private final Provider<String> modelNameProvider;

  public OllamaLLMRepository_Factory(Provider<OllamaApiService> apiServiceProvider,
      Provider<Gson> gsonProvider, Provider<String> modelNameProvider) {
    this.apiServiceProvider = apiServiceProvider;
    this.gsonProvider = gsonProvider;
    this.modelNameProvider = modelNameProvider;
  }

  @Override
  public OllamaLLMRepository get() {
    return newInstance(apiServiceProvider.get(), gsonProvider.get(), modelNameProvider.get());
  }

  public static OllamaLLMRepository_Factory create(Provider<OllamaApiService> apiServiceProvider,
      Provider<Gson> gsonProvider, Provider<String> modelNameProvider) {
    return new OllamaLLMRepository_Factory(apiServiceProvider, gsonProvider, modelNameProvider);
  }

  public static OllamaLLMRepository newInstance(OllamaApiService apiService, Gson gson,
      String modelName) {
    return new OllamaLLMRepository(apiService, gson, modelName);
  }
}
