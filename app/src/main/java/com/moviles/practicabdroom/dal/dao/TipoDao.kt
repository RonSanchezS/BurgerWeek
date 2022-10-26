package com.moviles.practicabdroom.dal.dao

import androidx.room.*
import com.moviles.practicabdroom.dal.entities.Tipo

@Dao
interface TipoDao {
    @Query("SELECT * FROM tipo")
    fun getAll(): List<Tipo>

    @Query("SELECT * FROM tipo WHERE id = :id")
    fun getById(id: Int): Tipo?

    @Insert
    fun insert(Tipo: Tipo)

    @Update
    fun update(Tipo: Tipo)

    @Delete
    fun delete(Tipo: Tipo)
}