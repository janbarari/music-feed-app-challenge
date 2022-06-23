package com.doublesymmetry.musicapp.feed.impl.service

import com.doublesymmetry.musicapp.feed.api.model.FeedApiModel
import retrofit2.http.GET

interface FeedApiService {

    @GET("5df79a3a320000f0612e0115")
    suspend fun getFeed(): FeedApiModel

}
