package com.doublesymmetry.musicapp.navigation

import androidx.navigation.NamedNavArgument
import androidx.navigation.NavDeepLink

interface FeatureEntry {

    val featureRoute: String

    val arguments: List<NamedNavArgument>
        get() = emptyList()

    val deepLinks: List<NavDeepLink>
        get() = emptyList()

}
