package com.doublesymmetry.musicapp.feed.api.seam

import com.doublesymmetry.musicapp.architecture.Mutation
import com.doublesymmetry.musicapp.feed.api.domain.entity.Music

sealed class FeedMutation(
    mutation: Mutation<FeedState>
) : Mutation<FeedState> by mutation {

    object OnLoadingFeed : FeedMutation(
        {
            it.copy(
                isLoading = true,
                error = null
            )
        }
    )

    data class OnLoadFeedSuccess(
        val items: List<Music>,
        val page: Int
    ) : FeedMutation(
        {
            it.copy(
                items = it.items + items,
                isLoading = false,
                page = page,
                isEndReached = page == 5,
                error = null
            )
        }
    )

    data class OnLoadFeedError(
        val exception: Throwable
    ) : FeedMutation(
        {
            it.copy(
                isLoading = false,
                error = exception
            )
        }
    )

    data class OnSearchResult(
        val result: List<Music>
    ): FeedMutation(
        {
            it.copy(
                items = result,
                isEndReached = true,
                error = null,
                isLoading = false
            )
        }
    )

    object OnResetFeed: FeedMutation(
        {
            it.copy(
                isEndReached = false,
                error = null,
                page = 1,
                items = emptyList()
            )
        }
    )

}