package com.github.sgeorgiev24.tradi.network.auth

import com.github.sgeorgiev24.tradi.network.auth.model.toUserDto
import com.github.sgeorgiev24.tradi.network.util.NetworkResult
import com.google.firebase.auth.FirebaseAuth
import javax.inject.Inject
import kotlin.coroutines.suspendCoroutine

class AuthDataSourceImpl
@Inject constructor(
    private val firebaseAuth: FirebaseAuth
) : AuthDataSource {

    override suspend fun signUp(email: String, password: String) =
        suspendCoroutine { continuation ->
            firebaseAuth.createUserWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        continuation.resumeWith(Result.success(NetworkResult.Success(Unit)))
                    } else {
                        continuation.resumeWith(Result.success(NetworkResult.Error(message = task.exception?.message)))
                    }
                }
        }

    override suspend fun signIn(email: String, password: String) =
        suspendCoroutine { continuation ->
            firebaseAuth.signInWithEmailAndPassword(email, password)
                .addOnCompleteListener { task ->
                    if (task.isSuccessful) {
                        continuation.resumeWith(Result.success(NetworkResult.Success(Unit)))
                    } else {
                        continuation.resumeWith(Result.success(NetworkResult.Error(message = task.exception?.message)))
                    }
                }
        }

    override suspend fun getUser() =
        suspendCoroutine { continuation ->
            firebaseAuth.currentUser?.let {
                continuation.resumeWith(Result.success(NetworkResult.Success(it.toUserDto())))
            } ?: run {
                continuation.resumeWith(Result.success(NetworkResult.Success(null)))
            }
        }
}