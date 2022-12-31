package com.github.sgeorgiev24.tradi.network.auth

import com.github.sgeorgiev24.tradi.network.util.NetworkResult

interface AuthDataSource {
    suspend fun signUp(
        email: String,
        password: String
    ): NetworkResult<Unit>

    suspend fun signIn(
        email: String,
        password: String
    ): NetworkResult<Unit>
}