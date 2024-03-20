package com.doublesymmetry.musicapp.navigation

import androidx.lifecycle.ViewModel
import com.doublesymmetry.musicapp.architecture.Mutation
import com.doublesymmetry.musicapp.architecture.Seam

abstract class ViewModelContract: ViewModel(), Seam<Any, Any, Any, Mutation<Any>>
