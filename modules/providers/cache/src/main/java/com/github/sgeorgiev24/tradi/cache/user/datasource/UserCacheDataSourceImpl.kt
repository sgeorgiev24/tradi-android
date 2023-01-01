package com.github.sgeorgiev24.tradi.cache.user.datasource

import com.github.sgeorgiev24.tradi.cache.user.model.TradiUserEntity
import com.github.sgeorgiev24.tradi.cache.util.CacheResult

class UserCacheDataSourceImpl : UserCacheDataSource {

    private var user: TradiUserEntity? = null

    override suspend fun set(userEntity: TradiUserEntity): CacheResult<Unit> {
        user = userEntity
        return CacheResult.Success(Unit)
    }

    override suspend fun get() = CacheResult.Success(user)

    override suspend fun clear(): CacheResult<Unit> {
        user = null
        return CacheResult.Success(Unit)
    }
}