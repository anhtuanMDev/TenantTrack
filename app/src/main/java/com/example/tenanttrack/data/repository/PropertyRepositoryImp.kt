package com.example.tenanttrack.data.repository

import com.example.tenanttrack.data.local.dao.PropertyDAO
import com.example.tenanttrack.domain.model.Property
import com.example.tenanttrack.domain.model.toDomain
import com.example.tenanttrack.domain.model.toEntity
import com.example.tenanttrack.domain.repository.PropertyRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class PropertyRepositoryImp(
    private val propertyDAO: PropertyDAO
) : PropertyRepository {
    override fun getAllProperty(): Flow<List<Property>> {
        return propertyDAO.getAll().map { entries ->
            entries.map {
                it.toDomain()
            }
        }
    }

    override fun getDetailProperty(id: Int): Flow<Property> {
        return propertyDAO.loadAllByIds(id).map { it.toDomain() }
    }

    override suspend fun insertProperty(property: Property): Long {
        return propertyDAO.insert(
            property.toEntity()
        )
    }


    override suspend fun updateProperty(property: Property) {
        propertyDAO.updateProperty(
            property.toEntity()
        )
    }

    override suspend fun deleteProperty(property: Property) {
        propertyDAO.delete(
            property.toEntity()
        )
    }
}