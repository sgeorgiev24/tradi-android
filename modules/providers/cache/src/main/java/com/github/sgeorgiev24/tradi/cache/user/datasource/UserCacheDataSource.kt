package com.github.sgeorgiev24.tradi.cache.user.datasource

import com.github.sgeorgiev24.tradi.cache.user.model.TradiUserEntity
import com.github.sgeorgiev24.tradi.cache.util.CacheResult

interface UserCacheDataSource {
    suspend fun set(userEntity: TradiUserEntity): CacheResult<Unit>

    suspend fun get(): CacheResult<TradiUserEntity?>

    suspend fun clear(): CacheResult<Unit>
}