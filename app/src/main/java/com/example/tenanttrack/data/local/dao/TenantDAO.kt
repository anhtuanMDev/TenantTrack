package com.example.tenanttrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tenanttrack.data.local.entities.TenantStatus
import com.example.tenanttrack.data.local.entities.TenantTable
import kotlinx.coroutines.flow.Flow

@Dao
interface TenantDAO {
    @Query("SELECT * FROM tenanttable")
    fun getAll(): Flow<List<TenantTable>>

    @Query("SELECT * FROM tenanttable WHERE uid IN (:tenantIds)")
    fun loadAllByIds(tenantIds: IntArray): Flow<List<TenantTable>>

    // load by status
    @Query("SELECT * FROM tenanttable WHERE status = :status")
    fun loadByStatus(status: TenantStatus): Flow<List<TenantTable>>

    @Query("SELECT * FROM tenanttable WHERE name LIKE :name")
    fun findByName(name: String): Flow<List<TenantTable>>

    @Query("SELECT * FROM tenanttable WHERE room_id = :roomID")
    fun findByRoomID(roomID: Int): Flow<List<TenantTable>>

    @Insert
    fun insert(tenants: TenantTable): Long

    @Insert
    fun insertAll(vararg tenants: TenantTable): LongArray

    @Query("SELECT * FROM tenanttable WHERE room_id = :roomID")
    fun getTenantsByRoomID(roomID: Int): Flow<List<TenantTable>>

    @Delete
    fun delete(tenant: TenantTable)

    @Query("DELETE FROM tenanttable")
    fun deleteAll()

    @Query("UPDATE tenanttable SET status = :status WHERE uid = :tenantID")
    fun updateStatus(tenantID: Int, status: String)

    @Update
    fun updateTenant(tenant: TenantTable)
}