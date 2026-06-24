package com.finance.assistant.di;

@dagger.Module()
@kotlin.Metadata(mv = {1, 9, 0}, k = 1, xi = 48, d1 = {"\u00006\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0018\u0002\n\u0000\n\u0002\u0018\u0002\n\u0002\b\u0007\b\u00c7\u0002\u0018\u00002\u00020\u0001B\u0007\b\u0002\u00a2\u0006\u0002\u0010\u0002J\b\u0010\u0006\u001a\u00020\u0007H\u0007J\"\u0010\b\u001a\u00020\t2\u0006\u0010\n\u001a\u00020\u000b2\u0006\u0010\f\u001a\u00020\u00072\b\b\u0001\u0010\r\u001a\u00020\u0004H\u0007J\b\u0010\u000e\u001a\u00020\u000fH\u0007J\u0010\u0010\u0010\u001a\u00020\u00112\u0006\u0010\u0012\u001a\u00020\u000fH\u0007J\"\u0010\u0013\u001a\u00020\u000b2\u0006\u0010\u0014\u001a\u00020\u00112\b\b\u0001\u0010\u0015\u001a\u00020\u00042\u0006\u0010\f\u001a\u00020\u0007H\u0007J\b\u0010\u0016\u001a\u00020\u0004H\u0007J\b\u0010\u0017\u001a\u00020\u0004H\u0007R\u000e\u0010\u0003\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000R\u000e\u0010\u0005\u001a\u00020\u0004X\u0082T\u00a2\u0006\u0002\n\u0000\u00a8\u0006\u0018"}, d2 = {"Lcom/finance/assistant/di/LLMModule;", "", "()V", "DEFAULT_BASE_URL", "", "DEFAULT_MODEL", "provideGson", "Lcom/google/gson/Gson;", "provideLLMRepository", "Lcom/finance/assistant/data/repository/LLMRepository;", "apiService", "Lcom/finance/assistant/data/remote/OllamaApiService;", "gson", "modelName", "provideLoggingInterceptor", "Lokhttp3/logging/HttpLoggingInterceptor;", "provideOkHttpClient", "Lokhttp3/OkHttpClient;", "loggingInterceptor", "provideOllamaApiService", "okHttpClient", "baseUrl", "provideOllamaBaseUrl", "provideOllamaModelName", "app_debug"})
@dagger.hilt.InstallIn(value = {dagger.hilt.components.SingletonComponent.class})
public final class LLMModule {
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_BASE_URL = "http://10.0.2.2:11434";
    @org.jetbrains.annotations.NotNull()
    private static final java.lang.String DEFAULT_MODEL = "gemma4:e2b";
    @org.jetbrains.annotations.NotNull()
    public static final com.finance.assistant.di.LLMModule INSTANCE = null;
    
    private LLMModule() {
        super();
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.logging.HttpLoggingInterceptor provideLoggingInterceptor() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final okhttp3.OkHttpClient provideOkHttpClient(@org.jetbrains.annotations.NotNull()
    okhttp3.logging.HttpLoggingInterceptor loggingInterceptor) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.google.gson.Gson provideGson() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Named(value = "ollama_base_url")
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String provideOllamaBaseUrl() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Named(value = "ollama_model")
    @org.jetbrains.annotations.NotNull()
    public final java.lang.String provideOllamaModelName() {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.data.remote.OllamaApiService provideOllamaApiService(@org.jetbrains.annotations.NotNull()
    okhttp3.OkHttpClient okHttpClient, @javax.inject.Named(value = "ollama_base_url")
    @org.jetbrains.annotations.NotNull()
    java.lang.String baseUrl, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson) {
        return null;
    }
    
    @dagger.Provides()
    @javax.inject.Singleton()
    @org.jetbrains.annotations.NotNull()
    public final com.finance.assistant.data.repository.LLMRepository provideLLMRepository(@org.jetbrains.annotations.NotNull()
    com.finance.assistant.data.remote.OllamaApiService apiService, @org.jetbrains.annotations.NotNull()
    com.google.gson.Gson gson, @javax.inject.Named(value = "ollama_model")
    @org.jetbrains.annotations.NotNull()
    java.lang.String modelName) {
        return null;
    }
}