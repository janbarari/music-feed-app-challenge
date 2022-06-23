package com.doublesymmetry.musicapp.architecture

import kotlinx.coroutines.flow.Flow

fun interface ActionHandler<State, Effect, Action, Model: Mutation<State>> {
    fun handleAction(state: State, action: Action, effect: suspend (Effect) -> Unit): Flow<Model>
}
