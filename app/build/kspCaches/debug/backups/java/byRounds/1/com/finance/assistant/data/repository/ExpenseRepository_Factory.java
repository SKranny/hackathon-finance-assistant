package com.finance.assistant.data.repository;

import com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity;
import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity;
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
public final class ExpenseRepository_Factory implements Factory<ExpenseRepository> {
  private final Provider<Box<UpcomingExpenseEntity>> upcomingExpenseBoxProvider;

  private final Provider<Box<RecurringExpenseEntity>> recurringExpenseBoxProvider;

  public ExpenseRepository_Factory(Provider<Box<UpcomingExpenseEntity>> upcomingExpenseBoxProvider,
      Provider<Box<RecurringExpenseEntity>> recurringExpenseBoxProvider) {
    this.upcomingExpenseBoxProvider = upcomingExpenseBoxProvider;
    this.recurringExpenseBoxProvider = recurringExpenseBoxProvider;
  }

  @Override
  public ExpenseRepository get() {
    return newInstance(upcomingExpenseBoxProvider.get(), recurringExpenseBoxProvider.get());
  }

  public static ExpenseRepository_Factory create(
      Provider<Box<UpcomingExpenseEntity>> upcomingExpenseBoxProvider,
      Provider<Box<RecurringExpenseEntity>> recurringExpenseBoxProvider) {
    return new ExpenseRepository_Factory(upcomingExpenseBoxProvider, recurringExpenseBoxProvider);
  }

  public static ExpenseRepository newInstance(Box<UpcomingExpenseEntity> upcomingExpenseBox,
      Box<RecurringExpenseEntity> recurringExpenseBox) {
    return new ExpenseRepository(upcomingExpenseBox, recurringExpenseBox);
  }
}
