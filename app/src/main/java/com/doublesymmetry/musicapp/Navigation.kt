package com.doublesymmetry.musicapp

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import com.doublesymmetry.musicapp.feed.api.FeedEntry
import com.doublesymmetry.musicapp.feed.api.FeedViewContract
import com.doublesymmetry.musicapp.navigation.LocalNavigationDestinationsProvider
import com.doublesymmetry.musicapp.navigation.find
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController

@OptIn(ExperimentalAnimationApi::class)
@Composable
fun Navigation() {
    val navHostController = rememberAnimatedNavController()
    val navigationDestinations = LocalNavigationDestinationsProvider.current.routes

    val feedScreen = navigationDestinations.find<FeedEntry>()

    AnimatedNavHost(navHostController, startDestination = feedScreen.featureRoute) {

        with(feedScreen) {
            composable<FeedViewContract>(navHostController, navigationDestinations)
        }

    }

}