package com.finance.assistant.di;

import com.finance.assistant.data.objectbox.entity.session.FinanceCaseEntity;
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
public final class ObjectBoxModule_ProvideFinanceCaseBoxFactory implements Factory<Box<FinanceCaseEntity>> {
  private final Provider<BoxStore> boxStoreProvider;

  public ObjectBoxModule_ProvideFinanceCaseBoxFactory(Provider<BoxStore> boxStoreProvider) {
    this.boxStoreProvider = boxStoreProvider;
  }

  @Override
  public Box<FinanceCaseEntity> get() {
    return provideFinanceCaseBox(boxStoreProvider.get());
  }

  public static ObjectBoxModule_ProvideFinanceCaseBoxFactory create(
      Provider<BoxStore> boxStoreProvider) {
    return new ObjectBoxModule_ProvideFinanceCaseBoxFactory(boxStoreProvider);
  }

  public static Box<FinanceCaseEntity> provideFinanceCaseBox(BoxStore boxStore) {
    return Preconditions.checkNotNullFromProvides(ObjectBoxModule.INSTANCE.provideFinanceCaseBox(boxStore));
  }
}
