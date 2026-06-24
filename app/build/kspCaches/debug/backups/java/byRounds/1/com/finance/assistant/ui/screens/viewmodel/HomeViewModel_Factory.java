package com.finance.assistant.ui.screens.viewmodel;

import com.finance.assistant.data.repository.ExpenseRepository;
import com.finance.assistant.data.repository.InsightRepository;
import com.finance.assistant.data.repository.TransactionRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
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
public final class HomeViewModel_Factory implements Factory<HomeViewModel> {
  private final Provider<TransactionRepository> transactionRepositoryProvider;

  private final Provider<InsightRepository> insightRepositoryProvider;

  private final Provider<ExpenseRepository> expenseRepositoryProvider;

  public HomeViewModel_Factory(Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<InsightRepository> insightRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider) {
    this.transactionRepositoryProvider = transactionRepositoryProvider;
    this.insightRepositoryProvider = insightRepositoryProvider;
    this.expenseRepositoryProvider = expenseRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(transactionRepositoryProvider.get(), insightRepositoryProvider.get(), expenseRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<InsightRepository> insightRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider) {
    return new HomeViewModel_Factory(transactionRepositoryProvider, insightRepositoryProvider, expenseRepositoryProvider);
  }

  public static HomeViewModel newInstance(TransactionRepository transactionRepository,
      InsightRepository insightRepository, ExpenseRepository expenseRepository) {
    return new HomeViewModel(transactionRepository, insightRepository, expenseRepository);
  }
}
