package com.finance.assistant.di;

import android.content.ContentResolver;
import android.content.Context;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
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
public final class ServiceModule_ProvideContentResolverFactory implements Factory<ContentResolver> {
  private final Provider<Context> contextProvider;

  public ServiceModule_ProvideContentResolverFactory(Provider<Context> contextProvider) {
    this.contextProvider = contextProvider;
  }

  @Override
  public ContentResolver get() {
    return provideContentResolver(contextProvider.get());
  }

  public static ServiceModule_ProvideContentResolverFactory create(
      Provider<Context> contextProvider) {
    return new ServiceModule_ProvideContentResolverFactory(contextProvider);
  }

  public static ContentResolver provideContentResolver(Context context) {
    return Preconditions.checkNotNullFromProvides(ServiceModule.INSTANCE.provideContentResolver(context));
  }
}
