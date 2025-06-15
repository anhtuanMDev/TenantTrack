package com.example.tenanttrack.data.local.entities

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class TenantTable(
    @PrimaryKey val uid: Int,
    @ColumnInfo(name = "room_id") val roomID: Int,
    val relationship: String,
    val status: TenantStatus,
    val name: String,
    val image: String?,
    val verified: Boolean,
    @ColumnInfo(name = "joined_at") val joinedAt: Int,
    @ColumnInfo(name = "leave_at") val leaveAt: Int?,
    @ColumnInfo(name = "number_id") val numberID: String,
    val email: String,
    @ColumnInfo(name = "phone_number") val phoneNumber: String,
    @ColumnInfo(name = "emergency_contact_name") val emName: String,
    @ColumnInfo(name = "emergency_contact_number") val emNumber: String,
)

enum class TenantStatus {
    Active,
    Inactive,
    Pending,
    Leave,
}
