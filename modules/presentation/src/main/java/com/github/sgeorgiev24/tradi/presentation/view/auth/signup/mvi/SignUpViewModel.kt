package com.github.sgeorgiev24.tradi.presentation.view.auth.signup.mvi

import androidx.lifecycle.SavedStateHandle
import com.github.sgeorgiev24.tradi.presentation.common.BaseViewModel
import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.ScreenEvent
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignUpViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationDispatcher: NavigationDispatcher
) : BaseViewModel<SignUpState, SignUpAction, ScreenEvent>(
    savedStateHandle, SignUpState()
) {
    override suspend fun handleActions(action: SignUpAction) {
        when (action) {
            SignUpAction.OnDoneActionClick -> {}
            SignUpAction.OnNextActionClick -> {}
            SignUpAction.OnRegisterClick -> {}
        }
    }
}