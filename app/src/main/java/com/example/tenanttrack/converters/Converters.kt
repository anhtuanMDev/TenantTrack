package com.example.tenanttrack.converters

import androidx.room.TypeConverter
import com.example.tenanttrack.data.local.entities.PropertyModelType
import com.example.tenanttrack.data.local.entities.PropertyRentType
import com.example.tenanttrack.data.local.entities.RoomAmenities
import com.example.tenanttrack.data.local.entities.RoomStatus
import com.example.tenanttrack.data.local.entities.TenantStatus

class Converters {

    // Property

    @TypeConverter
    fun fromPropertyModelType(model: PropertyModelType): String = model.name

    @TypeConverter
    fun toPropertyModelType(value: String): PropertyModelType = PropertyModelType.valueOf(value)

    @TypeConverter
    fun fromPropertyRentType(rentType: PropertyRentType): String = rentType.name

    @TypeConverter
    fun toPropertyRentType(value: String): PropertyRentType = PropertyRentType.valueOf(value)

    // Tenant

    @TypeConverter
    fun fromTenantStatus(status: TenantStatus): String = status.name

    @TypeConverter
    fun toTenantStatus(value: String): TenantStatus = TenantStatus.valueOf(value)

    // Room

    @TypeConverter
    fun fromRoomStatus(status: RoomStatus): String = status.name

    @TypeConverter
    fun toRoomStatus(value: String): RoomStatus = RoomStatus.valueOf(value)

    @TypeConverter
    fun fromRoomAmenitiesList(list: List<RoomAmenities>?): String {
        return list?.joinToString(",") { it.name } ?: ""
    }

    @TypeConverter
    fun toRoomAmenitiesList(data: String): List<RoomAmenities> {
        return if (data.isEmpty()) {
            emptyList()
        } else {
            data.split(",").map { RoomAmenities.valueOf(it) }
        }
    }

    // Payment Record

    // Other

    @TypeConverter
    fun fromStringList(list: List<String>?): String {
        return list?.joinToString(",") ?: ""
    }

    @TypeConverter
    fun toStringList(data: String): List<String> {
        return if (data.isEmpty()) emptyList() else data.split(",")
    }
}