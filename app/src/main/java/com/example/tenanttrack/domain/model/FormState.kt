package com.example.tenanttrack.domain.model

data class PropertyFormState(
    val name: String = "",
    val nameError: ValidateUIText? = null,
    val address: String = "",
    val addressError: ValidateUIText? = null,
    val totalRoom: String = "",
    val totalRoomError: ValidateUIText? = null,
)

data class RoomFormState(
    val name: String = "",
    val nameError: ValidateUIText? = null,
    val floor: String = "",
    val floorError: ValidateUIText? = null,
    val rent: String = "",
    val rentError: ValidateUIText? = null,
    val sqrt: String = "",
    val sqrtError: ValidateUIText? = null,
)