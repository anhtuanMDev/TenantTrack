package com.example.tenanttrack.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tenanttrack.data.local.entities.PaymentRecordTable

@Dao
interface PaymentRecordDAO {
    @Query("SELECT * FROM paymentrecordtable")
    fun getAll(): List<PaymentRecordTable>

    @Query("SELECT * FROM paymentrecordtable WHERE uid IN (:paymentRecordIds)")
    fun loadAllByIds(paymentRecordIds: IntArray): List<PaymentRecordTable>

    // load by tenant id
    @Query("SELECT * FROM paymentrecordtable WHERE tenant_id = :tenantID")
    fun loadByTenantID(tenantID: Int): List<PaymentRecordTable>

    @Insert
    fun insert(vararg paymentRecords: PaymentRecordTable)

    @Query("DELETE FROM paymentrecordtable")
    fun deleteAll()




}