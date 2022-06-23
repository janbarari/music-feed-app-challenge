package com.doublesymmetry.musicapp.feed.impl.di

import com.doublesymmetry.musicapp.feed.api.FeedEntry
import com.doublesymmetry.musicapp.feed.impl.navigation.FeedEntryImpl
import com.doublesymmetry.musicapp.navigation.FeatureEntry
import com.doublesymmetry.musicapp.navigation.FeatureEntryKey
import dagger.Binds
import dagger.Module
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import dagger.multibindings.IntoMap
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
abstract class FeedEntryModule {

    @Binds
    @IntoMap
    @FeatureEntryKey(FeedEntry::class)
    @Singleton
    abstract fun bindFeedEntry(impl: FeedEntryImpl): FeatureEntry

}
