package com.finance.assistant.di;

import com.finance.assistant.data.local.FinanceDatabase;
import com.finance.assistant.data.local.dao.TransactionDao;
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
public final class AppModule_ProvideTransactionDaoFactory implements Factory<TransactionDao> {
  private final Provider<FinanceDatabase> dbProvider;

  public AppModule_ProvideTransactionDaoFactory(Provider<FinanceDatabase> dbProvider) {
    this.dbProvider = dbProvider;
  }

  @Override
  public TransactionDao get() {
    return provideTransactionDao(dbProvider.get());
  }

  public static AppModule_ProvideTransactionDaoFactory create(
      Provider<FinanceDatabase> dbProvider) {
    return new AppModule_ProvideTransactionDaoFactory(dbProvider);
  }

  public static TransactionDao provideTransactionDao(FinanceDatabase db) {
    return Preconditions.checkNotNullFromProvides(AppModule.INSTANCE.provideTransactionDao(db));
  }
}
