package com.lewis.bnztest.di

import com.google.gson.GsonBuilder
import com.lewis.bnztest.data.DataStoreService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import okhttp3.OkHttpClient
import okhttp3.logging.HttpLoggingInterceptor
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import javax.inject.Singleton


@Module
@InstallIn(SingletonComponent::class)
object RetrofitModule {
    private const val BASE_URL = "https://catalogue.data.govt.nz/"

    @Singleton
    @Provides
    fun provideRetrofit(): Retrofit {
        val interceptor = HttpLoggingInterceptor().apply {
            level = HttpLoggingInterceptor.Level.BODY
        }
        val client = OkHttpClient.Builder().addInterceptor(interceptor).build()
        return Retrofit.Builder()
            .addConverterFactory(
                GsonConverterFactory.create(
                    GsonBuilder()
                        .setLenient()
                        .serializeNulls()
                        .create()
                )
            )
            .baseUrl(BASE_URL)
            .client(client)
            .build()
    }

    @Singleton
    @Provides
    fun provideDataStoreService(retrofit: Retrofit): DataStoreService =
        retrofit.create(DataStoreService::class.java)
}