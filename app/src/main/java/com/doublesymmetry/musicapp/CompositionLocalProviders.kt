package com.doublesymmetry.musicapp

import androidx.compose.runtime.compositionLocalOf
import com.doublesymmetry.musicapp.navigation.NavigationDestinations

val LocalNavigationDestinationsProvider = compositionLocalOf<NavigationDestinations> {
    error("No navigation destinations found!")
}
