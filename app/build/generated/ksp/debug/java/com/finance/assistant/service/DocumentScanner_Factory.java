package com.finance.assistant.service;

import android.content.ContentResolver;
import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import javax.annotation.processing.Generated;
import javax.inject.Provider;

@ScopeMetadata("javax.inject.Singleton")
@QualifierMetadata("dagger.hilt.android.qualifiers.ApplicationContext")
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
public final class DocumentScanner_Factory implements Factory<DocumentScanner> {
  private final Provider<Context> contextProvider;

  private final Provider<ContentResolver> contentResolverProvider;

  public DocumentScanner_Factory(Provider<Context> contextProvider,
      Provider<ContentResolver> contentResolverProvider) {
    this.contextProvider = contextProvider;
    this.contentResolverProvider = contentResolverProvider;
  }

  @Override
  public DocumentScanner get() {
    return newInstance(contextProvider.get(), contentResolverProvider.get());
  }

  public static DocumentScanner_Factory create(Provider<Context> contextProvider,
      Provider<ContentResolver> contentResolverProvider) {
    return new DocumentScanner_Factory(contextProvider, contentResolverProvider);
  }

  public static DocumentScanner newInstance(Context context, ContentResolver contentResolver) {
    return new DocumentScanner(context, contentResolver);
  }
}
