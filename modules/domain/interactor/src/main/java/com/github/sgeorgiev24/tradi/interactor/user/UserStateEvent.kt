package com.github.sgeorgiev24.tradi.interactor.user

import com.github.sgeorgiev24.tradi.model.state.StateEvent

sealed class UserStateEvent : StateEvent {
    class SetTmpUser(
        val email: String?,
        val name: String?
    ) : UserStateEvent() {
        override fun errorInfo() = "Error while trying to save the user in cache."
        override fun eventName() = "SetTmpUser"
        override fun shouldDisplayProgressBar() = true
    }
}
