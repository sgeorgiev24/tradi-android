package com.github.sgeorgiev24.tradi.presentation.view.auth.signin.mvi

import androidx.lifecycle.SavedStateHandle
import com.github.sgeorgiev24.tradi.presentation.common.BaseViewModel
import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.InputWrapper
import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.ScreenEvent
import com.github.sgeorgiev24.tradi.presentation.common.util.validator.EmailValidator
import com.github.sgeorgiev24.tradi.presentation.common.util.validator.PasswordValidator
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationDispatcher
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SignInViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationDispatcher: NavigationDispatcher,
) : BaseViewModel<SignInState, SignInAction, ScreenEvent>(
    savedStateHandle, SignInState()
) {
    override suspend fun handleActions(action: SignInAction) {
        when (action) {
            SignInAction.OnDoneActionClick -> TODO()
            SignInAction.OnNextActionClick -> TODO()
            SignInAction.OnSignInClick -> TODO()
            is SignInAction.OnPasswordValueChange ->
                onPasswordValueChange(action.value)
            is SignInAction.OnEmailValueChange ->
                onEmailValueChange(action.value)
        }
    }

    private fun onEmailValueChange(value: String) {
        val errorResId = EmailValidator.getEmailErrorOrNull(value)
        updateState {
            copy(email = InputWrapper(value = value, errorResId = errorResId))
        }
    }

    private fun onPasswordValueChange(value: String) {
        val errorResId = PasswordValidator.getPasswordErrorOrNull(value)
        updateState {
            copy(password = InputWrapper(value = value, errorResId = errorResId))
        }
    }
}