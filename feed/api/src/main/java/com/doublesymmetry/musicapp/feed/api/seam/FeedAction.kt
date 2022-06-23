package com.doublesymmetry.musicapp.feed.api.seam

sealed class FeedAction {
    data class Load(val page: Int): FeedAction()
}
