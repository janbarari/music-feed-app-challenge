package com.doublesymmetry.musicapp.navigation

import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.doublesymmetry.musicapp.architecture.EffectHandler
import com.google.accompanist.navigation.animation.composable
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
abstract class MviComposableFeatureEntry<S : Any, E : Any, A : Any, VM : NavigationViewModel<S, E, A, *>> : FeatureEntry {

    abstract fun getEffectHandler(): EffectHandler<E>
    abstract fun getInitializer(backStackEntry: NavBackStackEntry, action: (A) -> Unit)

    fun NavGraphBuilder.composable(
        navController: NavHostController,
        destinations: Map<Class<out FeatureEntry>, FeatureEntry>,
        createModel: @Composable () -> VM
    ) {
        composable(
            route = featureRoute,
            arguments = arguments,
            deepLinks = deepLinks,
            enterTransition = enterTransition,
            exitTransition = exitTransition
        ) { backStackEntry ->

            val model = createModel()
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
