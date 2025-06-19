package com.example.tenanttrack.domain.usecase

import com.example.tenanttrack.data.repository.RoomRepositoryImp
import com.example.tenanttrack.domain.model.Property
import com.example.tenanttrack.domain.model.PropertyCard
import com.example.tenanttrack.domain.model.toPropertyCard
import com.example.tenanttrack.domain.repository.PropertyRepository
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest

class InsertPropertyUseCase(private val repo: PropertyRepository) {
    suspend fun invoke(property: Property) = repo.insertProperty(property)
}

class GetAllPropertyUseCase(private val repo: PropertyRepository) {
    operator fun invoke() = repo.getAllProperty()
}

@OptIn(ExperimentalCoroutinesApi::class)
class GetCardPropertyUseCase(
    private val flowProperty: PropertyRepository,
    private val flowRoom: RoomRepositoryImp
) {
    operator fun invoke(): Flow<List<PropertyCard>> {
        return flowProperty.getAllProperty().flatMapLatest { propertyList ->
            combine(
                propertyList.map { property ->
                    combine(
                        flowRoom.getOccupiedRoom(property.id),
                        flowRoom.getOccupiedRoomRevenue(property.id)
                    ) { room, revenue ->
                        property.toPropertyCard(room, revenue)
                    }
                }
            ) { it.toList() }
        }
    }
}

class UpdatePropertyUseCase(private val repo: PropertyRepository) {
    suspend operator fun invoke(property: Property) = repo.updateProperty(property)
}

class DeletePropertyUseCase(private val repo: PropertyRepository) {
    suspend operator fun invoke(property: Property) = repo.deleteProperty(property)
}