package com.doublesymmetry.musicapp.architecture

interface EffectHandler<Effect> {
    suspend fun handleEffect(effect: Effect)
}
