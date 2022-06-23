package com.doublesymmetry.musicapp.navigation

import android.content.Context
import android.content.Intent
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

internal class IntentLauncher @Inject constructor(
    @ApplicationContext private val context: Context
) {

    fun launch(intent: Intent) {
        context.startActivity(
            intent.apply {
                addFlags(Intent.FLAG_ACTIVITY_NEW_TASK)
            }
        )
    }

}
