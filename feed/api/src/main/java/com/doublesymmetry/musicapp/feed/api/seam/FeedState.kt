package com.doublesymmetry.musicapp.feed.api.seam

import com.doublesymmetry.musicapp.feed.api.model.Music

data class FeedState(
    val isLoading: Boolean = false,
    val items: List<Music> = emptyList(),
    val error: Throwable? = null,
    val isEndReached: Boolean = false,
    val page: Int = 1
)
