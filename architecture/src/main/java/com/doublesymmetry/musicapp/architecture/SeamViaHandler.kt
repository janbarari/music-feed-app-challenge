package com.doublesymmetry.musicapp.architecture

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.flow.*

class SeamViaHandler<State: Any, Effect: Any, Action: Any, Model: Mutation<State>>(
    private val handler: ActionHandler<State, Effect, Action, Model>,
    initialState: State
): Seam<State, Effect, Action, Model> {

    private val _state = MutableStateFlow(initialState)
    override val state: StateFlow<State>
        get() = _state

    private val _effect = MutableSharedFlow<Effect>(replay = 0)
    override val effects: Flow<Effect>
        get() = _effect

    override suspend fun action(action: Action) {
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
        fun <State: Any, Effect: Any, Action: Any, Model: Mutation<State>> handler(
            handler: ActionHandler<State, Effect, Action, Model>,
            initialState: State
        ) = SeamViaHandler(handler, initialState)
    }

}