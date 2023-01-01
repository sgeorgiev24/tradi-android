package com.github.sgeorgiev24.tradi.presentation.view.auth.signup.mvi

sealed class SignUpAction {
    object OnSignUpClick : SignUpAction()
    object OnNextActionClick : SignUpAction()
    object OnDoneActionClick : SignUpAction()
    object OnSignInLinkClick : SignUpAction()
    data class OnEmailValueChange(val value: String) : SignUpAction()
    data class OnNameValueChange(val value: String) : SignUpAction()
    data class OnPasswordValueChange(val value: String) : SignUpAction()
    data class OnConfirmPasswordValueChange(val value: String) : SignUpAction()
}