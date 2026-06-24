package com.finance.assistant.di;

import com.finance.assistant.data.objectbox.entity.UpcomingExpenseEntity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.objectbox.Box;
import io.objectbox.BoxStore;
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
public final class ObjectBoxModule_ProvideUpcomingExpenseBoxFactory implements Factory<Box<UpcomingExpenseEntity>> {
  private final Provider<BoxStore> boxStoreProvider;

  public ObjectBoxModule_ProvideUpcomingExpenseBoxFactory(Provider<BoxStore> boxStoreProvider) {
    this.boxStoreProvider = boxStoreProvider;
  }

  @Override
  public Box<UpcomingExpenseEntity> get() {
    return provideUpcomingExpenseBox(boxStoreProvider.get());
  }

  public static ObjectBoxModule_ProvideUpcomingExpenseBoxFactory create(
      Provider<BoxStore> boxStoreProvider) {
    return new ObjectBoxModule_ProvideUpcomingExpenseBoxFactory(boxStoreProvider);
  }

  public static Box<UpcomingExpenseEntity> provideUpcomingExpenseBox(BoxStore boxStore) {
    return Preconditions.checkNotNullFromProvides(ObjectBoxModule.INSTANCE.provideUpcomingExpenseBox(boxStore));
  }
}
