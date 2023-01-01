package com.github.sgeorgiev24.tradi.presentation.view.auth.loading

import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.rememberCoroutineScope
import androidx.hilt.navigation.compose.hiltViewModel
import com.github.sgeorgiev24.tradi.presentation.view.auth.loading.mvi.AuthLoadingViewModel
import kotlinx.coroutines.launch

@Composable
fun AuthLoadingScreen() {
    val viewModel = hiltViewModel<AuthLoadingViewModel>()
    val coroutineScope = rememberCoroutineScope()

    LaunchedEffect(Unit) {
        coroutineScope.launch {
            viewModel.getUser()
        }
    }

    AuthLoadingContent()
}