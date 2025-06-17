package com.example.tenanttrack.data.local.entities

import androidx.annotation.StringRes
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import com.example.tenanttrack.R

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

enum class PropertyModelType(@StringRes val label: Int) {
    Hut(R.string.property_type_hut),
    House(R.string.property_type_house),
    Motel(R.string.property_type_motel),
    Apartment(R.string.property_type_apartment),
}

enum class PropertyStatus(@StringRes val label: Int) {
    Maintained(R.string.property_status_maintained),
    Vacant(R.string.property_status_vacant),
    Occupied(R.string.property_status_occupied),
    UnderConstruction(R.string.property_status_under_construction),
}
