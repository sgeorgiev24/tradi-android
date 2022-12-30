package com.github.sgeorgiev24.tradi.network.auth

import com.github.sgeorgiev24.tradi.network.auth.util.NetworkResult

interface AuthDataSource {
    suspend fun signUp(
        email: String,
        password: String
    ): NetworkResult<Unit>
}