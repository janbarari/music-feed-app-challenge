package com.doublesymmetry.musicapp.feed.impl.di

import com.doublesymmetry.musicapp.feed.impl.data.FeedRepositoryImpl
import com.doublesymmetry.musicapp.feed.impl.domain.FeedRepository
import com.doublesymmetry.musicapp.feed.impl.service.FeedApiService
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import retrofit2.Retrofit

@Module
@InstallIn(SingletonComponent::class)
object DataFlowModule {

    @Provides
    fun provideFeedApiService(
        retrofit: Retrofit
    ): FeedApiService {
        return retrofit.create(FeedApiService::class.java)
    }

    @Provides
    fun provideFeedRepository(
        api: FeedApiService
    ): FeedRepository {
        return FeedRepositoryImpl(api)
    }

}