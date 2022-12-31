package com.github.sgeorgiev24.tradi.interactor.auth

import com.github.sgeorgiev24.tradi.repository.auth.AuthRepository
import javax.inject.Inject

class SignUp
@Inject
constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        stateEvent: AuthStateEvent.SignUp
    ) = authRepository.signUp(
        event = stateEvent,
        email = stateEvent.email,
        password = stateEvent.password
    )
}