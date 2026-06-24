package com.finance.assistant.di;

import com.finance.assistant.data.objectbox.ObjectBoxManager;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.Preconditions;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
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
public final class ObjectBoxModule_ProvideBoxStoreFactory implements Factory<BoxStore> {
  private final Provider<ObjectBoxManager> managerProvider;

  public ObjectBoxModule_ProvideBoxStoreFactory(Provider<ObjectBoxManager> managerProvider) {
    this.managerProvider = managerProvider;
  }

  @Override
  public BoxStore get() {
    return provideBoxStore(managerProvider.get());
  }

  public static ObjectBoxModule_ProvideBoxStoreFactory create(
      Provider<ObjectBoxManager> managerProvider) {
    return new ObjectBoxModule_ProvideBoxStoreFactory(managerProvider);
  }

  public static BoxStore provideBoxStore(ObjectBoxManager manager) {
    return Preconditions.checkNotNullFromProvides(ObjectBoxModule.INSTANCE.provideBoxStore(manager));
  }
}
