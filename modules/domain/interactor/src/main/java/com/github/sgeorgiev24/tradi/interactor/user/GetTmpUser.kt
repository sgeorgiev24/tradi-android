package com.github.sgeorgiev24.tradi.interactor.user

import com.github.sgeorgiev24.tradi.repository.user.UserRepository
import javax.inject.Inject

class GetTmpUser
@Inject
constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(
        stateEvent: UserStateEvent.GetTmpUser
    ) = userRepository.getTmpUser(stateEvent)
}