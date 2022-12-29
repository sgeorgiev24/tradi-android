package com.github.sgeorgiev24.tradi.presentation.view.auth.signup

import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import com.github.sgeorgiev24.tradi.presentation.view.auth.signup.mvi.SignUpAction
import com.github.sgeorgiev24.tradi.presentation.view.auth.signup.mvi.SignUpState

@Composable
fun SignUpContent(
    state: SignUpState,
    action: (SignUpAction) -> Unit
) {
    Text(text = "Sign up screen")
}