package com.doublesymmetry.musicapp.design_system.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import coil.request.ImageRequest
import com.doublesymmetry.musicapp.design_system.theme.SFProDisplay

@Composable
fun MusicCard(
    modifier: Modifier = Modifier,
    title: String,
    description: String,
    coverUrl: String
) {
    Card(
        shape = RoundedCornerShape(10.dp),
        modifier = modifier,
        elevation = 4.dp,
        backgroundColor = Color(0xFF1D1D1D)
    ) {
        Box(modifier = Modifier.fillMaxSize()) {

            AsyncImage(
                modifier = Modifier.fillMaxSize(),
                model = ImageRequest.Builder(LocalContext.current)
                    .data(coverUrl)
                    .crossfade(true)
                    .build(),
                contentDescription = description,
                contentScale = ContentScale.Crop
            )

            Box(
                modifier = Modifier
                    .fillMaxSize()
                    .background(
                        brush = Brush.verticalGradient(
                            listOf(
                                Color.Transparent,
                                Color(0xE6000000)
                            ),
                            300f
                        )
                    )
            )

            Box(modifier = Modifier.fillMaxSize()) {

                Column(
                    modifier = Modifier
                        .fillMaxSize()
                        .padding(9.dp),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(
                        modifier = Modifier
                            .fillMaxWidth(),
                        text = title,
                        color = Color.White,
                        fontWeight = FontWeight.SemiBold,
                        fontFamily = SFProDisplay,
                        maxLines = 1
                    )
                    Text(
                        modifier = Modifier
                            .padding(top = 2.dp)
                            .fillMaxWidth(),
                        text = description,
                        color = Color.White,
                        maxLines = 1
                    )
                }

            }

        }
    }

}
