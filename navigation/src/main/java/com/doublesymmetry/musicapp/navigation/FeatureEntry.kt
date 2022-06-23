package com.doublesymmetry.musicapp.navigation

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink

@OptIn(ExperimentalAnimationApi::class)
interface FeatureEntry {

    val featureRoute: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()

    val enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition)?
        get() = null

    val exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition)?
        get() = null

}
