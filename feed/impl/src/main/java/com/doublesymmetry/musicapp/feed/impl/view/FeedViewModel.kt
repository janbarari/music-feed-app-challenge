package com.doublesymmetry.musicapp.feed.impl.view

import com.doublesymmetry.musicapp.architecture.Seam
import com.doublesymmetry.musicapp.architecture.SeamViaHandler.Companion.handler
import com.doublesymmetry.musicapp.feed.api.FeedViewContract
import com.doublesymmetry.musicapp.feed.api.seam.FeedAction
import com.doublesymmetry.musicapp.feed.api.seam.FeedEffect
import com.doublesymmetry.musicapp.feed.api.seam.FeedMutation
import com.doublesymmetry.musicapp.feed.api.seam.FeedState
import com.doublesymmetry.musicapp.feed.impl.seam.FeedActionHandler
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class FeedViewModel @Inject constructor(
    private val feedActionHandler: FeedActionHandler
) : FeedViewContract(),
    Seam<FeedState, FeedEffect, FeedAction, FeedMutation> by handler(
        feedActionHandler,
        FeedState()
    )
