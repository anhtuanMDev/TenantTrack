package com.example.tenanttrack.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PropertyTable(
    @PrimaryKey val uid: Int,
    val name: String,
    val address: String,
    val image: String?,
    @ColumnInfo(name = "total_room") val totalRoom: Int,
    @ColumnInfo(name = "model_type") val modelType: PropertyModelType,
    @ColumnInfo(name = "status") val status: String?,
)

enum class PropertyModelType {
    Motel,
    Apartment,
    House
}
