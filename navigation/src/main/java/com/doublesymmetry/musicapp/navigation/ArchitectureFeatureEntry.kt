package com.doublesymmetry.musicapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.lifecycle.ViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.doublesymmetry.musicapp.architecture.EffectHandler
import com.doublesymmetry.musicapp.architecture.Seam
import com.google.accompanist.navigation.animation.composable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
abstract class ArchitectureFeatureEntry<S : Any, E : Any, A : Any, C: ViewModelContract> : FeatureEntry {

    abstract fun getEffectHandler(): EffectHandler<E>
    abstract fun getInitializer(backStackEntry: NavBackStackEntry, action: (A) -> Unit)

    abstract fun getViewContract(): C

    inline fun <reified C> NavGraphBuilder.composable(
        navController: NavHostController,
        destinations: Map<Class<out FeatureEntry>, FeatureEntry>
    ) where C : ViewModel, C : Seam<S, E, A, *> {

        composable(
            route = featureRoute,
            arguments = arguments,
            deepLinks = deepLinks,
            enterTransition = enterTransition,
            exitTransition = exitTransition
        ) { backStackEntry ->

            val model = getViewContract()
            val scope = rememberCoroutineScope()

            val action: (A) -> Unit = {
                scope.launch {
                    model.action(it)
                }
            }

            val state by model.state.collectAsState()
            Composable(
                navController,
                destinations,
                backStackEntry,
                state,
                model.effects,
                action
            )

            val keyboard = LocalSoftwareKeyboardController.current
            LaunchedEffect(Unit) {
                keyboard?.hide()
                getInitializer(backStackEntry, action)
                model.effects.cancellable().collect {
                    getEffectHandler().handleEffect(it)
                }
            }
        }
    }

    @Composable
    abstract fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Map<Class<out FeatureEntry>, FeatureEntry>,
        backStackEntry: NavBackStackEntry,
        state: S,
        effect: Flow<E>,
        action: (A) -> Unit
    )

}
