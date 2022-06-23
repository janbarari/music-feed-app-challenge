package com.doublesymmetry.musicapp.navigation

import javax.inject.Inject

class NavigationDestinations @Inject constructor(
    val routes: Map<Class<out FeatureEntry>, @JvmSuppressWildcards FeatureEntry>
)
