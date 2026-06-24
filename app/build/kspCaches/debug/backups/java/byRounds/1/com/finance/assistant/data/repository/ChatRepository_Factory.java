package com.finance.assistant.data.repository;

import com.finance.assistant.data.objectbox.entity.session.ChatMessageEntity;
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
public final class ChatRepository_Factory implements Factory<ChatRepository> {
  private final Provider<Box<ChatMessageEntity>> chatMessageBoxProvider;

  public ChatRepository_Factory(Provider<Box<ChatMessageEntity>> chatMessageBoxProvider) {
    this.chatMessageBoxProvider = chatMessageBoxProvider;
  }

  @Override
  public ChatRepository get() {
    return newInstance(chatMessageBoxProvider.get());
  }

  public static ChatRepository_Factory create(
      Provider<Box<ChatMessageEntity>> chatMessageBoxProvider) {
    return new ChatRepository_Factory(chatMessageBoxProvider);
  }

  public static ChatRepository newInstance(Box<ChatMessageEntity> chatMessageBox) {
    return new ChatRepository(chatMessageBox);
  }
}
