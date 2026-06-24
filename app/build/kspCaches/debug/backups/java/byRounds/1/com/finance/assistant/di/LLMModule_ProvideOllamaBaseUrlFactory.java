package com.finance.assistant.di;

import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;

@ScopeMetadata
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
public final class LLMModule_ProvideOllamaBaseUrlFactory implements Factory<String> {
  @Override
  public String get() {
    return provideOllamaBaseUrl();
  }

  public static LLMModule_ProvideOllamaBaseUrlFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provideOllamaBaseUrl() {
    return Preconditions.checkNotNullFromProvides(LLMModule.INSTANCE.provideOllamaBaseUrl());
  }

  private static final class InstanceHolder {
    private static final LLMModule_ProvideOllamaBaseUrlFactory INSTANCE = new LLMModule_ProvideOllamaBaseUrlFactory();
  }
}
