package com.finance.assistant.ui.screens.viewmodel;

import com.finance.assistant.data.repository.PaymentConfirmationDataRepository;
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
public final class PaymentConfirmationViewModel_Factory implements Factory<PaymentConfirmationViewModel> {
  private final Provider<PaymentConfirmationDataRepository> repositoryProvider;

  public PaymentConfirmationViewModel_Factory(
      Provider<PaymentConfirmationDataRepository> repositoryProvider) {
    this.repositoryProvider = repositoryProvider;
  }

  @Override
  public PaymentConfirmationViewModel get() {
    return newInstance(repositoryProvider.get());
  }

  public static PaymentConfirmationViewModel_Factory create(
      Provider<PaymentConfirmationDataRepository> repositoryProvider) {
    return new PaymentConfirmationViewModel_Factory(repositoryProvider);
  }

  public static PaymentConfirmationViewModel newInstance(
      PaymentConfirmationDataRepository repository) {
    return new PaymentConfirmationViewModel(repository);
  }
}
