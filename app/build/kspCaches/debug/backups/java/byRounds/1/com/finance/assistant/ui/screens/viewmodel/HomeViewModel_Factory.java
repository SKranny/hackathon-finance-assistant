package com.finance.assistant.ui.screens.viewmodel;

import com.finance.assistant.data.repository.HomeDataRepository;
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
  private final Provider<HomeDataRepository> homeDataRepositoryProvider;

  public HomeViewModel_Factory(Provider<HomeDataRepository> homeDataRepositoryProvider) {
    this.homeDataRepositoryProvider = homeDataRepositoryProvider;
  }

  @Override
  public HomeViewModel get() {
    return newInstance(homeDataRepositoryProvider.get());
  }

  public static HomeViewModel_Factory create(
      Provider<HomeDataRepository> homeDataRepositoryProvider) {
    return new HomeViewModel_Factory(homeDataRepositoryProvider);
  }

  public static HomeViewModel newInstance(HomeDataRepository homeDataRepository) {
    return new HomeViewModel(homeDataRepository);
  }
}
