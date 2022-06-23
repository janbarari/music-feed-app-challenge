package com.doublesymmetry.musicapp.architecture

import androidx.compose.animation.AnimatedContentScope
import androidx.compose.animation.EnterTransition
import androidx.compose.animation.ExitTransition
import androidx.compose.animation.ExperimentalAnimationApi
import androidx.compose.runtime.*
import androidx.compose.ui.ExperimentalComposeUiApi
import androidx.compose.ui.platform.LocalSoftwareKeyboardController
import androidx.lifecycle.ViewModel
import androidx.navigation.NamedNavArgument
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavDeepLink
import androidx.navigation.NavGraphBuilder
import kotlinx.coroutines.flow.Flow
import com.google.accompanist.navigation.animation.composable
import kotlinx.coroutines.flow.cancellable
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch

@OptIn(ExperimentalAnimationApi::class, ExperimentalComposeUiApi::class)
fun <State: Any, Effect: Any, Action: Any, VM> NavGraphBuilder.Composable(
    route: String,
    arguments: List<NamedNavArgument> = emptyList(),
    deepLinks: List<NavDeepLink> = emptyList(),
    enterTransition: (AnimatedContentScope<NavBackStackEntry>.() -> EnterTransition)? = null,
    exitTransition: (AnimatedContentScope<NavBackStackEntry>.() -> ExitTransition)? = null,
    effectHandler: EffectHandler<Effect>,
    initializer: (NavBackStackEntry, (Action) -> Unit) -> Unit = { _, _ -> },
    viewModel: @Composable () -> VM,
    content: @Composable (state: State, effect: Flow<Effect>, actions: (Action) -> Unit) -> Unit
) where VM: ViewModel, VM: Seam<State, Effect, Action, *> {

    composable(
        route = route,
        arguments = arguments,
        deepLinks = deepLinks,
        enterTransition = enterTransition,
        exitTransition = exitTransition
    ) { navBackStackEntry ->

        val model = viewModel()
        val scope = rememberCoroutineScope()

        val action: (Action) -> Unit = {
            scope.launch {
                model.action(it)
            }
        }

        val state by model.state.collectAsState()
        content(state, model.effects, action)

        val keyboard = LocalSoftwareKeyboardController.current
        LaunchedEffect(Unit) {
            keyboard?.hide()
            initializer(navBackStackEntry, action)

            model.effects.cancellable().collect {
                effectHandler.handleEffect(it)
            }
        }

    }

}
