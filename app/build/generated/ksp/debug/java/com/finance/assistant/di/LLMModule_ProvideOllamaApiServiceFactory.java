package com.finance.assistant.di;

import com.finance.assistant.data.remote.OllamaApiService;
import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;
import okhttp3.OkHttpClient;

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
public final class LLMModule_ProvideOllamaApiServiceFactory implements Factory<OllamaApiService> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<String> baseUrlProvider;

  private final Provider<Gson> gsonProvider;

  public LLMModule_ProvideOllamaApiServiceFactory(Provider<OkHttpClient> okHttpClientProvider,
      Provider<String> baseUrlProvider, Provider<Gson> gsonProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
    this.baseUrlProvider = baseUrlProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public OllamaApiService get() {
    return provideOllamaApiService(okHttpClientProvider.get(), baseUrlProvider.get(), gsonProvider.get());
  }

  public static LLMModule_ProvideOllamaApiServiceFactory create(
      Provider<OkHttpClient> okHttpClientProvider, Provider<String> baseUrlProvider,
      Provider<Gson> gsonProvider) {
    return new LLMModule_ProvideOllamaApiServiceFactory(okHttpClientProvider, baseUrlProvider, gsonProvider);
  }

  public static OllamaApiService provideOllamaApiService(OkHttpClient okHttpClient, String baseUrl,
      Gson gson) {
    return Preconditions.checkNotNullFromProvides(LLMModule.INSTANCE.provideOllamaApiService(okHttpClient, baseUrl, gson));
  }
}
