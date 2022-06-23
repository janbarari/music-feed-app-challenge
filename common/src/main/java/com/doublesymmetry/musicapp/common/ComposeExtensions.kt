package com.doublesymmetry.musicapp.common

import androidx.compose.foundation.lazy.grid.LazyGridState
import androidx.compose.runtime.*

@Composable
fun LazyGridState.whenBottomReached(
    loadMore: () -> Unit
) {
    val shouldLoadMore = remember {
        derivedStateOf {
            val lastVisibleItem = layoutInfo.visibleItemsInfo.lastOrNull()
                ?: return@derivedStateOf true

            lastVisibleItem.index == layoutInfo.totalItemsCount - 1
        }
    }

    // Convert the state into a cold flow and collect
    LaunchedEffect(shouldLoadMore) {
        snapshotFlow { shouldLoadMore.value }
            .collect {
                // if should load more, then invoke loadMore()
                if (it) loadMore()
            }
    }
}
