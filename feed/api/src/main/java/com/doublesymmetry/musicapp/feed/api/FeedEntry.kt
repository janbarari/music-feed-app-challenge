package com.doublesymmetry.musicapp.feed.api

import com.doublesymmetry.musicapp.navigation.ComposableFeatureEntry

abstract class FeedEntry: ComposableFeatureEntry {

    final override val featureRoute: String
        get() = "feed"

}
