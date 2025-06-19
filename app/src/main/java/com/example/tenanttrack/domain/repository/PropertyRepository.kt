package com.example.tenanttrack.domain.repository

import com.example.tenanttrack.domain.model.Property
import kotlinx.coroutines.flow.Flow

interface PropertyRepository {
    fun getAllProperty(): Flow<List<Property>>
    fun getDetailProperty(id: Int): Flow<Property>
    suspend fun insertProperty(property: Property): Long
    suspend fun updateProperty(property: Property)
    suspend fun deleteProperty(property: Property)
}