package com.doublesymmetry.musicapp.feed.api.domain.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class CurrentTrack(
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "artwork_url")
    val artworkUrl: String
): Parcelable