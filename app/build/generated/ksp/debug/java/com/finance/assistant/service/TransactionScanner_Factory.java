package com.finance.assistant.service;

import android.content.ContentResolver;
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
public final class TransactionScanner_Factory implements Factory<TransactionScanner> {
  private final Provider<ContentResolver> contentResolverProvider;

  public TransactionScanner_Factory(Provider<ContentResolver> contentResolverProvider) {
    this.contentResolverProvider = contentResolverProvider;
  }

  @Override
  public TransactionScanner get() {
    return newInstance(contentResolverProvider.get());
  }

  public static TransactionScanner_Factory create(
      Provider<ContentResolver> contentResolverProvider) {
    return new TransactionScanner_Factory(contentResolverProvider);
  }

  public static TransactionScanner newInstance(ContentResolver contentResolver) {
    return new TransactionScanner(contentResolver);
  }
}
