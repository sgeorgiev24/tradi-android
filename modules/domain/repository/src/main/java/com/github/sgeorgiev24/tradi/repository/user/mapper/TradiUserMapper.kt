package com.github.sgeorgiev24.tradi.repository.auth.mapper

import com.github.sgeorgiev24.tradi.cache.user.model.TradiUserEntity
import com.github.sgeorgiev24.tradi.model.auth.TradiUser
import com.github.sgeorgiev24.tradi.network.auth.model.TradiUserDto

fun TradiUserDto.toDomain() = TradiUser(
    email = email,
    name = name
)

fun TradiUserEntity.toDomain() = TradiUser(
    email = email,
    name = name
)

fun TradiUser.toEntity() = TradiUserEntity(
    email = email,
    name = name
)