package com.example.tenanttrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tenanttrack.data.local.entities.RoomAmenities
import com.example.tenanttrack.data.local.entities.RoomStatus
import com.example.tenanttrack.data.local.entities.RoomTable

@Dao
interface RoomDAO {
    @Query("SELECT * FROM roomtable WHERE uid IN (:roomIds)")
    fun loadAllByIds(roomIds: IntArray): List<RoomTable>

    @Insert
    fun insert(vararg rooms: RoomTable)

    @Delete
    fun delete(room: RoomTable)

    @Query("DELETE FROM roomtable")
    fun deleteAll()

    // update status
    @Query("UPDATE roomtable SET status = :status WHERE uid = :roomID")
    fun updateStatus(roomID: Int, status: RoomStatus)

    @Update
    fun updateRoom(room: RoomTable)

    // get room with status and property id
    @Query("SELECT * FROM roomtable WHERE status = :status AND property_id = :propertyID")
    fun getRoomsByStatusAndPropertyID(status: RoomStatus, propertyID: Int): List<RoomTable>


}