package com.doublesymmetry.musicapp.feed.impl.view

import androidx.compose.foundation.clickable
import androidx.compose.foundation.interaction.MutableInteractionSource
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.GridItemSpan
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.lazy.grid.rememberLazyGridState
import androidx.compose.material.Card
import androidx.compose.material.Scaffold
import androidx.compose.material.Text
import androidx.compose.material.ripple.rememberRipple
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.doublesymmetry.musicapp.common.toStr
import com.doublesymmetry.musicapp.common.whenBottomReached
import com.doublesymmetry.musicapp.design_system.component.LoadingIndicator
import com.doublesymmetry.musicapp.design_system.component.MusicCard
import com.doublesymmetry.musicapp.design_system.component.SearchBar
import com.doublesymmetry.musicapp.design_system.theme.Colors
import com.doublesymmetry.musicapp.design_system.theme.SFProDisplay
import com.doublesymmetry.musicapp.feed.api.seam.FeedAction
import com.doublesymmetry.musicapp.feed.api.seam.FeedState
import kotlinx.coroutines.flow.MutableSharedFlow
import kotlinx.coroutines.flow.debounce
import kotlinx.coroutines.flow.distinctUntilChanged
import kotlinx.coroutines.launch

@Composable
fun FeedScreen(state: FeedState, action: (FeedAction) -> Unit) {
    val scrollState = rememberLazyGridState()
    val queryFlow = remember {
        MutableSharedFlow<String>()
    }
    val coroutineScope = rememberCoroutineScope()

    Scaffold(
        modifier = Modifier.fillMaxSize(),
        topBar = {
            TopBar { query ->
                coroutineScope.launch {
                    queryFlow.emit(query)
                }
            }
        },
        backgroundColor = Colors.primaryColor
    ) { padding ->

        LazyVerticalGrid(
            modifier = Modifier.padding(padding),
            columns = GridCells.Fixed(2),
            contentPadding = PaddingValues(top = 16.dp, start = 16.dp, end = 16.dp, bottom = 100.dp),
            state = scrollState,
            verticalArrangement = Arrangement.spacedBy(16.dp),
            horizontalArrangement = Arrangement.spacedBy(16.dp)
        ) {

            items(state.items.size) { i ->
                val item = state.items[i]
                MusicCard(
                    modifier = Modifier
                        .width(184.dp)
                        .height(184.dp)
                        .clickable(
                            interactionSource = remember { MutableInteractionSource() },
                            indication = rememberRipple(bounded = true, color = Color.White),
                            onClick = {

                            }
                        ),
                    title = item.currentTrack.title,
                    description = item.genres.toStr(),
                    coverUrl = item.currentTrack.artworkUrl
                )
            }

            item(span = { GridItemSpan(2) }) {
                if (state.isLoading) {
                    LoadingIndicator(modifier = Modifier.fillMaxWidth())
                }
            }

            if (state.error != null) {
                item(span = { GridItemSpan(2) }) {
                    Text(text = state.error?.message.toString())
                }
            }

        }
    }

    scrollState.whenBottomReached {
        action(FeedAction.LoadFeed)
    }

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            queryFlow
                .debounce(300)
                .distinctUntilChanged()
                .collect {
                    action(FeedAction.SearchFor(it))
                }
        }
    }
}

@Composable
fun TopBar(onSearchTextChanged: (String) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth(),
        elevation = 4.dp,
        shape = RectangleShape,
        backgroundColor = Colors.primaryColor
    ) {

        Column(
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 44.dp, start = 16.dp, bottom = 16.dp, end = 16.dp),
            verticalArrangement = Arrangement.Bottom
        ) {

            Text(
                modifier = Modifier.fillMaxWidth(),
                text = "Discover",
                color = Color.White,
                fontSize = 32.sp,
                fontFamily = SFProDisplay,
                fontWeight = FontWeight.Bold
            )

            SearchBar(
                modifier = Modifier
                    .padding(top = 14.dp)
                    .height(36.dp)
                    .fillMaxWidth(),
                hint = "Search",
                onTextChanged = onSearchTextChanged::invoke
            )

        }

    }
}
