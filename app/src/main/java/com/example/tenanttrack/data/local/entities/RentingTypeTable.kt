package com.example.tenanttrack.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class RentingTypeTable(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "property_id") val propertyID: Int,
    @ColumnInfo(name = "renting_type") val rentingType: PropertyRentType,
    @ColumnInfo(name = "room_id") val roomID: Int?,
)

enum class PropertyRentType {
    Rooms,
    WholeHouse,
    Shared,
    Bed,
}