@file:OptIn(ExperimentalMaterialApi::class)
package com.github.sgeorgiev24.tradi.ui.router

import androidx.compose.animation.core.AnimationSpec
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.statusBarsPadding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.unit.dp
import androidx.navigation.NavGraphBuilder
import androidx.navigation.plusAssign
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationCommand
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationDispatcher
import com.github.sgeorgiev24.tradi.presentation.navigation.destinations.AuthDests
import com.github.sgeorgiev24.tradi.presentation.navigation.wrapper.composableHolder
import com.github.sgeorgiev24.tradi.presentation.view.auth.signup.SignUpScreen
import com.github.sgeorgiev24.tradi.ui.theme.TradiTheme
import com.google.accompanist.navigation.animation.AnimatedNavHost
import com.google.accompanist.navigation.animation.rememberAnimatedNavController
import com.google.accompanist.navigation.material.BottomSheetNavigator
import com.google.accompanist.navigation.material.ModalBottomSheetLayout
import kotlinx.coroutines.flow.collectLatest

@Composable
fun AppRouter(
    navigationDispatcher: NavigationDispatcher
) {
    val navController = rememberAnimatedNavController()
    val bottomSheetNavigator = rememberFullScreenBottomSheetNavigator()
    navController.navigatorProvider += bottomSheetNavigator

    val scaffoldState = rememberScaffoldState()

    LaunchedEffect(key1 = Unit) {
        navigationDispatcher.navigationCommands.collectLatest { navigationCommand ->
            when (navigationCommand) {
                NavigationCommand.Back -> navController.popBackStack()
                is NavigationCommand.Navigate -> {
                    navController.navigate(
                        route = navigationCommand.navAction.route,
                        navOptions = navigationCommand.navAction.navOptions
                    )
                }
                is NavigationCommand.PopToDestination -> {
                    navController.popBackStack(navigationCommand.route, navigationCommand.inclusive)
                }
            }
        }
    }

    TradiTheme {
        ModalBottomSheetLayout(
            bottomSheetNavigator = bottomSheetNavigator,
            sheetShape = RoundedCornerShape(topStart = 20.dp, topEnd = 20.dp)
        ) {
            Scaffold(
                scaffoldState = scaffoldState,
                modifier = Modifier
                    .statusBarsPadding(),
                content = { padding ->
                    AnimatedNavHost(
                        modifier = Modifier.padding(padding),
                        navController = navController,
                        startDestination = AuthDests.SignUp().route // TODO change this
                    ) {
                        authDestinations()
                    }
                },
                drawerShape = RectangleShape,
            )
        }
    }
}

private fun NavGraphBuilder.authDestinations() {
    composableHolder(AuthDests.SignUp()) {
        SignUpScreen()
    }
}

@Composable
fun rememberFullScreenBottomSheetNavigator(
    animationSpec: AnimationSpec<Float> = SwipeableDefaults.AnimationSpec,
    skipHalfExpanded: Boolean = true,
): BottomSheetNavigator {
    val sheetState = rememberModalBottomSheetState(
        ModalBottomSheetValue.Hidden,
        animationSpec
    )

    if (skipHalfExpanded) {
        LaunchedEffect(sheetState) {
            snapshotFlow { sheetState.isAnimationRunning }
                .collectLatest {
                    with(sheetState) {
                        val isOpening = currentValue == ModalBottomSheetValue.Hidden && targetValue == ModalBottomSheetValue.HalfExpanded
                        val isClosing = currentValue == ModalBottomSheetValue.Expanded && targetValue == ModalBottomSheetValue.HalfExpanded
                        when {
                            isOpening -> animateTo(ModalBottomSheetValue.Expanded)
                            isClosing -> animateTo(ModalBottomSheetValue.Hidden)
                        }
                    }
                }
        }
    }

    return remember(sheetState) {
        BottomSheetNavigator(sheetState = sheetState)
    }
}