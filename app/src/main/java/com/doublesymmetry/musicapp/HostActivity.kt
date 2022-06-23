package com.doublesymmetry.musicapp

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.CompositionLocal
import androidx.compose.runtime.CompositionLocalProvider
import androidx.core.view.WindowCompat
import com.doublesymmetry.musicapp.design_system.theme.LocalSystemUiController
import com.doublesymmetry.musicapp.design_system.theme.MusicAppTheme
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class HostActivity: ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        try {
            WindowCompat.setDecorFitsSystemWindows(window, false)
        } catch (_: Exception) { /* safe to ignore */ }
        setContent {
            val systemUiController = rememberSystemUiController()
            CompositionLocalProvider(
                LocalSystemUiController provides systemUiController
            ) {
                MusicAppTheme {

                }
            }
        }
    }

}
