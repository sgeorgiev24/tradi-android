package com.github.sgeorgiev24.tradi.presentation.view.auth.signin.mvi

sealed class SignInAction {
    object OnSignInClick : SignInAction()
    object OnNextActionClick : SignInAction()
    object OnDoneActionClick : SignInAction()
    object OnSignUpLinkClick : SignInAction()
    data class OnEmailValueChange(val value: String) : SignInAction()
    data class OnPasswordValueChange(val value: String) : SignInAction()
}