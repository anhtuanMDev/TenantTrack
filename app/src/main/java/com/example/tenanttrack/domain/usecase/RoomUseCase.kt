package com.example.tenanttrack.domain.usecase

import com.example.tenanttrack.data.local.entities.RoomStatus
import com.example.tenanttrack.domain.model.Room
import com.example.tenanttrack.domain.model.toEntity
import com.example.tenanttrack.domain.repository.RoomRepository

class InsertRoomUseCase(private val repo: RoomRepository) {
    suspend fun invoke(room: Room) = repo.insertRoom(room.toEntity())
}

class UpdateRoomUseCase(private val repo: RoomRepository) {
    suspend fun invoke(room: Room) = repo.updateRoom(room.toEntity())
}

class DeleteRoomUseCase(private val repo: RoomRepository) {
    suspend fun invoke(room: Room) = repo.deleteRoom(room.toEntity())
}

class UpdateRoomStatusUseCase(private val repo: RoomRepository) {
    suspend fun invoke(roomID: Int, status: RoomStatus) = repo.updateRoomStatus(roomID, status)
}

class GetAllRoomUseCase(private val repo: RoomRepository) {
    operator fun invoke(id: Int) = repo.getListRoom(id)
}