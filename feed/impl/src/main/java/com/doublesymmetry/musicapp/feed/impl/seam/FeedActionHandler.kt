package com.doublesymmetry.musicapp.feed.impl.seam

import com.doublesymmetry.musicapp.architecture.ActionHandler
import com.doublesymmetry.musicapp.feed.api.seam.FeedAction
import com.doublesymmetry.musicapp.feed.api.seam.FeedEffect
import com.doublesymmetry.musicapp.feed.api.seam.FeedMutation
import com.doublesymmetry.musicapp.feed.api.seam.FeedState
import com.doublesymmetry.musicapp.feed.impl.domain.GetFeedUseCase
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.flow
import javax.inject.Inject

class FeedActionHandler @Inject constructor(
    private val getFeedUseCase: GetFeedUseCase
) : ActionHandler<FeedState, FeedEffect, FeedAction, FeedMutation> {

    override fun handleAction(
        state: FeedState,
        action: FeedAction,
        effect: suspend (FeedEffect) -> Unit
    ): Flow<FeedMutation> = when (action) {

        is FeedAction.Load -> flow {
            try {
                if (state.page < 5) {
                    emit(FeedMutation.Loading)
                    emit(
                        FeedMutation.Loaded(
                            getFeedUseCase.execute().data.sessions,
                            state.page + 1
                        )
                    )
                }
            } catch (e: Throwable) {
                emit(FeedMutation.OnError(e))
            }

        }

        FeedAction.SearchCleared -> TODO()
        is FeedAction.SearchFor -> TODO()
    }

}