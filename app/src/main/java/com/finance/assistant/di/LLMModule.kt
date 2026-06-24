package com.finance.assistant.di

import com.finance.assistant.data.remote.OllamaApiService
import com.finance.assistant.data.remote.OllamaApiServiceImpl
import com.finance.assistant.data.repository.LLMRepository
import com.finance.assistant.data.repository.OllamaLLMRepository
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import dagger.Binds
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import java.util.concurrent.TimeUnit
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object LLMModule {

    private const val DEFAULT_BASE_URL = "http://127.0.0.1:11434"
    private const val DEFAULT_MODEL = "gemma4:e2b"

    @Provides
    @Singleton
    fun provideLoggingInterceptor(): HttpLoggingInterceptor {
        return HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
    }

    @Provides
    @Singleton
    fun provideOkHttpClient(
        loggingInterceptor: HttpLoggingInterceptor,
    ): OkHttpClient {
        return OkHttpClient.Builder()
            .addInterceptor(loggingInterceptor)
            .connectTimeout(120, TimeUnit.SECONDS)
            .readTimeout(0, TimeUnit.SECONDS) // Без таймаута для LLM
            .writeTimeout(120, TimeUnit.SECONDS)
            .retryOnConnectionFailure(true)
            .build()
    }

    @Provides
    @Singleton
    fun provideGson(): Gson {
        return GsonBuilder()
            .setLenient()
            .create()
    }

    @Provides
    @Named("ollama_base_url")
    fun provideOllamaBaseUrl(): String {
        return DEFAULT_BASE_URL
    }

    @Provides
    @Named("ollama_model")
    fun provideOllamaModelName(): String {
        return DEFAULT_MODEL
    }

    @Provides
    @Singleton
    fun provideOllamaApiService(
        okHttpClient: OkHttpClient,
        @Named("ollama_base_url") baseUrl: String,
        gson: Gson,
    ): OllamaApiService {
        return OllamaApiServiceImpl(okHttpClient, baseUrl, gson)
    }

    @Provides
    @Singleton
    fun provideLLMRepository(
        apiService: OllamaApiService,
        gson: Gson,
        @Named("ollama_model") modelName: String,
    ): LLMRepository {
        return OllamaLLMRepository(apiService, gson, modelName)
    }
}
