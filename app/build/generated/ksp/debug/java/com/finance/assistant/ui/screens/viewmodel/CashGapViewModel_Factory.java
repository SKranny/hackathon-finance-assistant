package com.finance.assistant.ui.screens.viewmodel;

import com.finance.assistant.data.repository.CashGapDataRepository;
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
public final class CashGapViewModel_Factory implements Factory<CashGapViewModel> {
  private final Provider<CashGapDataRepository> repositoryProvider;

  public CashGapViewModel_Factory(Provider<CashGapDataRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public CashGapViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static CashGapViewModel_Factory create(
      Provider<CashGapDataRepository> repositoryProvider) {
    return new CashGapViewModel_Factory(repositoryProvider);
  }

  public static CashGapViewModel newInstance(CashGapDataRepository repository) {
    return new CashGapViewModel(repository);
  }
}
