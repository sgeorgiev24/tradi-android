package com.github.sgeorgiev24.tradi.presentation.view.auth.signup.mvi

sealed class SignUpAction {
    object OnRegisterClick : SignUpAction()
    object OnNextActionClick : SignUpAction()
    object OnDoneActionClick : SignUpAction()
}