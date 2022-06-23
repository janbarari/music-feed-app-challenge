package com.doublesymmetry.musicapp.design_system.theme

import androidx.compose.runtime.ProvidableCompositionLocal
import androidx.compose.runtime.compositionLocalOf
import com.google.accompanist.systemuicontroller.SystemUiController

val LocalSystemUiController: ProvidableCompositionLocal<SystemUiController> =
    compositionLocalOf { throw IllegalStateException("Not initialised") }