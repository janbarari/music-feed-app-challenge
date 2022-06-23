package com.doublesymmetry.musicapp.architecture

fun interface Mutation<S> {
    fun reduce(state: S): S
}
