package com.doublesymmetry.musicapp.feed.api

import com.doublesymmetry.musicapp.feed.api.seam.FeedAction
import com.doublesymmetry.musicapp.feed.api.seam.FeedEffect
import com.doublesymmetry.musicapp.feed.api.seam.FeedMutation
import com.doublesymmetry.musicapp.feed.api.seam.FeedState
import com.doublesymmetry.musicapp.navigation.MviComposableFeatureEntry
import com.doublesymmetry.musicapp.navigation.NavigationViewModel

abstract class FeedEntry<T : NavigationViewModel<FeedState, FeedEffect, FeedAction, FeedMutation>> :
    MviComposableFeatureEntry<FeedState, FeedEffect, FeedAction, T>() {

    final override val featureRoute: String
        get() = "feed"

}
