package com.moviles.practicabdroom.dal.dao

import androidx.room.*
import com.moviles.practicabdroom.dal.entities.Producto

@Dao
interface ProductoDao {
    @Query("SELECT * FROM producto")
    fun getAll(): List<Producto>

    @Query("SELECT * FROM producto WHERE id = :id")
    fun getById(id: Int): Producto?

    @Insert
    fun insert(producto: Producto)

    @Update
    fun update(producto: Producto)

    @Delete
    fun delete(producto: Producto)


}