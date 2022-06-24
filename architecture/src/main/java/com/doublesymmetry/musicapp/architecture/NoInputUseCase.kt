package com.doublesymmetry.musicapp.architecture

abstract class NoInputUseCase<O> {
    abstract suspend fun execute(): O
}
