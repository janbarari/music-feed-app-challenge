package com.doublesymmetry.musicapp.architecture

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class SeamViaHandler<S : Any, E : Any, A : Any, M : Mutation<S>>(
    private val handler: ActionHandler<S, E, A, M>,
    initialState: S
) : Seam<S, E, A, M> {

    private val _state = MutableStateFlow(initialState)
    override val state: StateFlow<S>
        get() = _state

    private val _effect = MutableSharedFlow<E>(replay = 0)
    override val effects: Flow<E>
        get() = _effect

    override suspend fun action(action: A) {
        handler.handleAction(
            _state.value,
            action
        ) { effect ->
            _effect.emit(effect)
        }.flowOn(Dispatchers.Default)
            .cancellable()
            .collect { mutation ->
                _state.update { mutation.reduce(_state.value) }
            }
    }

    companion object {
        fun <State : Any, Effect : Any, Action : Any, Model : Mutation<State>> handler(
            handler: ActionHandler<State, Effect, Action, Model>,
            initialState: State
        ) = SeamViaHandler(handler, initialState)
    }

}