package com.example.tenanttrack.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class PaymentRecordTable (
    @PrimaryKey(autoGenerate = true) val uid: Int,
    @ColumnInfo(name = "tenant_id") val tenantID: Int,
    @ColumnInfo(name = "rent")val rentMoney: Int,
    @ColumnInfo(name = "paid_date") val paidDate: Int,
    @ColumnInfo(name = "paid_at") val paidAt: Int,
    val note: String,
    @ColumnInfo(name = "late_fee") val lateFee: Int,
)
