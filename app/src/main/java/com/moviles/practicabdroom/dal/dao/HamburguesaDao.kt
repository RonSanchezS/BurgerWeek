package com.moviles.practicabdroom.dal.dao

import androidx.room.*
import com.moviles.practicabdroom.dal.entities.Hamburguesa

@Dao
interface HamburguesaDao {
    @Query("SELECT * FROM Hamburguesa")
    fun getAll(): List<Hamburguesa>

    @Query("SELECT * FROM Hamburguesa WHERE id = :id")
    fun getById(id: Int): Hamburguesa?

    @Insert
    fun insert(hamburguesa: Hamburguesa)

    @Update
    fun update(hamburguesa: Hamburguesa)

    @Delete
    fun delete(hamburguesa: Hamburguesa)

    @Query("SELECT * FROM hamburguesa WHERE id_restaurante = :id_restaurante")
    fun getByRestauranteId(id_restaurante: Int):  List<Hamburguesa>
}