package com.doublesymmetry.musicapp.feed.impl.service.model

import android.os.Parcelable
import com.doublesymmetry.musicapp.feed.api.domain.entity.Music
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedApiModel(
    @field:Json(name = "data")
    val data: Data
) : Parcelable

@Parcelize
data class Data(
    @field:Json(name = "sessions")
    val sessions: List<Music>
) : Parcelable
