package com.doublesymmetry.musicapp.common

interface Paginator<Key, Item> {
    suspend fun loadMoreItems()
    fun reset()
}
