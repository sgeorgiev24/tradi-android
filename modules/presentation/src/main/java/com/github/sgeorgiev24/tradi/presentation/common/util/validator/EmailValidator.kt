package com.github.sgeorgiev24.tradi.presentation.common.util.validator

import android.util.Patterns
import com.github.sgeorgiev24.tradi.presentation.R

object EmailValidator {
    fun getEmailErrorOrNull(input: String): Int? {
        return when {
            input.isEmpty() -> R.string.validator_email_is_empty
            !Patterns.EMAIL_ADDRESS.matcher(input).matches() -> R.string.validator_email_is_invalid
            else -> null
        }
    }
}