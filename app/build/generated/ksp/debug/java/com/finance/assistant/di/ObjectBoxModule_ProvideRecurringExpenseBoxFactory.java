package com.finance.assistant.di;

import com.finance.assistant.data.objectbox.entity.RecurringExpenseEntity;
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
public final class ObjectBoxModule_ProvideRecurringExpenseBoxFactory implements Factory<Box<RecurringExpenseEntity>> {
  private final Provider<BoxStore> boxStoreProvider;

  public ObjectBoxModule_ProvideRecurringExpenseBoxFactory(Provider<BoxStore> boxStoreProvider) {
    this.boxStoreProvider = boxStoreProvider;
  }

  @Override
  public Box<RecurringExpenseEntity> get() {
    return provideRecurringExpenseBox(boxStoreProvider.get());
  }

  public static ObjectBoxModule_ProvideRecurringExpenseBoxFactory create(
      Provider<BoxStore> boxStoreProvider) {
    return new ObjectBoxModule_ProvideRecurringExpenseBoxFactory(boxStoreProvider);
  }

  public static Box<RecurringExpenseEntity> provideRecurringExpenseBox(BoxStore boxStore) {
    return Preconditions.checkNotNullFromProvides(ObjectBoxModule.INSTANCE.provideRecurringExpenseBox(boxStore));
  }
}
