package com.finance.assistant.data.remote;

import com.google.gson.Gson;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class OllamaApiServiceImpl_Factory implements Factory<OllamaApiServiceImpl> {
  private final Provider<OkHttpClient> okHttpClientProvider;

  private final Provider<String> baseUrlProvider;

  private final Provider<Gson> gsonProvider;

  public OllamaApiServiceImpl_Factory(Provider<OkHttpClient> okHttpClientProvider,
      Provider<String> baseUrlProvider, Provider<Gson> gsonProvider) {
    this.okHttpClientProvider = okHttpClientProvider;
    this.baseUrlProvider = baseUrlProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public OllamaApiServiceImpl get() {
    return newInstance(okHttpClientProvider.get(), baseUrlProvider.get(), gsonProvider.get());
  }

  public static OllamaApiServiceImpl_Factory create(Provider<OkHttpClient> okHttpClientProvider,
      Provider<String> baseUrlProvider, Provider<Gson> gsonProvider) {
    return new OllamaApiServiceImpl_Factory(okHttpClientProvider, baseUrlProvider, gsonProvider);
  }

  public static OllamaApiServiceImpl newInstance(OkHttpClient okHttpClient, String baseUrl,
      Gson gson) {
    return new OllamaApiServiceImpl(okHttpClient, baseUrl, gson);
  }
}
