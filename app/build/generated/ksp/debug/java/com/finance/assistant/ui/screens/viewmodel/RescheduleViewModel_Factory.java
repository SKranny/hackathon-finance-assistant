package com.finance.assistant.ui.screens.viewmodel;

import com.finance.assistant.data.repository.RescheduleDataRepository;
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
public final class RescheduleViewModel_Factory implements Factory<RescheduleViewModel> {
  private final Provider<RescheduleDataRepository> repositoryProvider;

  public RescheduleViewModel_Factory(Provider<RescheduleDataRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public RescheduleViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static RescheduleViewModel_Factory create(
      Provider<RescheduleDataRepository> repositoryProvider) {
    return new RescheduleViewModel_Factory(repositoryProvider);
  }

  public static RescheduleViewModel newInstance(RescheduleDataRepository repository) {
    return new RescheduleViewModel(repository);
  }
}
