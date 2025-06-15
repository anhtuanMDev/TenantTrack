package com.example.tenanttrack.data

import androidx.room.Database
import androidx.room.RoomDatabase
import androidx.room.TypeConverters
import com.example.tenanttrack.converters.Converters
import com.example.tenanttrack.data.local.dao.PaymentRecordDAO
import com.example.tenanttrack.data.local.dao.PropertyDAO
import com.example.tenanttrack.data.local.dao.RentingTypeDAO
import com.example.tenanttrack.data.local.dao.RoomDAO
import com.example.tenanttrack.data.local.dao.TenantDAO
import com.example.tenanttrack.data.local.entities.PaymentRecordTable
import com.example.tenanttrack.data.local.entities.PropertyTable
import com.example.tenanttrack.data.local.entities.RentingTypeTable
import com.example.tenanttrack.data.local.entities.RoomTable
import com.example.tenanttrack.data.local.entities.TenantTable

@Database(
    entities = [
        PropertyTable::class,
        RoomTable::class,
        RentingTypeTable::class,
        TenantTable::class,
        PaymentRecordTable::class
    ], version = 1
)
@TypeConverters(Converters::class)
abstract class AppDatabase : RoomDatabase() {
    abstract fun propertyDao(): PropertyDAO
    abstract fun roomDao(): RoomDAO
    abstract fun rentingTypeDao(): RentingTypeDAO
    abstract fun tenantDao(): TenantDAO
    abstract fun paymentRecordDao(): PaymentRecordDAO

}