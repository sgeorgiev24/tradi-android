package com.github.sgeorgiev24.tradi.presentation.view.auth.loading.mvi

import androidx.lifecycle.SavedStateHandle
import com.github.sgeorgiev24.tradi.interactor.auth.AuthStateEvent
import com.github.sgeorgiev24.tradi.interactor.auth.GetUser
import com.github.sgeorgiev24.tradi.presentation.common.BaseViewModel
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationDispatcher
import com.github.sgeorgiev24.tradi.presentation.navigation.destinations.AuthDests
import com.github.sgeorgiev24.tradi.presentation.navigation.destinations.MainDests
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import javax.inject.Inject

@HiltViewModel
class AuthLoadingViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationDispatcher: NavigationDispatcher,
    private val getUser: GetUser
) : BaseViewModel<Unit, Unit, Unit>(
    savedStateHandle, Unit
) {
    suspend fun getUser() {
        getUser(AuthStateEvent.GetUser).also { dataState ->
            delay(1000)
            dataState.data?.let {
                navigationDispatcher.navigateTo(MainDests.Home)
            } ?: run {
                navigationDispatcher.navigateTo(AuthDests.SignIn)
            }
        }
    }
}