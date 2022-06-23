package com.doublesymmetry.musicapp.architecture

fun interface Mutation<State> {
    fun reduce(state: State): State
}
