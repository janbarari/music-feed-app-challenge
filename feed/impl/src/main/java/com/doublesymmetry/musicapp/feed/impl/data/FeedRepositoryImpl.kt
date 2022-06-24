package com.doublesymmetry.musicapp.feed.impl.data

import com.doublesymmetry.musicapp.feed.impl.service.model.FeedApiModel
import com.doublesymmetry.musicapp.feed.impl.domain.FeedRepository
import com.doublesymmetry.musicapp.feed.impl.service.FeedApiService

class FeedRepositoryImpl(
    private val api: FeedApiService
) : FeedRepository {

    override suspend fun getFeed(): FeedApiModel {
        return api.getFeed()
    }

}
