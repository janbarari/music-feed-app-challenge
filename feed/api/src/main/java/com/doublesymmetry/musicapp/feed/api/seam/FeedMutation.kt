package com.doublesymmetry.musicapp.feed.api.seam

import com.doublesymmetry.musicapp.architecture.Mutation
import com.doublesymmetry.musicapp.feed.api.model.Music

sealed class FeedMutation(
    mutation: Mutation<FeedState>
) : Mutation<FeedState> by mutation {

    object Loading: FeedMutation(
        {
            it.copy(isLoading = true)
        }
    )

    data class Loaded(val musics: List<Music>) : FeedMutation(
        {
            it.copy(
                items = musics,
                isLoading = false
            )
        }
    )

}
