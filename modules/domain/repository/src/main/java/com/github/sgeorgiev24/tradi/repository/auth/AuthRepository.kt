package com.github.sgeorgiev24.tradi.repository.auth

import com.github.sgeorgiev24.tradi.model.state.StateEvent
import com.github.sgeorgiev24.tradi.model.state.map
import com.github.sgeorgiev24.tradi.network.auth.AuthDataSource
import com.github.sgeorgiev24.tradi.repository.auth.mapper.toDomain
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
        name: String,
        password: String
    ) = authDataSource.signUp(email, name, password)
        .toDataState(event)

    suspend fun signIn(
        event: StateEvent,
        email: String,
        password: String
    ) = authDataSource.signIn(email, password)
        .toDataState(event)

    suspend fun getUser(
        event: StateEvent
    ) = authDataSource.getUser()
        .toDataState(event)
        .map { it?.toDomain() }
}