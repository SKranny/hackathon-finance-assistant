package com.finance.assistant.data.repository;

import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity;
import com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.objectbox.Box;
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
public final class CaseRepository_Factory implements Factory<CaseRepository> {
  private final Provider<Box<FinanceCaseEntity>> caseBoxProvider;

  private final Provider<Box<UpcomingExpenseEntity>> upcomingExpenseBoxProvider;

  public CaseRepository_Factory(Provider<Box<FinanceCaseEntity>> caseBoxProvider,
      Provider<Box<UpcomingExpenseEntity>> upcomingExpenseBoxProvider) {
    this.caseBoxProvider = caseBoxProvider;
    this.upcomingExpenseBoxProvider = upcomingExpenseBoxProvider;
  }

  @Override
  public CaseRepository get() {
    return newInstance(caseBoxProvider.get(), upcomingExpenseBoxProvider.get());
  }

  public static CaseRepository_Factory create(Provider<Box<FinanceCaseEntity>> caseBoxProvider,
      Provider<Box<UpcomingExpenseEntity>> upcomingExpenseBoxProvider) {
    return new CaseRepository_Factory(caseBoxProvider, upcomingExpenseBoxProvider);
  }

  public static CaseRepository newInstance(Box<FinanceCaseEntity> caseBox,
      Box<UpcomingExpenseEntity> upcomingExpenseBox) {
    return new CaseRepository(caseBox, upcomingExpenseBox);
  }
}
