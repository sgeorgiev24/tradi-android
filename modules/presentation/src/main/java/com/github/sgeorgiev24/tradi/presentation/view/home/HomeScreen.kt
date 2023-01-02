package com.github.sgeorgiev24.tradi.presentation.view.home

import android.app.Activity
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.platform.LocalContext
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.sgeorgiev24.tradi.presentation.common.RootScreen
import com.github.sgeorgiev24.tradi.presentation.common.components.util.TradiBackPressHandler
import com.github.sgeorgiev24.tradi.presentation.view.home.mvi.HomeViewModel

@Composable
fun HomeScreen() {
    val viewModel = hiltViewModel<HomeViewModel>()
    val state by viewModel.state.collectAsState()
    val activity = LocalContext.current as Activity

    TradiBackPressHandler(
        onBackPressed = {
            activity.finish()
        }
    )

    RootScreen(
        viewModel = viewModel,
        content = {
            HomeContent(
                state = state,
                action = { viewModel.submitAction(it) }
            )
        }
    )
}