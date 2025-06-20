package com.example.tenanttrack.presentation.viewmodel

import android.util.Log
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import androidx.lifecycle.ViewModel
import com.example.tenanttrack.domain.model.PropertyFormEvent
import com.example.tenanttrack.domain.model.PropertyFormState
import com.example.tenanttrack.domain.usecase.ValidateNameUseCase
import com.example.tenanttrack.domain.usecase.ValidateRoomNumber
import com.example.tenanttrack.domain.utils.ValidateUtils

class PropertyFormViewModel: ViewModel() {
    private val utils = ValidateUtils()
    private val validateBaseUseCase = ValidateNameUseCase(utils)
    private val validateRoomNumberUseCase = ValidateRoomNumber(utils)
    val onSubmit = {}
    var state by mutableStateOf(PropertyFormState())

    fun onEvent(event: PropertyFormEvent) {
        when (event) {
            is PropertyFormEvent.NameChanged -> {
                state = state.copy(name = event.value)
                validateName()
            }

            is PropertyFormEvent.AddressChanged -> {
                state = state.copy(address = event.value)
                validateAddress()
            }

            is PropertyFormEvent.TotalRoomChange -> {
                state = state.copy(totalRoom = event.value)
                validateTotalRooms()
            }

            is PropertyFormEvent.Submit -> {
                if (validateName() && validateAddress()) {
                    onSubmit()
                }
            }
        }
    }

    private fun validateName(): Boolean {
        val nameResult = validateBaseUseCase.execute(state.name)
        Log.d("nameResult", nameResult.toString())
        state = state.copy(nameError = nameResult.errorMessage)
        return nameResult.successful
    }

    private fun validateAddress(): Boolean {
        val addressResult = validateBaseUseCase.execute(state.address)
        state = state.copy(addressError = addressResult.errorMessage)
        return addressResult.successful
    }

    private fun validateTotalRooms(): Boolean {
        val totalRoomResult = validateRoomNumberUseCase.execute(state.totalRoom)
        state = state.copy(totalRoomError = totalRoomResult.errorMessage)
        return totalRoomResult.successful
    }
}