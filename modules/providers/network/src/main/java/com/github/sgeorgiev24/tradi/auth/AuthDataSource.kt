package com.github.sgeorgiev24.tradi.auth

import com.github.sgeorgiev24.tradi.util.NetworkResult

interface AuthDataSource {
    suspend fun signUp(
        email: String,
        password: String
    ): NetworkResult<Unit>
}