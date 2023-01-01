package com.github.sgeorgiev24.tradi.presentation.view.auth.loading.mvi

import androidx.lifecycle.SavedStateHandle
import com.github.sgeorgiev24.tradi.interactor.auth.AuthStateEvent
import com.github.sgeorgiev24.tradi.interactor.auth.GetUser
import com.github.sgeorgiev24.tradi.interactor.user.SetTmpUser
import com.github.sgeorgiev24.tradi.interactor.user.UserStateEvent
import com.github.sgeorgiev24.tradi.presentation.common.BaseViewModel
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationDispatcher
import com.github.sgeorgiev24.tradi.presentation.navigation.destinations.AuthDests
import com.github.sgeorgiev24.tradi.presentation.navigation.destinations.MainDests
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.delay
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class AuthLoadingViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationDispatcher: NavigationDispatcher,
    private val getUser: GetUser,
    private val setTmpUser: SetTmpUser
) : BaseViewModel<Unit, Unit, Unit>(
    savedStateHandle, Unit
) {
    suspend fun getUser() {
        getUser(AuthStateEvent.GetUser).also { dataState ->
            delay(1000)
            dataState.data?.let {
                setTmpUser(
                    email = it.email,
                    name = it.name
                )
                navigationDispatcher.navigateTo(MainDests.Home)
            } ?: run {
                navigationDispatcher.navigateTo(AuthDests.SignIn)
            }
        }
    }

    private suspend fun setTmpUser(email: String?, name: String?) {
        val event = UserStateEvent.SetTmpUser(email, name)
        setTmpUser(event).also { dataState ->
            dataState.data?.let {
                Timber.i("Successfully saved the user.")
            } ?: run {
                Timber.i("Failed to save the user.")
            }
        }
    }
}