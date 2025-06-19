package com.example.tenanttrack.data.repository

import com.example.tenanttrack.data.local.dao.RoomDAO
import com.example.tenanttrack.data.local.entities.RoomStatus
import com.example.tenanttrack.data.local.entities.RoomTable
import com.example.tenanttrack.domain.repository.RoomRepository
import kotlinx.coroutines.flow.Flow

class RoomRepositoryImp(val dao: RoomDAO): RoomRepository  {
    override fun getOccupiedRoom(id: Int): Flow<IntArray> {
        return dao.getRoomsByStatusAndPropertyID(status = RoomStatus.Active, propertyID = id)
    }

    override fun getOccupiedRoomRevenue (id: Int): Flow<Long> {
        return dao.getSumOccupiedRoomRentMoney(status = RoomStatus.Active, propertyID = id)
    }

    override fun updateRoomStatus(roomID: Int, status: RoomStatus): Int {
        return dao.updateStatus(roomID, status)
    }

    override fun insertRoom(room: RoomTable): Long {
        return dao.insert(room)
    }

    override fun getListRoom(id: Int): Flow<List<RoomTable>> {
        return dao.loadAllByIds(id)
    }

    override fun updateRoom(room: RoomTable): Int {
        return dao.updateRoom(room)
    }

    override fun deleteRoom(room: RoomTable): Int {
        return dao.delete(room)
    }
}