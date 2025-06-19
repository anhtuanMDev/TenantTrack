package com.example.tenanttrack.domain.model

import android.content.Context
import androidx.annotation.StringRes
import androidx.compose.runtime.Composable
import androidx.compose.ui.res.stringResource

sealed class ValidateUIText {
    data class DynamicString(val value: String): ValidateUIText()
    class StringResource(@StringRes val id: Int, vararg val args: Any): ValidateUIText()

    @Composable
    fun asString(): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> stringResource(id, *args)
        }
    }

    fun asString(context: Context): String {
        return when (this) {
            is DynamicString -> value
            is StringResource -> context.getString(id, *args)
        }
    }
}
