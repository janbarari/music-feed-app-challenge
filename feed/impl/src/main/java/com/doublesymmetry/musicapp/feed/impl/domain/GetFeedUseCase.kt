package com.doublesymmetry.musicapp.feed.impl.domain

import com.doublesymmetry.musicapp.architecture.NoInputUseCase
import com.doublesymmetry.musicapp.feed.impl.service.model.FeedApiModel
import javax.inject.Inject

class GetFeedUseCase @Inject constructor(
    private val feedRepository: FeedRepository
) : NoInputUseCase<FeedApiModel>() {

    override suspend fun execute(): FeedApiModel {
        return feedRepository.getFeed()
    }

}
