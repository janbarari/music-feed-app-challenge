package com.doublesymmetry.musicapp.design_system.theme

import androidx.compose.material.MaterialTheme
import androidx.compose.material.darkColors
import androidx.compose.material.lightColors
import androidx.compose.runtime.Composable
import androidx.compose.runtime.SideEffect
import androidx.compose.ui.graphics.Color

private val ColorPalette = darkColors(
    primary = Color.White,
    primaryVariant = Color.White,
    secondary = Color.White,
    background = Colors.primaryColor,
    surface = Colors.primaryColor
)

@Composable
fun MusicAppTheme(
    content: @Composable () -> Unit
) {
    MaterialTheme(
        colors = ColorPalette,
        typography = MusicAppTypography
    ) {
        val systemUiController = LocalSystemUiController.current
        SideEffect {
            systemUiController.setSystemBarsColor(
                color = Color.Transparent
            )
        }
        content()
    }
}