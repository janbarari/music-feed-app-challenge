package com.doublesymmetry.musicapp.network

import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit
import retrofit2.converter.moshi.MoshiConverterFactory
import javax.inject.Named
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {

    private const val BASE_URL = "BASE_URL"

    @Provides
    @Singleton
    @Named(BASE_URL)
    fun provideNetworkBaseUrl(): String {
        return "https://mocky.io/v2/"
    }

    @Provides
    @Singleton
    fun provideRetrofit(
        @Named(BASE_URL) baseUrl: String
    ): Retrofit {
        return Retrofit.Builder()
            .baseUrl(baseUrl)
            .addConverterFactory(MoshiConverterFactory.create())
            .build()
    }

}
