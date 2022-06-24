package com.doublesymmetry.musicapp.feed.api.seam

sealed class FeedAction {
    data class SearchFor(val query: String): FeedAction()
    object SearchCleared: FeedAction()
    object Load: FeedAction()
}
