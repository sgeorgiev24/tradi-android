package com.github.sgeorgiev24.tradi.model.state

abstract class StateEventImpl : StateEvent {

    override fun eventName(): String {
        return javaClass.simpleName
    }
}