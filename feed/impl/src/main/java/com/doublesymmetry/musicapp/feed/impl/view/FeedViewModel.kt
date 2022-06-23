package com.doublesymmetry.musicapp.feed.impl.view

import androidx.lifecycle.ViewModel
import com.doublesymmetry.musicapp.architecture.Seam
import com.doublesymmetry.musicapp.architecture.SeamViaHandler.Companion.handler
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
) : ViewModel(), Seam<FeedState, FeedEffect, FeedAction, FeedMutation> by handler(
    feedActionHandler,
    FeedState()
)
