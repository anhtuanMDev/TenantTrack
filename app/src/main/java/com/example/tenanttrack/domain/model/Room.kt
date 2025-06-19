package com.example.tenanttrack.domain.model

import com.example.tenanttrack.data.local.entities.RoomAmenities
import com.example.tenanttrack.data.local.entities.RoomStatus
import com.example.tenanttrack.data.local.entities.RoomTable

data class OccupiedRoom (
    val occupied: Int,
)

data class Room (
    val id: Int,
    val name: String,
    val floor: String,
    val sqr: Int,
    val amenities: List<RoomAmenities>,
    val rentAt: Int,
    val paidAt: Int,
    val status: RoomStatus,
    val availableFrom: Int,
    val rentMoney: Int,
    val furnished: Boolean,
    val propertyID: Int,
)

fun Room.toEntity() = RoomTable(
    uid = this.id,
    propertyID = this.propertyID,
    name = this.name,
    floor = this.floor,
    sqr = this.sqr,
    amenities = this.amenities,
    rentAt = this.rentAt,
    paidAt = this.paidAt,
    status = this.status,
    availableFrom = this.availableFrom,
    rentMoney = this.rentMoney,
    furnished = this.furnished,
)