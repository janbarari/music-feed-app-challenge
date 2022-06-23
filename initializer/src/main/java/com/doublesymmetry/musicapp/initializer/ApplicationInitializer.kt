package com.doublesymmetry.musicapp.initializer

import android.app.Application
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ApplicationInitializer @Inject constructor(
    private val listeners: Set<@JvmSuppressWildcards ApplicationCreated>
) {

    fun onCreated(app: Application) {
        listeners.sortedBy { it.getOrderNumber() }.forEach { it.onAppCreated(app) }
    }

}
