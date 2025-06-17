package com.example.tenanttrack.domain.model

data class ValidateResult(
    val successful: Boolean,
    val errorMessage: ValidateUIText? = null
)
