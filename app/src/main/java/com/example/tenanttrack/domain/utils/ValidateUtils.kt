package com.example.tenanttrack.domain.utils

import android.util.Patterns

class ValidateUtils {
    fun isNumber(value: String): Boolean {
        return value.isNotBlank() && Regex("^\\d+$").matches(value)
    }

    fun isEmailValid(email: String): Boolean {
        return Patterns.EMAIL_ADDRESS.matcher(email).matches()
    }

    fun isPasswordValid(password: String): Boolean {
        return password.any { it.isDigit() } &&
                password.any { it.isLetter() }
    }
}