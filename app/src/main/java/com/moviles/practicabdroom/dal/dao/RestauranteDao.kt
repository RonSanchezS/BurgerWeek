package com.moviles.practicabdroom.dal.dao

import androidx.room.*
import com.moviles.practicabdroom.dal.entities.Restaurante

@Dao
interface RestauranteDao {
    @Query("SELECT * FROM Restaurante")
    fun getAll(): List<Restaurante>

    @Query("SELECT * FROM restaurante WHERE id = :id")
    fun getById(id: Int): Restaurante?

    @Insert
    fun insert(restaurante: Restaurante)

    @Update
    fun update(restaurante: Restaurante)

    @Delete
    fun delete(restaurante: Restaurante)
}