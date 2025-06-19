package com.example.tenanttrack.domain.model

sealed class PropertyFormEvent {
    data class NameChanged(val value: String) : PropertyFormEvent()
    data class AddressChanged(val value: String) : PropertyFormEvent()
    data class TotalRoomChange(val value: String) : PropertyFormEvent()
    object Submit : PropertyFormEvent()
}

sealed class RoomFormEvent {
    data class NameChanged(val value: String) : RoomFormEvent()
    data class FloorChanged(val value: String) : RoomFormEvent()
    data class RentChange(val value: String) : RoomFormEvent()
    data class SqrFeetChange(val value: String) : RoomFormEvent()
    object Submit : RoomFormEvent()
}