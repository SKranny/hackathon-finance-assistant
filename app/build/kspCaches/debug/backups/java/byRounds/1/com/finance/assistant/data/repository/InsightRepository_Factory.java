package com.finance.assistant.data.repository;

import com.finance.assistant.data.local.dao.FinancialInsightDao;
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
public final class InsightRepository_Factory implements Factory<InsightRepository> {
  private final Provider<FinancialInsightDao> insightDaoProvider;

  public InsightRepository_Factory(Provider<FinancialInsightDao> insightDaoProvider) {
    this.insightDaoProvider = insightDaoProvider;
  }

  @Override
  public InsightRepository get() {
    return newInstance(insightDaoProvider.get());
  }

  public static InsightRepository_Factory create(Provider<FinancialInsightDao> insightDaoProvider) {
    return new InsightRepository_Factory(insightDaoProvider);
  }

  public static InsightRepository newInstance(FinancialInsightDao insightDao) {
    return new InsightRepository(insightDao);
  }
}
