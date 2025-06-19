package com.example.tenanttrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tenanttrack.data.local.entities.RoomStatus
import com.example.tenanttrack.data.local.entities.RoomTable
import kotlinx.coroutines.flow.Flow

@Dao
interface RoomDAO {
    @Query("SELECT * FROM roomtable WHERE uid IN (:roomIds)")
    fun loadAllByIds(roomIds: Int): Flow<List<RoomTable>>

    @Insert
    fun insertAll(vararg rooms: RoomTable) : LongArray

    @Insert
    fun insert(rooms: RoomTable) : Long

    @Delete
    fun delete(room: RoomTable): Int

    @Query("DELETE FROM roomtable")
    fun deleteAll()

    @Query("UPDATE roomtable SET status = :status WHERE uid = :roomID")
    fun updateStatus(roomID: Int, status: RoomStatus): Int

    @Update
    fun updateRoom(room: RoomTable): Int

    // get room with status and property id
    @Query("SELECT uid FROM roomtable WHERE status = :status AND property_id = :propertyID")
    fun getRoomsByStatusAndPropertyID(status: RoomStatus, propertyID: Int): Flow<IntArray>

    // get sum occupied room rent money
    @Query("SELECT SUM(rent) FROM roomtable WHERE status = :status AND property_id = :propertyID")
    fun getSumOccupiedRoomRentMoney(status: RoomStatus, propertyID: Int): Flow<Long>
}