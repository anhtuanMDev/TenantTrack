package com.example.tenanttrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
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

    // update room with id
    @Query("UPDATE roomtable SET property_id = :propertyID, name = :name, floor = :floor, sqr = :sqr, amenities = :amenities, rent_at = :rentAt, paid_at = :paidAt, status = :status, available_from = :availableFrom")
    fun updateRoom(roomID: Int, propertyID: Int, name: String, floor: String, sqr: Int, amenities: List<RoomAmenities>, rentAt: Int, paidAt: Int, status: RoomStatus, availableFrom: Int, rentMoney: Int, furnished: Boolean)

    // get room with status and property id
    @Query("SELECT * FROM roomtable WHERE status = :status AND property_id = :propertyID")
    fun getRoomsByStatusAndPropertyID(status: RoomStatus, propertyID: Int): List<RoomTable>


}