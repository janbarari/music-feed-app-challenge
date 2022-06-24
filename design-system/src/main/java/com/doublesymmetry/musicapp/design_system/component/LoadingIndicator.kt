package com.doublesymmetry.musicapp.design_system.component

import androidx.compose.animation.core.*
import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.size
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.graphicsLayer
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.doublesymmetry.musicapp.design_system.R

@Composable
fun LoadingIndicator(
    modifier: Modifier = Modifier
) {

    Row(modifier = modifier, horizontalArrangement = Arrangement.Center) {
        val infiniteTransition = rememberInfiniteTransition()

        val rotateAnim by infiniteTransition.animateFloat(
            initialValue = 0F,
            targetValue = 360F,
            animationSpec = infiniteRepeatable(
                animation = tween(
                    durationMillis = 4500,
                    easing = LinearEasing
                )
            )
        )

        Image(
            modifier = Modifier
                .size(32.dp)
                .graphicsLayer {
                    rotationZ = rotateAnim
                },
            painter = painterResource(id = R.drawable.ic_indicator),
            contentDescription = "Loading Indicator"
        )
    }

}
