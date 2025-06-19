package com.example.tenanttrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import androidx.room.Update
import com.example.tenanttrack.data.local.entities.PropertyModelType
import com.example.tenanttrack.data.local.entities.PropertyTable
import kotlinx.coroutines.flow.Flow

@Dao
interface PropertyDAO {
    @Query("SELECT * FROM propertytable")
    fun getAll(): Flow<List<PropertyTable>>

    @Query("SELECT * FROM propertytable WHERE uid IN (:propertyIds)")
    fun loadAllByIds(propertyIds: Int): Flow<PropertyTable>

    @Query("SELECT * FROM propertytable WHERE name LIKE :name")
    fun findByName(name: String): Flow<List<PropertyTable>>

    @Query("SELECT * FROM propertytable WHERE model_type = :modelType")
    fun findByModelType(modelType: PropertyModelType): Flow<List<PropertyTable>>

    @Insert
    suspend fun insert(properties: PropertyTable): Long

    @Delete
    fun delete(property: PropertyTable)

    @Query("DELETE FROM propertytable")
    fun deleteAll()

    @Query("UPDATE propertytable SET status = :status WHERE uid = :propertyID")
    fun updateStatus(propertyID: Int, status: String)

    @Update
    fun updateProperty(property: PropertyTable)
}