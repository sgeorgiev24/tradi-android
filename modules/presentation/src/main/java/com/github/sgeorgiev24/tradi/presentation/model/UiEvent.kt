package com.github.sgeorgiev24.tradi.presentation.model

import androidx.annotation.StringRes

data class UiEvent(
    val message: String,
    @StringRes
    val messageRes: Int? = null,
    val componentType: ComponentType,
)
