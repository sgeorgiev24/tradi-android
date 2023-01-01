package com.github.sgeorgiev24.tradi.repository.user

import com.github.sgeorgiev24.tradi.cache.user.datasource.UserCacheDataSource
import com.github.sgeorgiev24.tradi.model.auth.TradiUser
import com.github.sgeorgiev24.tradi.model.state.StateEvent
import com.github.sgeorgiev24.tradi.repository.auth.mapper.toDomain
import com.github.sgeorgiev24.tradi.repository.auth.mapper.toEntity
import com.github.sgeorgiev24.tradi.repository.extensions.toDataState
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class UserRepository
@Inject
constructor(
    private val userCacheDataSource: UserCacheDataSource
) {
    suspend fun getTmpUser(event: StateEvent) =
        userCacheDataSource.get().toDataState(event) { it?.toDomain() }

    suspend fun setTmpUser(
        event: StateEvent,
        user: TradiUser
    ) = userCacheDataSource.set(user.toEntity()).toDataState(event)

    suspend fun clearTmpUser(event: StateEvent) =
        userCacheDataSource.clear().toDataState(event)
}