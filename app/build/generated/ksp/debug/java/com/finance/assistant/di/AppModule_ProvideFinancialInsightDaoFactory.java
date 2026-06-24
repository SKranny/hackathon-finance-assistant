package com.finance.assistant.di;

import com.finance.assistant.data.local.FinanceDatabase;
import com.finance.assistant.data.local.dao.FinancialInsightDao;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata
@QualifierMetadata
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
public final class AppModule_ProvideFinancialInsightDaoFactory implements Factory<FinancialInsightDao> {
  private final Provider<FinanceDatabase> dbProvider;

  public AppModule_ProvideFinancialInsightDaoFactory(Provider<FinanceDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public FinancialInsightDao get() {
    return provideFinancialInsightDao(dbProvider.get());
  }

  public static AppModule_ProvideFinancialInsightDaoFactory create(
      Provider<FinanceDatabase> dbProvider) {
    return new AppModule_ProvideFinancialInsightDaoFactory(dbProvider);
  }

  public static FinancialInsightDao provideFinancialInsightDao(FinanceDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideFinancialInsightDao(db));
  }
}
