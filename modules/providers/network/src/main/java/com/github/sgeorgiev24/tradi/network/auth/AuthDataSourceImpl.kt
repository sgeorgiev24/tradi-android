package com.github.sgeorgiev24.tradi.network.auth

import com.github.sgeorgiev24.tradi.network.auth.util.NetworkResult
import com.google.firebase.auth.FirebaseAuth
import kotlin.coroutines.suspendCoroutine

class AuthDataSourceImpl : AuthDataSource {

    private val auth = FirebaseAuth.getInstance()

    override suspend fun signUp(email: String, password: String) =
        suspendCoroutine { continuation ->
            auth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        continuation.resumeWith(Result.success(NetworkResult.Success(Unit)))
                    } else {
                        continuation.resumeWith(Result.success(NetworkResult.Error(message = task.exception?.message)))
                    }
                }
        }
}