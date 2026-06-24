package com.finance.assistant.data.privacy;

import android.content.Context;
import com.finance.assistant.data.objectbox.ObjectBoxManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.objectbox.BoxStore;
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
public final class DataDeletionService_Factory implements Factory<DataDeletionService> {
  private final Provider<Context> contextProvider;

  private final Provider<BoxStore> boxStoreProvider;

  private final Provider<ObjectBoxManager> objectBoxManagerProvider;

  public DataDeletionService_Factory(Provider<Context> contextProvider,
      Provider<BoxStore> boxStoreProvider, Provider<ObjectBoxManager> objectBoxManagerProvider) {
    this.contextProvider = contextProvider;
    this.boxStoreProvider = boxStoreProvider;
    this.objectBoxManagerProvider = objectBoxManagerProvider;
  }

  @Override
  public DataDeletionService get() {
    return newInstance(contextProvider.get(), boxStoreProvider.get(), objectBoxManagerProvider.get());
  }

  public static DataDeletionService_Factory create(Provider<Context> contextProvider,
      Provider<BoxStore> boxStoreProvider, Provider<ObjectBoxManager> objectBoxManagerProvider) {
    return new DataDeletionService_Factory(contextProvider, boxStoreProvider, objectBoxManagerProvider);
  }

  public static DataDeletionService newInstance(Context context, BoxStore boxStore,
      ObjectBoxManager objectBoxManager) {
    return new DataDeletionService(context, boxStore, objectBoxManager);
  }
}
