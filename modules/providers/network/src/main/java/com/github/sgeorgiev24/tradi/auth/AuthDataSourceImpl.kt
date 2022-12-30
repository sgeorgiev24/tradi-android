package com.github.sgeorgiev24.tradi.auth

import com.github.sgeorgiev24.tradi.util.NetworkResult
import com.google.firebase.auth.FirebaseAuth

class AuthDataSourceImpl : AuthDataSource {

    private val auth = FirebaseAuth.getInstance()

    override suspend fun signUp(email: String, password: String): NetworkResult<Unit> {
        var networkResult: NetworkResult<Unit> = NetworkResult.Success(Unit)

        auth.createUserWithEmailAndPassword(email, password)
            .addOnCompleteListener { task ->
                if (task.isSuccessful) {
                    networkResult = NetworkResult.Success(Unit)
                } else {
                    networkResult = NetworkResult.Error(message = task.exception?.message)
                }
            }

        return networkResult
    }
}