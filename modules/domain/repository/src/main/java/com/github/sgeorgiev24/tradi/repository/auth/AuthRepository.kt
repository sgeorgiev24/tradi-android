package com.github.sgeorgiev24.tradi.repository.auth

import com.github.sgeorgiev24.tradi.model.state.StateEvent
import com.github.sgeorgiev24.tradi.network.auth.AuthDataSource
import com.github.sgeorgiev24.tradi.repository.extensions.toDataState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class AuthRepository
@Inject
constructor(
    private val authDataSource: AuthDataSource
) {
    suspend fun signUp(
        event: StateEvent,
        email: String,
        password: String
    ) = authDataSource.signUp(email, password)
        .toDataState(event)
}