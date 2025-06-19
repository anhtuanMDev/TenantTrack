package com.example.tenanttrack.domain.usecase

import com.example.tenanttrack.R
import com.example.tenanttrack.domain.model.ValidateResult
import com.example.tenanttrack.domain.model.ValidateUIText
import com.example.tenanttrack.domain.repository.BaseValidateInterface
import com.example.tenanttrack.domain.utils.ValidateUtils

class ValidateNameUseCase(private val utils: ValidateUtils) :
    BaseValidateInterface<String, ValidateResult> {
    override fun execute(input: String): ValidateResult {
        if (input.isBlank()) {
            return ValidateResult(
                successful = false,
                errorMessage = ValidateUIText.StringResource(id = R.string.error_field_cant_be_blank)
            )
        }
        return ValidateResult(
            successful = true,
            errorMessage = null
        )
    }
}

class ValidateEmailUseCase(private val utils: ValidateUtils) :
    BaseValidateInterface<String, ValidateResult> {
    override fun execute(input: String): ValidateResult {
        if (input.isBlank()) {
            return ValidateResult(
                successful = false,
                errorMessage = ValidateUIText.StringResource(id = R.string.error_field_cant_be_blank)
            )
        }
        if (!utils.isEmailValid(input)) {
            return ValidateResult(
                successful = false,
                errorMessage = ValidateUIText.StringResource(id = R.string.error_invalid_email)
            )
        }
        return ValidateResult(
            successful = true,
            errorMessage = null
        )
    }
}

class ValidatePhoneUseCase(private val utils: ValidateUtils) :
    BaseValidateInterface<String, ValidateResult> {
    override fun execute(input: String): ValidateResult {
        if (input.length < 9) {
            return ValidateResult(
                successful = false,
                errorMessage = ValidateUIText.StringResource(
                    id = R.string.error_field_cant_be_blank,
                    9
                )
            )
        }
        if (!utils.isNumber(input)) {
            return ValidateResult(
                successful = false,
                errorMessage = ValidateUIText.StringResource(id = R.string.error_invalid_email)
            )
        }
        return ValidateResult(
            successful = true,
            errorMessage = null
        )
    }
}

class ValidateRoomNumber(private val utils: ValidateUtils) :
    BaseValidateInterface<String, ValidateResult> {
    override fun execute(input: String): ValidateResult {
        if (input.isBlank()) {
            return ValidateResult(
                successful = false,
                errorMessage = ValidateUIText.StringResource(id = R.string.error_field_cant_be_blank)
            )
        }
        if (!utils.isNumber(input)) {
            return ValidateResult(
                successful = false,
                errorMessage = ValidateUIText.StringResource(id = R.string.error_invalid_digit)
            )
        }
        if (input.toInt() < 0) {
            return ValidateResult(
                successful = false,
                errorMessage = ValidateUIText.StringResource(id = R.string.error_minimum_value, 0)
            )
        }

        return ValidateResult(
            successful = true,
            errorMessage = null
        )
    }
}
