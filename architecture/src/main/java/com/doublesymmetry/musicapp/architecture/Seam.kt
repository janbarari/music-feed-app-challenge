package com.doublesymmetry.musicapp.architecture

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Seam<S : Any, E : Any, A : Any, M : Mutation<S>> {
    val state: StateFlow<S>
    val effects: Flow<E>
    suspend fun action(action: A)
}
