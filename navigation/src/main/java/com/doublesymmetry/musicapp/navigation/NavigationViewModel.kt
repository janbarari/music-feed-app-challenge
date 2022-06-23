package com.doublesymmetry.musicapp.navigation

import androidx.lifecycle.ViewModel
import com.doublesymmetry.musicapp.architecture.Mutation
import com.doublesymmetry.musicapp.architecture.Seam

abstract class NavigationViewModel<S: Any, E: Any, A: Any, M: Mutation<S>>: ViewModel(), Seam<S, E, A, M>