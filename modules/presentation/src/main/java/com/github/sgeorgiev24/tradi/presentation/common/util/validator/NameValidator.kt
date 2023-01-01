package com.github.sgeorgiev24.tradi.presentation.common.util.validator

import com.github.sgeorgiev24.tradi.presentation.R

object NameValidator {
    fun getNameErrorOrNull(input: String): Int? {
        return when {
            input.isEmpty() -> R.string.validator_name_is_empty
            else -> null
        }
    }
}