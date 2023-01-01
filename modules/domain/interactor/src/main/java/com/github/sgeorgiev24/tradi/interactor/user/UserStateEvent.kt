package com.github.sgeorgiev24.tradi.interactor.user

import com.github.sgeorgiev24.tradi.model.state.StateEvent

sealed class UserStateEvent : StateEvent {
    class SetTmpUser(
        val email: String?,
        val name: String?
    ) : UserStateEvent() {
        override fun errorInfo() = "Error while trying to sign up."
        override fun eventName() = "SetTmpUser"
        override fun shouldDisplayProgressBar() = true
    }
}
