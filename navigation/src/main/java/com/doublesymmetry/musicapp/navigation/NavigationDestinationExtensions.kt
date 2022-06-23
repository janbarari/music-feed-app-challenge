package com.doublesymmetry.musicapp.navigation

inline fun <reified T: FeatureEntry> Map<Class<out FeatureEntry>, FeatureEntry>.findOrNull(): T? {
    return this[T::class.java] as? T
}

inline fun <reified T: FeatureEntry> Map<Class<out FeatureEntry>, FeatureEntry>.find(): T {
    return findOrNull() ?: error("Unable to find '${T::class.java}' destination.")
}
