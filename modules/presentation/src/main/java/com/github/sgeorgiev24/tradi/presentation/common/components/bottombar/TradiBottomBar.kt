package com.github.sgeorgiev24.tradi.presentation.common.components.bottombar

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavBackStackEntry
import com.github.sgeorgiev24.tradi.presentation.common.components.bottombar.mvi.BottomNavigationViewModel

@Composable
fun TradiBottomBar(
    navBackStackEntry: NavBackStackEntry
) {
    val viewModel = hiltViewModel<BottomNavigationViewModel>()
    val state by viewModel.state.collectAsState()

    TradiBottomBarContent(
        state = state,
        action = viewModel.submitAction,
        navBackStackEntry = navBackStackEntry
    )
}