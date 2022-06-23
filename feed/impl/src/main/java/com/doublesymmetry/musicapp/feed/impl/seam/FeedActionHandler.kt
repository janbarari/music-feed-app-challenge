package com.doublesymmetry.musicapp.feed.impl.seam

import com.doublesymmetry.musicapp.architecture.ActionHandler
import com.doublesymmetry.musicapp.feed.api.seam.FeedAction
import com.doublesymmetry.musicapp.feed.api.seam.FeedEffect
import com.doublesymmetry.musicapp.feed.api.seam.FeedMutation
import com.doublesymmetry.musicapp.feed.api.seam.FeedState
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FeedActionHandler @Inject constructor(): ActionHandler<FeedState, FeedEffect, FeedAction, FeedMutation> {

    override fun handleAction(
        state: FeedState,
        action: FeedAction,
        effect: suspend (FeedEffect) -> Unit
    ): Flow<FeedMutation> {
        return flow {

        }
    }

}