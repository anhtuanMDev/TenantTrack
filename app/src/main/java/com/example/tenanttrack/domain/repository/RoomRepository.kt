package com.example.tenanttrack.domain.repository

import com.example.tenanttrack.data.local.entities.RoomStatus
import com.example.tenanttrack.data.local.entities.RoomTable
import kotlinx.coroutines.flow.Flow

interface RoomRepository {
    fun updateRoom (room: RoomTable): Int
    fun deleteRoom (room: RoomTable): Int
    fun insertRoom (room: RoomTable): Long
    fun getListRoom (id: Int): Flow<List<RoomTable>>
    fun getOccupiedRoom (id: Int): Flow<IntArray>
    fun getOccupiedRoomRevenue (id: Int): Flow<Long>
    fun updateRoomStatus (roomID: Int, status: RoomStatus): Int
}