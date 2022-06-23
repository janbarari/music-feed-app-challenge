package com.doublesymmetry.musicapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.Composable
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.google.accompanist.navigation.animation.composable

@OptIn(ExperimentalAnimationApi::class)
interface ComposableFeatureEntry : FeatureEntry {

    fun NavGraphBuilder.composable(
        navHostController: NavHostController,
        destinations: Map<Class<out FeatureEntry>, FeatureEntry>
    ) {
        composable(featureRoute, arguments, deepLinks) { navBackStackEntry ->
            Composable(navHostController, destinations, navBackStackEntry)
        }
    }

    @Composable
    fun NavGraphBuilder.Composable(
        navHostController: NavHostController,
        destinations: Map<Class<out FeatureEntry>, FeatureEntry>,
        backStackEntry: NavBackStackEntry
    )

}
