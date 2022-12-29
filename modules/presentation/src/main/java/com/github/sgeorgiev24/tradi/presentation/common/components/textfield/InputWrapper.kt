package com.github.sgeorgiev24.tradi.presentation.common.components.textfield

import androidx.annotation.StringRes

data class InputWrapper(
    val value: String = "",
    @StringRes
    val errorId: Int? = null
) {
    val isValid: Boolean
        get() = value.isNotBlank() && errorId == null
}