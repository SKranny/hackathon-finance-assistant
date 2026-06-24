package com.finance.assistant.data.repository;

import com.finance.assistant.data.objectbox.entity.UserProfileEntity;
import dagger.internal.DaggerGenerated;
import dagger.internal.Factory;
import dagger.internal.QualifierMetadata;
import dagger.internal.ScopeMetadata;
import io.objectbox.Box;
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
public final class UserRepository_Factory implements Factory<UserRepository> {
  private final Provider<Box<UserProfileEntity>> userBoxProvider;

  public UserRepository_Factory(Provider<Box<UserProfileEntity>> userBoxProvider) {
    this.userBoxProvider = userBoxProvider;
  }

  @Override
  public UserRepository get() {
    return newInstance(userBoxProvider.get());
  }

  public static UserRepository_Factory create(Provider<Box<UserProfileEntity>> userBoxProvider) {
    return new UserRepository_Factory(userBoxProvider);
  }

  public static UserRepository newInstance(Box<UserProfileEntity> userBox) {
    return new UserRepository(userBox);
  }
}
