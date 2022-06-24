package com.doublesymmetry.musicapp.feed.impl.seam

import android.content.Context
import android.widget.Toast
import com.doublesymmetry.musicapp.architecture.EffectHandler
import com.doublesymmetry.musicapp.feed.api.seam.FeedEffect
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

class FeedEffectHandler @Inject constructor(
    @ApplicationContext private val context: Context
) : EffectHandler<FeedEffect> {

    override suspend fun handleEffect(effect: FeedEffect) {
        when(effect) {
            is FeedEffect.Reset -> {
                Toast.makeText(context, "List Has Been Reset!", Toast.LENGTH_LONG).show()
            }
        }
    }

}
