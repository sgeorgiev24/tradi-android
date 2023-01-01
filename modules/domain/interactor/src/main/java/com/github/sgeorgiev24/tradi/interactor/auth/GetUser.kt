package com.github.sgeorgiev24.tradi.interactor.auth

import com.github.sgeorgiev24.tradi.repository.auth.AuthRepository
import javax.inject.Inject

class GetUser
@Inject
constructor(
    private val authRepository: AuthRepository
) {
    suspend operator fun invoke(
        stateEvent: AuthStateEvent.GetUser
    ) = authRepository.getUser(event = stateEvent)
}