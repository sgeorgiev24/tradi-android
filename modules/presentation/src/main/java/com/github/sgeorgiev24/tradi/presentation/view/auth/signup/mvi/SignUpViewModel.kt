package com.github.sgeorgiev24.tradi.presentation.view.auth.signup.mvi

import androidx.lifecycle.SavedStateHandle
import com.github.sgeorgiev24.tradi.interactor.auth.AuthStateEvent
import com.github.sgeorgiev24.tradi.interactor.auth.SignUp
import com.github.sgeorgiev24.tradi.presentation.common.BaseViewModel
import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.InputWrapper
import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.ScreenEvent
import com.github.sgeorgiev24.tradi.presentation.common.util.validator.EmailValidator
import com.github.sgeorgiev24.tradi.presentation.common.util.validator.NameValidator
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
class SignUpViewModel
@Inject
constructor(
    savedStateHandle: SavedStateHandle,
    private val navigationDispatcher: NavigationDispatcher,
    private val signUp: SignUp
) : BaseViewModel<SignUpState, SignUpAction, ScreenEvent>(
    savedStateHandle, SignUpState()
) {
    override suspend fun handleActions(action: SignUpAction) {
        when (action) {
            SignUpAction.OnDoneActionClick ->
                submitEvent(ScreenEvent.ClearFocus)
            SignUpAction.OnNextActionClick ->
                submitEvent(ScreenEvent.MoveFocus())
            SignUpAction.OnSignUpClick ->
                onSignUpClick()
            SignUpAction.OnSignInLinkClick ->
                navigationDispatcher.navigateTo(AuthDests.SignIn)
            is SignUpAction.OnEmailValueChange ->
                onEmailValueChange(action.value)
            is SignUpAction.OnPasswordValueChange ->
                onPasswordValueChange(action.value)
            is SignUpAction.OnConfirmPasswordValueChange ->
                onConfirmPasswordValueChange(action.value)
            is SignUpAction.OnNameValueChange ->
                onNameValueChange(action.value)
        }
    }

    private suspend fun onSignUpClick() {
        val event = AuthStateEvent.SignUp(
            email = state.value.email.value,
            name = state.value.name.value,
            password = state.value.password.value
        )
        if (canExecuteNewStateEvent(event)) {
            addStateEvent(event)
            signUp(event).also { dataState ->
                dataState.data?.let {
                    Timber.i("Successfully signed up.")
                    navigationDispatcher.navigateTo(MainDests.Home)
                } ?: run {
                    buildSignUpFailMessage(dataState.response?.message)
                    Timber.e("Failed to sign up.")
                }
                dataState.stateEvent?.let { removeStateEvent(it) }
            }
        }
    }

    private fun buildSignUpFailMessage(message: String?) =
        handleNewUiEvent(
            UiEvent(
                message = message ?: "Failed to sign up.",
                componentType = ComponentType.SnackBar()
            )
        )

    private fun onEmailValueChange(value: String) {
        val errorResId = EmailValidator.getEmailErrorOrNull(value)
        updateState {
            copy(email = InputWrapper(value = value, errorResId = errorResId))
        }
    }

    private fun onNameValueChange(value: String) {
        val errorResId = NameValidator.getNameErrorOrNull(value)
        updateState {
            copy(name = InputWrapper(value = value, errorResId = errorResId))
        }
    }

    private fun onPasswordValueChange(value: String) {
        val errorResId = PasswordValidator.getPasswordErrorOrNull(value)
        updateState {
            copy(password = InputWrapper(value = value, errorResId = errorResId))
        }
    }

    private fun onConfirmPasswordValueChange(value: String) {
        val errorResId = PasswordValidator.getConfirmPasswordErrorOrNull(
            input = value,
            password = state.value.password.value
        )
        updateState {
            copy(confirmPassword = InputWrapper(value = value, errorResId = errorResId))
        }
    }
}