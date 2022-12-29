package com.github.sgeorgiev24.tradi.presentation.view.auth.signup.mvi

import com.github.sgeorgiev24.tradi.presentation.common.components.textfield.InputWrapper

data class SignUpState(
    val email: InputWrapper = InputWrapper(),
    val password: InputWrapper = InputWrapper(),
    val confirmPassword: InputWrapper = InputWrapper()
) {
    val isRegisterButtonEnabled: Boolean
        get() = email.isValid &&
            password.isValid &&
            confirmPassword.isValid &&
            password.value == confirmPassword.value
}