package com.finance.assistant.service;

import android.app.NotificationManager;
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
public final class FinanceNotificationService_Factory implements Factory<FinanceNotificationService> {
  private final Provider<Context> contextProvider;

  private final Provider<NotificationManager> notificationManagerProvider;

  public FinanceNotificationService_Factory(Provider<Context> contextProvider,
      Provider<NotificationManager> notificationManagerProvider) {
    this.contextProvider = contextProvider;
    this.notificationManagerProvider = notificationManagerProvider;
  }

  @Override
  public FinanceNotificationService get() {
    return newInstance(contextProvider.get(), notificationManagerProvider.get());
  }

  public static FinanceNotificationService_Factory create(Provider<Context> contextProvider,
      Provider<NotificationManager> notificationManagerProvider) {
    return new FinanceNotificationService_Factory(contextProvider, notificationManagerProvider);
  }

  public static FinanceNotificationService newInstance(Context context,
      NotificationManager notificationManager) {
    return new FinanceNotificationService(context, notificationManager);
  }
}
