package com.finance.assistant.di;

import com.finance.assistant.data.objectbox.entity.UserProfileEntity;
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
public final class ObjectBoxModule_ProvideUserProfileBoxFactory implements Factory<Box<UserProfileEntity>> {
  private final Provider<BoxStore> boxStoreProvider;

  public ObjectBoxModule_ProvideUserProfileBoxFactory(Provider<BoxStore> boxStoreProvider) {
    this.boxStoreProvider = boxStoreProvider;
  }

  @Override
  public Box<UserProfileEntity> get() {
    return provideUserProfileBox(boxStoreProvider.get());
  }

  public static ObjectBoxModule_ProvideUserProfileBoxFactory create(
      Provider<BoxStore> boxStoreProvider) {
    return new ObjectBoxModule_ProvideUserProfileBoxFactory(boxStoreProvider);
  }

  public static Box<UserProfileEntity> provideUserProfileBox(BoxStore boxStore) {
    return Preconditions.checkNotNullFromProvides(ObjectBoxModule.INSTANCE.provideUserProfileBox(boxStore));
  }
}
