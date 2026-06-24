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
public final class CashGapDataRepository_Factory implements Factory<CashGapDataRepository> {
  private final Provider<Context> contextProvider;

  private final Provider<Gson> gsonProvider;

  public CashGapDataRepository_Factory(Provider<Context> contextProvider,
      Provider<Gson> gsonProvider) {
    this.contextProvider = contextProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public CashGapDataRepository get() {
    return newInstance(contextProvider.get(), gsonProvider.get());
  }

  public static CashGapDataRepository_Factory create(Provider<Context> contextProvider,
      Provider<Gson> gsonProvider) {
    return new CashGapDataRepository_Factory(contextProvider, gsonProvider);
  }

  public static CashGapDataRepository newInstance(Context context, Gson gson) {
    return new CashGapDataRepository(context, gson);
  }
}
