package com.doublesymmetry.musicapp.navigation

import androidx.compose.runtime.compositionLocalOf
import com.doublesymmetry.musicapp.navigation.NavigationDestinations

val LocalNavigationDestinationsProvider = compositionLocalOf<NavigationDestinations> {
    error("No navigation destinations found!")
}

inline fun <reified T: FeatureEntry> Map<Class<out FeatureEntry>, FeatureEntry>.findOrNull(): T? {
    return this[T::class.java] as? T
}

inline fun <reified T: FeatureEntry> Map<Class<out FeatureEntry>, FeatureEntry>.find(): T {
    return findOrNull() ?: error("Unable to find '${T::class.java}' destination.")
}
