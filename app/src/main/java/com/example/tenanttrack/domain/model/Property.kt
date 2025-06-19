package com.example.tenanttrack.domain.model

import com.example.tenanttrack.data.local.entities.PropertyModelType
import com.example.tenanttrack.data.local.entities.PropertyStatus
import com.example.tenanttrack.data.local.entities.PropertyTable

data class Property(
    val id: Int,
    val name: String,
    val image: String?,
    val address: String,
    val totalRoom: Int,
    val modelType: PropertyModelType,
    val status: PropertyStatus?,
)

data class PropertyCard(
    val id: Int,
    val name: String,
    val image: String?,
    val address: String,
    val totalRoom: Int,
    val occupiedRoom: IntArray,
    val revenue: Long,
    val modelType: PropertyModelType,
    val status: PropertyStatus?,
)

fun Property.toEntity() = PropertyTable(
    uid = this.id,
    name = this.name,
    address = this.address,
    image = this.image,
    totalRoom = this.totalRoom,
    modelType = this.modelType,
    status = this.status
)

fun PropertyTable.toDomain() = Property(
    id = this.uid,
    name = this.name,
    address = this.address,
    image = this.image,
    totalRoom = this.totalRoom,
    modelType = this.modelType,
    status = this.status
)

fun Property.toPropertyCard(rooms: IntArray, revenue: Long): PropertyCard {
    return PropertyCard(
        id = this.id,
        name = this.name,
        image = this.image,
        address = this.address,
        totalRoom = this.totalRoom,
        occupiedRoom = rooms,
        revenue = revenue,
        modelType = this.modelType,
        status = this.status
    )
}
