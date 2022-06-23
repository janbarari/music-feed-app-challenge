package com.doublesymmetry.musicapp.architecture

import kotlinx.coroutines.flow.Flow

fun interface ActionHandler<S, E, A, M : Mutation<S>> {
    fun handleAction(state: S, action: A, effect: suspend (E) -> Unit): Flow<M>
}
