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
public final class CalendarScanner_Factory implements Factory<CalendarScanner> {
  private final Provider<ContentResolver> contentResolverProvider;

  public CalendarScanner_Factory(Provider<ContentResolver> contentResolverProvider) {
    this.contentResolverProvider = contentResolverProvider;
  }

  @Override
  public CalendarScanner get() {
    return newInstance(contentResolverProvider.get());
  }

  public static CalendarScanner_Factory create(Provider<ContentResolver> contentResolverProvider) {
    return new CalendarScanner_Factory(contentResolverProvider);
  }

  public static CalendarScanner newInstance(ContentResolver contentResolver) {
    return new CalendarScanner(contentResolver);
  }
}
