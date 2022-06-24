package com.doublesymmetry.musicapp.feed.impl.domain

import com.doublesymmetry.musicapp.feed.api.model.FeedApiModel

interface FeedRepository {
    suspend fun getFeed(): FeedApiModel
}
