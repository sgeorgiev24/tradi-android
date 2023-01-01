package com.github.sgeorgiev24.tradi.interactor.auth

import com.github.sgeorgiev24.tradi.model.state.StateEvent

sealed class AuthStateEvent : StateEvent {
    class SignUp(
        val email: String,
        val name: String,
        val password: String
    ) : AuthStateEvent() {
        override fun errorInfo() = "Error while trying to sign up."
        override fun eventName() = "SignUp"
        override fun shouldDisplayProgressBar() = true
    }

    class SignIn(
        val email: String,
        val password: String
    ) : AuthStateEvent() {
        override fun errorInfo() = "Error while trying to sign in."
        override fun eventName() = "SignIn"
        override fun shouldDisplayProgressBar() = true
    }

    object GetUser : AuthStateEvent() {
        override fun errorInfo() = "Error while trying to get the user."
        override fun eventName() = "GetUser"
        override fun shouldDisplayProgressBar() = true
    }
}