package com.doublesymmetry.musicapp.feed.api

import com.doublesymmetry.musicapp.architecture.Seam
import com.doublesymmetry.musicapp.feed.api.seam.FeedAction
import com.doublesymmetry.musicapp.feed.api.seam.FeedEffect
import com.doublesymmetry.musicapp.feed.api.seam.FeedMutation
import com.doublesymmetry.musicapp.feed.api.seam.FeedState
import com.doublesymmetry.musicapp.navigation.ViewModelContract

abstract class FeedViewContract: ViewModelContract(), Seam<FeedState, FeedEffect, FeedAction, FeedMutation>
