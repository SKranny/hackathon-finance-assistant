package com.finance.assistant.ui.screens.viewmodel;

import com.finance.assistant.data.repository.FeedDataRepository;
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
public final class FeedViewModel_Factory implements Factory<FeedViewModel> {
  private final Provider<FeedDataRepository> feedDataRepositoryProvider;

  public FeedViewModel_Factory(Provider<FeedDataRepository> feedDataRepositoryProvider) {
    this.feedDataRepositoryProvider = feedDataRepositoryProvider;
  }

  @Override
  public FeedViewModel get() {
    return newInstance(feedDataRepositoryProvider.get());
  }

  public static FeedViewModel_Factory create(
      Provider<FeedDataRepository> feedDataRepositoryProvider) {
    return new FeedViewModel_Factory(feedDataRepositoryProvider);
  }

  public static FeedViewModel newInstance(FeedDataRepository feedDataRepository) {
    return new FeedViewModel(feedDataRepository);
  }
}
