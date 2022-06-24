package com.doublesymmetry.musicapp.common

fun List<String>.toStr(): String {
    val result = StringBuilder()
    forEachIndexed { i, s ->
        result.append(s)
        if (i < size - 1) {
            result.append(", ")
        }
    }
    return result.toString()
}
