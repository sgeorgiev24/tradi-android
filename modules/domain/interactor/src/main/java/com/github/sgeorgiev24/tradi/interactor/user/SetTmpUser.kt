package com.github.sgeorgiev24.tradi.interactor.user

import com.github.sgeorgiev24.tradi.model.auth.TradiUser
import com.github.sgeorgiev24.tradi.repository.user.UserRepository
import javax.inject.Inject

class SetTmpUser
@Inject
constructor(
    private val userRepository: UserRepository
) {
    suspend operator fun invoke(
        stateEvent: UserStateEvent.SetTmpUser
    ) = userRepository.setTmpUser(
        event = stateEvent,
        user = getTradiUser(stateEvent.email, stateEvent.name)
    )

    private fun getTradiUser(email: String?, name: String?) = TradiUser(
        email = email,
        name = name
    )
}