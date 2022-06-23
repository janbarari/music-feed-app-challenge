package com.doublesymmetry.musicapp.feed.impl.seam

import com.doublesymmetry.musicapp.architecture.EffectHandler
import com.doublesymmetry.musicapp.feed.api.seam.FeedEffect
import javax.inject.Inject

class FeedEffectHandler @Inject constructor() : EffectHandler<FeedEffect> {

    override suspend fun handleEffect(effect: FeedEffect) {

    }

}
