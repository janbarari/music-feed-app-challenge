package com.doublesymmetry.musicapp.feed.impl.navigation

import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavGraphBuilder
import androidx.navigation.NavHostController
import com.doublesymmetry.musicapp.architecture.EffectHandler
import com.doublesymmetry.musicapp.feed.api.FeedEntry
import com.doublesymmetry.musicapp.feed.api.seam.FeedAction
import com.doublesymmetry.musicapp.feed.api.seam.FeedEffect
import com.doublesymmetry.musicapp.feed.api.seam.FeedState
import com.doublesymmetry.musicapp.feed.impl.seam.FeedEffectHandler
import com.doublesymmetry.musicapp.feed.impl.view.FeedScreen
import com.doublesymmetry.musicapp.feed.impl.view.FeedViewModel
import com.doublesymmetry.musicapp.navigation.FeatureEntry
import kotlinx.coroutines.flow.Flow
import javax.inject.Inject

class FeedEntryImpl @Inject constructor() : FeedEntry<FeedViewModel>() {

    override fun getEffectHandler(): EffectHandler<FeedEffect> {
        return FeedEffectHandler()
    }

    override fun getInitializer(backStackEntry: NavBackStackEntry, action: (FeedAction) -> Unit) {
        action(FeedAction.Load(0))
    }

    @Composable
    override fun NavGraphBuilder.Composable(
        navController: NavHostController,
        destinations: Map<Class<out FeatureEntry>, FeatureEntry>,
        backStackEntry: NavBackStackEntry,
        state: FeedState,
        effect: Flow<FeedEffect>,
        action: (FeedAction) -> Unit
    ) {
        FeedScreen(
            state = state,
            effect = effect,
            action = action
        )
    }

}
