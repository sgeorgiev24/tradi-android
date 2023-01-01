package com.github.sgeorgiev24.tradi.network.di

import com.github.sgeorgiev24.tradi.network.auth.AuthDataSource
import com.github.sgeorgiev24.tradi.network.auth.AuthDataSourceImpl
import com.google.firebase.auth.FirebaseAuth
import dagger.Module
import dagger.Provides
import dagger.hilt.InstallIn
import dagger.hilt.components.SingletonComponent
import javax.inject.Singleton

@Module
@InstallIn(SingletonComponent::class)
object NetworkModule {
    @Provides
    @Singleton
    fun provideAuthDataSource(
        firebaseAuth: FirebaseAuth
    ): AuthDataSource = AuthDataSourceImpl(firebaseAuth)

    @Singleton
    @Provides
    fun provideFirebaseAuth(): FirebaseAuth {
        return FirebaseAuth.getInstance()
    }
}