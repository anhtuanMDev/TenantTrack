package com.example.tenanttrack.data.local.dao

import androidx.room.Dao
import androidx.room.Delete
import androidx.room.Insert
import androidx.room.Query
import com.example.tenanttrack.data.local.entities.PropertyModelType
import com.example.tenanttrack.data.local.entities.PropertyTable

@Dao
interface PropertyDAO {
    @Query("SELECT * FROM propertytable")
    fun getAll(): List<PropertyTable>

    @Query("SELECT * FROM propertytable WHERE uid IN (:propertyIds)")
    fun loadAllByIds(propertyIds: IntArray): List<PropertyTable>

    @Query("SELECT * FROM propertytable WHERE name LIKE :name")
    fun findByName(name: String): PropertyTable

    @Query("SELECT * FROM propertytable WHERE model_type = :modelType")
    fun findByModelType(modelType: PropertyModelType): List<PropertyTable>

    @Insert
    fun insert(vararg properties: PropertyTable)

    @Delete
    fun delete(property: PropertyTable)

    @Query("DELETE FROM propertytable")
    fun deleteAll()

    @Query("UPDATE propertytable SET status = :status WHERE uid = :propertyID")
    fun updateStatus(propertyID: Int, status: String)

    // edit property with id
    @Query("UPDATE propertytable SET name = :name, address = :address, image = :image, total_room = :totalRoom, model_type = :modelType WHERE uid = :propertyID")
    fun updateProperty(propertyID: Int, name: String, address: String, image: String?, totalRoom: Int, modelType: String)
}