package com.finance.assistant.domain.usecase;

import com.finance.assistant.ai.AIModelManager;
import com.finance.assistant.data.repository.InsightRepository;
import com.finance.assistant.data.repository.TransactionRepository;
import com.finance.assistant.service.CalendarScanner;
import com.finance.assistant.service.TransactionScanner;
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
public final class AnalyzeFinanceUseCase_Factory implements Factory<AnalyzeFinanceUseCase> {
  private final Provider<AIModelManager> aiModelManagerProvider;

  private final Provider<TransactionRepository> transactionRepositoryProvider;

  private final Provider<InsightRepository> insightRepositoryProvider;

  private final Provider<CalendarScanner> calendarScannerProvider;

  private final Provider<TransactionScanner> transactionScannerProvider;

  public AnalyzeFinanceUseCase_Factory(Provider<AIModelManager> aiModelManagerProvider,
      Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<InsightRepository> insightRepositoryProvider,
      Provider<CalendarScanner> calendarScannerProvider,
      Provider<TransactionScanner> transactionScannerProvider) {
    this.aiModelManagerProvider = aiModelManagerProvider;
    this.transactionRepositoryProvider = transactionRepositoryProvider;
    this.insightRepositoryProvider = insightRepositoryProvider;
    this.calendarScannerProvider = calendarScannerProvider;
    this.transactionScannerProvider = transactionScannerProvider;
  }

  @Override
  public AnalyzeFinanceUseCase get() {
    return newInstance(aiModelManagerProvider.get(), transactionRepositoryProvider.get(), insightRepositoryProvider.get(), calendarScannerProvider.get(), transactionScannerProvider.get());
  }

  public static AnalyzeFinanceUseCase_Factory create(
      Provider<AIModelManager> aiModelManagerProvider,
      Provider<TransactionRepository> transactionRepositoryProvider,
      Provider<InsightRepository> insightRepositoryProvider,
      Provider<CalendarScanner> calendarScannerProvider,
      Provider<TransactionScanner> transactionScannerProvider) {
    return new AnalyzeFinanceUseCase_Factory(aiModelManagerProvider, transactionRepositoryProvider, insightRepositoryProvider, calendarScannerProvider, transactionScannerProvider);
  }

  public static AnalyzeFinanceUseCase newInstance(AIModelManager aiModelManager,
      TransactionRepository transactionRepository, InsightRepository insightRepository,
      CalendarScanner calendarScanner, TransactionScanner transactionScanner) {
    return new AnalyzeFinanceUseCase(aiModelManager, transactionRepository, insightRepository, calendarScanner, transactionScanner);
  }
}
