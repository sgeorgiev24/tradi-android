package com.github.sgeorgiev24.tradi.network.auth.model

import com.google.firebase.auth.FirebaseUser

fun FirebaseUser.toUserDto() = TradiUserDto(
    email = email,
    name = displayName
)