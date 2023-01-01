package com.github.sgeorgiev24.tradi.presentation.view.auth.signin.mvi

import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.InputWrapper

data class SignInState(
    val email: InputWrapper = InputWrapper(),
    val password: InputWrapper = InputWrapper(),
) {
    val isSignInButtonEnabled: Boolean
        get() = email.isValid && password.isValid
}