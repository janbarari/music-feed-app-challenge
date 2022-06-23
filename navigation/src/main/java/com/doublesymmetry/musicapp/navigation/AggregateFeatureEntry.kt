package com.doublesymmetry.musicapp.navigation

import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder

interface AggregateFeatureEntry: FeatureEntry {

    fun NavGraphBuilder.navigation(
        navController: NavController,
        destinations: Map<Class<out FeatureEntry>, FeatureEntry>
    )

}
