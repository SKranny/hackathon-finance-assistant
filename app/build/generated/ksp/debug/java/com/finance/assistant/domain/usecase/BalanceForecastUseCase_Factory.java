package com.finance.assistant.domain.usecase;

import com.finance.assistant.data.repository.ExpenseRepository;
import com.finance.assistant.data.repository.UserRepository;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
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
public final class BalanceForecastUseCase_Factory implements Factory<BalanceForecastUseCase> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<ExpenseRepository> expenseRepositoryProvider;

  public BalanceForecastUseCase_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.expenseRepositoryProvider = expenseRepositoryProvider;
  }

  @Override
  public BalanceForecastUseCase get() {
    return newInstance(userRepositoryProvider.get(), expenseRepositoryProvider.get());
  }

  public static BalanceForecastUseCase_Factory create(
      Provider<UserRepository> userRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider) {
    return new BalanceForecastUseCase_Factory(userRepositoryProvider, expenseRepositoryProvider);
  }

  public static BalanceForecastUseCase newInstance(UserRepository userRepository,
      ExpenseRepository expenseRepository) {
    return new BalanceForecastUseCase(userRepository, expenseRepository);
  }
}
