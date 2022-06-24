package com.doublesymmetry.musicapp.architecture

abstract class UseCase<I, O> {
    abstract suspend fun execute(input: I): O
}
