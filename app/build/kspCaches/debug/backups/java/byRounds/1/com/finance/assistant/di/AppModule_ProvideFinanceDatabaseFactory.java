package com.finance.assistant.di;

import android.content.Context;
import com.finance.assistant.data.local.FinanceDatabase;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class AppModule_ProvideFinanceDatabaseFactory implements Factory<FinanceDatabase> {
  private final Provider<Context> contextProvider;

  public AppModule_ProvideFinanceDatabaseFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public FinanceDatabase get() {
    return provideFinanceDatabase(contextProvider.get());
  }

  public static AppModule_ProvideFinanceDatabaseFactory create(Provider<Context> contextProvider) {
    return new AppModule_ProvideFinanceDatabaseFactory(contextProvider);
  }

  public static FinanceDatabase provideFinanceDatabase(Context context) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideFinanceDatabase(context));
  }
}
