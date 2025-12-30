package com.balancetech.sitemanagement.data.dao

import androidx.room.*
import com.balancetech.sitemanagement.data.entity.Apartment
import kotlinx.coroutines.flow.Flow

@Dao
interface ApartmentDao {
    @Query("SELECT * FROM apartments WHERE id = :id")
    suspend fun getApartmentById(id: String): Apartment?

    @Query("SELECT * FROM apartments WHERE isActive = 1")
    fun getAllActiveApartments(): Flow<List<Apartment>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertApartment(apartment: Apartment)

    @Update
    suspend fun updateApartment(apartment: Apartment)

    @Delete
    suspend fun deleteApartment(apartment: Apartment)
}
