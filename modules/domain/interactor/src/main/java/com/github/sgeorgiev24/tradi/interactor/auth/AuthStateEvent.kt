package com.github.sgeorgiev24.tradi.interactor.auth

import com.github.sgeorgiev24.tradi.model.state.StateEvent

sealed class AuthStateEvent : StateEvent {
    class SignUp(
        val email: String,
        val password: String
    ) : AuthStateEvent() {
        override fun errorInfo() = "Error while trying to sign up."
        override fun eventName() = "SignUp"
        override fun shouldDisplayProgressBar() = true
    }
}