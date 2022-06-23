package com.doublesymmetry.musicapp.design_system.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.doublesymmetry.musicapp.design_system.R

val SFProDisplay = FontFamily(
    Font(resId = R.font.sfprodisplay_regular),
    Font(resId = R.font.sfprodisplay_thin, weight = FontWeight.Thin),
    Font(resId = R.font.sfprodisplay_medium, weight = FontWeight.Medium),
    Font(resId = R.font.sfprodisplay_semibold, weight = FontWeight.SemiBold),
    Font(resId = R.font.sfprodisplay_bold, weight = FontWeight.Bold)
)

val MusicAppTypography = androidx.compose.material.Typography(
    defaultFontFamily = SFProDisplay
)
