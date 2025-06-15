package com.example.tenanttrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tenanttrack.data.local.entities.TenantStatus
import com.example.tenanttrack.data.local.entities.TenantTable

@Dao
interface TenantDAO {
    @Query("SELECT * FROM tenanttable")
    fun getAll(): List<TenantTable>

    @Query("SELECT * FROM tenanttable WHERE uid IN (:tenantIds)")
    fun loadAllByIds(tenantIds: IntArray): List<TenantTable>

    // load by status
    @Query("SELECT * FROM tenanttable WHERE status = :status")
    fun loadByStatus(status: TenantStatus): List<TenantTable>

    @Query("SELECT * FROM tenanttable WHERE name LIKE :name")
    fun findByName(name: String): TenantTable

    @Query("SELECT * FROM tenanttable WHERE room_id = :roomID")
    fun findByRoomID(roomID: Int): List<TenantTable>

    @Insert
    fun insert(vararg tenants: TenantTable)

    @Insert
    fun insertAll(vararg tenants: TenantTable)

    @Query("SELECT * FROM tenanttable WHERE room_id = :roomID")
    fun getTenantsByRoomID(roomID: Int): List<TenantTable>

    @Delete
    fun delete(tenant: TenantTable)

    @Query("DELETE FROM tenanttable")
    fun deleteAll()

    @Query("UPDATE tenanttable SET status = :status WHERE uid = :tenantID")
    fun updateStatus(tenantID: Int, status: String)

    @Query("UPDATE tenanttable SET room_id = :roomID, relationship = :relationship, status = :status, name = :name, image = :image, verified = :verified, joined_at = :joinedAt, leave_at = :leaveAt, number_id = :numberID")
    fun updateTenant(tenantID: Int, roomID: Int, relationship: String, status: String, name: String, image: String?, verified: Boolean, joinedAt: Int, leaveAt: Int?, numberID: String, email: String, phoneNumber: String, emName: String, emNumber: String)
}