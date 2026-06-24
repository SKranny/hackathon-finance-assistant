package com.finance.assistant.data.repository;

import android.content.Context;
import com.google.gson.Gson;
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
public final class ForecastDataRepository_Factory implements Factory<ForecastDataRepository> {
  private final Provider<Context> contextProvider;

  private final Provider<Gson> gsonProvider;

  public ForecastDataRepository_Factory(Provider<Context> contextProvider,
      Provider<Gson> gsonProvider) {
    this.contextProvider = contextProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public ForecastDataRepository get() {
    return newInstance(contextProvider.get(), gsonProvider.get());
  }

  public static ForecastDataRepository_Factory create(Provider<Context> contextProvider,
      Provider<Gson> gsonProvider) {
    return new ForecastDataRepository_Factory(contextProvider, gsonProvider);
  }

  public static ForecastDataRepository newInstance(Context context, Gson gson) {
    return new ForecastDataRepository(context, gson);
  }
}
