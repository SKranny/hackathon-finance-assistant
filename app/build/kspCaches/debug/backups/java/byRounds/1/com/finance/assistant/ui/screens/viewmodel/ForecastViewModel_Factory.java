package com.finance.assistant.ui.screens.viewmodel;

import com.finance.assistant.data.repository.ForecastDataRepository;
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
public final class ForecastViewModel_Factory implements Factory<ForecastViewModel> {
  private final Provider<ForecastDataRepository> repositoryProvider;

  public ForecastViewModel_Factory(Provider<ForecastDataRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public ForecastViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static ForecastViewModel_Factory create(
      Provider<ForecastDataRepository> repositoryProvider) {
    return new ForecastViewModel_Factory(repositoryProvider);
  }

  public static ForecastViewModel newInstance(ForecastDataRepository repository) {
    return new ForecastViewModel(repository);
  }
}
