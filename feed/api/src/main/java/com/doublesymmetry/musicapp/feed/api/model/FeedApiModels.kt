package com.doublesymmetry.musicapp.feed.api.model

import android.os.Parcelable
import com.squareup.moshi.Json
import kotlinx.parcelize.Parcelize

@Parcelize
data class FeedApiModel(
    @Json(name = "data")
    val data: Data
): Parcelable

@Parcelize
data class Data(
    @Json(name = "sessions")
    val sessions: List<Music>
): Parcelable

@Parcelize
data class Music(
    @Json(name = "name")
    val name: String,
    @Json(name = "listener_count")
    val listenerCount: Int,
    @Json(name = "genres")
    val genres: List<String>,
    @Json(name = "current_track")
    val currentTrack: CurrentTrack
): Parcelable

@Parcelize
data class CurrentTrack(
    @Json(name = "title")
    val title: String,
    @Json(name = "artwork_url")
    val artworkUrl: String
): Parcelable