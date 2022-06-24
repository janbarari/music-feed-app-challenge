package com.doublesymmetry.musicapp.feed.api.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedApiModel(
    @field:Json(name = "data")
    val data: Data
): Parcelable

@Parcelize
data class Data(
    @field:Json(name = "sessions")
    val sessions: List<Music>
): Parcelable

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

@Parcelize
data class CurrentTrack(
    @field:Json(name = "title")
    val title: String,
    @field:Json(name = "artwork_url")
    val artworkUrl: String
): Parcelable