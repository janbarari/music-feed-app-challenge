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

        is FeedAction.LoadFeed -> flow {
            try {
                if (!state.isEndReached) {
                    emit(FeedMutation.OnLoadingFeed)
                    emit(
                        FeedMutation.OnLoadFeedSuccess(
                            getFeedUseCase.execute().data.sessions,
                            state.page + 1
                        )
                    )
                }
            } catch (e: Throwable) {
                emit(FeedMutation.OnLoadFeedError(e))
            }

        }

        FeedAction.SearchCleared -> flow {
            effect(FeedEffect.ResetFeed)
            emit(FeedMutation.OnResetFeed)
        }

        is FeedAction.SearchFor -> flow {
            try {
                emit(FeedMutation.OnLoadingFeed)

                val filteredMusics = getFeedUseCase.execute().data.sessions.filter {
                        it.currentTrack.title.lowercase().contains(action.query.lowercase()) ||
                                it.genres.toString().lowercase().contains(action.query.lowercase())
                    }
                emit(FeedMutation.OnSearchResult(filteredMusics))
            } catch (e: Throwable) {
                emit(FeedMutation.OnLoadFeedError(e))
            }
        }

    }

}