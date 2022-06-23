package com.doublesymmetry.musicapp.common

class DefaultPaginator<Key, Item>(
    private val initialKey: Key,
    private inline val onLoadUpdated: (Boolean) -> Unit,
    private inline val onRequest: suspend (nextKey: Key) -> Result<List<Item>>,
    private inline val getNextKey: suspend (List<Item>) -> Key,
    private inline val onError: suspend (Throwable) -> Unit,
    private inline val onSuccess: suspend (newItems: List<Item>, nextKey: Key) -> Unit
): Paginator<Key, Item> {

    private var currentKey: Key = initialKey
    private var isMakingRequest: Boolean = false

    override suspend fun loadMoreItems() {
        if (isMakingRequest) return
        isMakingRequest = true

        onLoadUpdated(true)
        val result = onRequest(currentKey)
        isMakingRequest = false

        val items = result.getOrElse {
            onError(it)
            onLoadUpdated(false)
            return
        }

        currentKey = getNextKey(items)
        onSuccess(items, currentKey)
        onLoadUpdated(false)
    }

    override fun reset() {
        currentKey = initialKey
    }

}
