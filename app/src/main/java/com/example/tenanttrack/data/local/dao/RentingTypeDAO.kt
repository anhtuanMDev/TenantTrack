package com.example.tenanttrack.data.local.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.tenanttrack.data.local.entities.RentingTypeTable

@Dao
interface RentingTypeDAO {
    @Query("SELECT * FROM RentingTypeTable")
    fun getAll(): List<RentingTypeTable>

    // delete all
    @Query("DELETE FROM RentingTypeTable")
    fun deleteAll()

    // delete by property id
    @Query("DELETE FROM RentingTypeTable WHERE property_id = :propertyID")
    fun deleteByPropertyID(propertyID: Int)

    // create
    @Insert
    fun insert(vararg rentingTypes: RentingTypeTable)
}