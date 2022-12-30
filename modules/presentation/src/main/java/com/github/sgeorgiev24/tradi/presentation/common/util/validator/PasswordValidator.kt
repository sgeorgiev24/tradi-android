package com.github.sgeorgiev24.tradi.presentation.common.util.validator

import com.github.sgeorgiev24.tradi.presentation.R

object PasswordValidator {
    fun getPasswordErrorOrNull(input: String): Int? {
        return when {
            input.length < PASSWORD_MIN_LENGTH -> R.string.validator_password_too_short
            else -> null
        }
    }

    fun getConfirmPasswordErrorOrNull(input: String, password: String): Int? {
        return when {
            input != password -> R.string.validator_passwords_do_not_match
            input.length < PASSWORD_MIN_LENGTH -> R.string.validator_password_too_short
            else -> null
        }
    }

    const val PASSWORD_MIN_LENGTH = 6
}