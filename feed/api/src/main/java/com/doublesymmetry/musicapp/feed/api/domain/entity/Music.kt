package com.doublesymmetry.musicapp.feed.api.domain.entity

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class Music(
    @field:Json(name = "name")
    val name: String,
    @field:Json(name = "listener_count")
    val listenerCount: Int,
    @field:Json(name = "genres")
    val genres: List<String>,
    @field:Json(name = "current_track")
    val currentTrack: CurrentTrack
): Parcelable