package com.github.sgeorgiev24.tradi.presentation.view.auth.signin.mvi

import androidx.lifecycle.SavedStateHandle
import com.github.sgeorgiev24.tradi.interactor.auth.AuthStateEvent
import com.github.sgeorgiev24.tradi.interactor.auth.SignIn
import com.github.sgeorgiev24.tradi.presentation.R
import com.github.sgeorgiev24.tradi.presentation.common.BaseViewModel
import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.InputWrapper
import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.ScreenEvent
import com.github.sgeorgiev24.tradi.presentation.common.util.validator.EmailValidator
import com.github.sgeorgiev24.tradi.presentation.common.util.validator.PasswordValidator
import com.github.sgeorgiev24.tradi.presentation.model.ComponentType
import com.github.sgeorgiev24.tradi.presentation.model.UiEvent
import com.github.sgeorgiev24.tradi.presentation.navigation.NavigationDispatcher
import com.github.sgeorgiev24.tradi.presentation.navigation.destinations.AuthDests
import com.github.sgeorgiev24.tradi.presentation.navigation.destinations.MainDests
import dagger.hilt.android.lifecycle.HiltViewModel
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class SignInViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationDispatcher: NavigationDispatcher,
    private val signIn: SignIn
) : BaseViewModel<SignInState, SignInAction, ScreenEvent>(
    savedStateHandle, SignInState()
) {
    override suspend fun handleActions(action: SignInAction) {
        when (action) {
            SignInAction.OnDoneActionClick ->
                submitEvent(ScreenEvent.ClearFocus)
            SignInAction.OnNextActionClick ->
                submitEvent(ScreenEvent.MoveFocus())
            SignInAction.OnSignInClick ->
                onSignInClick()
            SignInAction.OnSignUpLinkClick ->
                navigationDispatcher.navigateTo(AuthDests.SignUp)
            is SignInAction.OnPasswordValueChange ->
                onPasswordValueChange(action.value)
            is SignInAction.OnEmailValueChange ->
                onEmailValueChange(action.value)
        }
    }

    private suspend fun onSignInClick() {
        submitEvent(ScreenEvent.ClearFocus)
        val event = AuthStateEvent.SignIn(
            email = state.value.email.value,
            password = state.value.password.value
        )
        if (canExecuteNewStateEvent(event)) {
            addStateEvent(event)
            signIn(event).also { dataState ->
                dataState.data?.let {
                    Timber.i("Successfully signed in.")
                    navigationDispatcher.navigateTo(MainDests.Home)
                } ?: run {
                    buildSignInFailMessage(dataState.response?.message)
                    Timber.e("Failed to sign in.")
                }
                dataState.stateEvent?.let { removeStateEvent(it) }
            }
        }
    }

    private fun buildSignInFailMessage(message: String?) =
        handleNewUiEvent(
            UiEvent(
                message = "Failed to sign in.",
                messageResId = R.string.ui_failed_to_sign_in,
                componentType = ComponentType.SnackBar()
            )
        )

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