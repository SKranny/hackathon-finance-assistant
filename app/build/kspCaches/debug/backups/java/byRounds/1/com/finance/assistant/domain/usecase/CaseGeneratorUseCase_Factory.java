package com.finance.assistant.domain.usecase;

import com.finance.assistant.data.repository.CaseRepository;
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
public final class CaseGeneratorUseCase_Factory implements Factory<CaseGeneratorUseCase> {
  private final Provider<UserRepository> userRepositoryProvider;

  private final Provider<ExpenseRepository> expenseRepositoryProvider;

  private final Provider<CaseRepository> caseRepositoryProvider;

  public CaseGeneratorUseCase_Factory(Provider<UserRepository> userRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<CaseRepository> caseRepositoryProvider) {
    this.userRepositoryProvider = userRepositoryProvider;
    this.expenseRepositoryProvider = expenseRepositoryProvider;
    this.caseRepositoryProvider = caseRepositoryProvider;
  }

  @Override
  public CaseGeneratorUseCase get() {
    return newInstance(userRepositoryProvider.get(), expenseRepositoryProvider.get(), caseRepositoryProvider.get());
  }

  public static CaseGeneratorUseCase_Factory create(Provider<UserRepository> userRepositoryProvider,
      Provider<ExpenseRepository> expenseRepositoryProvider,
      Provider<CaseRepository> caseRepositoryProvider) {
    return new CaseGeneratorUseCase_Factory(userRepositoryProvider, expenseRepositoryProvider, caseRepositoryProvider);
  }

  public static CaseGeneratorUseCase newInstance(UserRepository userRepository,
      ExpenseRepository expenseRepository, CaseRepository caseRepository) {
    return new CaseGeneratorUseCase(userRepository, expenseRepository, caseRepository);
  }
}
