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
public final class HomeDataRepository_Factory implements Factory<HomeDataRepository> {
  private final Provider<Context> contextProvider;

  private final Provider<Gson> gsonProvider;

  public HomeDataRepository_Factory(Provider<Context> contextProvider,
      Provider<Gson> gsonProvider) {
    this.contextProvider = contextProvider;
    this.gsonProvider = gsonProvider;
  }

  @Override
  public HomeDataRepository get() {
    return newInstance(contextProvider.get(), gsonProvider.get());
  }

  public static HomeDataRepository_Factory create(Provider<Context> contextProvider,
      Provider<Gson> gsonProvider) {
    return new HomeDataRepository_Factory(contextProvider, gsonProvider);
  }

  public static HomeDataRepository newInstance(Context context, Gson gson) {
    return new HomeDataRepository(context, gson);
  }
}
