package com.github.sgeorgiev24.tradi.network.auth.di

import com.github.sgeorgiev24.tradi.network.auth.AuthDataSource
import com.github.sgeorgiev24.tradi.network.auth.AuthDataSourceImpl
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
    fun provideAuthDataSource(): AuthDataSource = AuthDataSourceImpl()
}