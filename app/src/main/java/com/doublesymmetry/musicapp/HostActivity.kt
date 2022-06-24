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
import com.doublesymmetry.musicapp.navigation.LocalNavigationDestinationsProvider
import com.doublesymmetry.musicapp.navigation.NavigationDestinations
import com.google.accompanist.systemuicontroller.rememberSystemUiController
import dagger.hilt.android.AndroidEntryPoint
import javax.inject.Inject

@AndroidEntryPoint
class HostActivity: ComponentActivity() {

    @Inject
    lateinit var navigationDestinations: NavigationDestinations

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            val systemUiController = rememberSystemUiController()
            CompositionLocalProvider(
                LocalSystemUiController provides systemUiController,
                LocalNavigationDestinationsProvider provides navigationDestinations
            ) {
                MusicAppTheme {
                    Navigation()
                }
            }
        }
    }

}
