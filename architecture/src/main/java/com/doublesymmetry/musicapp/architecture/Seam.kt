package com.doublesymmetry.musicapp.architecture

import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.StateFlow

interface Seam<State: Any, Effect: Any, Action: Any, Model: Mutation<State>> {
    val state: StateFlow<State>
    val effects: Flow<Effect>
    suspend fun action(action: Action)
}
