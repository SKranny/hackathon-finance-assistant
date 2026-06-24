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
public final class LLMModule_ProvideOllamaModelNameFactory implements Factory<String> {
  @Override
  public String get() {
    return provideOllamaModelName();
  }

  public static LLMModule_ProvideOllamaModelNameFactory create() {
    return InstanceHolder.INSTANCE;
  }

  public static String provideOllamaModelName() {
    return Preconditions.checkNotNullFromProvides(LLMModule.INSTANCE.provideOllamaModelName());
  }

  private static final class InstanceHolder {
    private static final LLMModule_ProvideOllamaModelNameFactory INSTANCE = new LLMModule_ProvideOllamaModelNameFactory();
  }
}
