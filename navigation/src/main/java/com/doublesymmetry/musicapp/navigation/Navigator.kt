package com.doublesymmetry.musicapp.navigation

import android.content.Intent
import androidx.navigation.NavController
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class Navigator @Inject internal constructor(
    private val intentLauncher: IntentLauncher
) {

    lateinit var navController: NavController

    fun navigateTo(intent: Intent) {
        intentLauncher.launch(intent)
    }

    fun navigateTo(route: String) {
        navController.navigate(route)
    }

    fun navigateBack() {
        navController.popBackStack()
    }

    fun clearBackStack() {
        navController.backQueue.clear()
    }

}
