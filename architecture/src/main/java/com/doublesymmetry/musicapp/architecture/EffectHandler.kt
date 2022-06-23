package com.doublesymmetry.musicapp.architecture

interface EffectHandler<E> {
    suspend fun handleEffect(effect: E)
}
