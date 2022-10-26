package com.moviles.practicabdroom.dal.dao

import androidx.room.*
import com.moviles.practicabdroom.dal.entities.Hamburguesa
import com.moviles.practicabdroom.dal.entities.Review

@Dao
interface ReviewDao {
    @Query("SELECT * FROM Review order by 1 desc")
    fun getAll(): List<Review>

    @Query("SELECT * FROM Review WHERE id = :id")
    fun getById(id: Int): Review?

    @Insert
    fun insert(review: Review)

    @Update
    fun update(review: Review)

    @Delete
    fun delete(review: Review)

    @Query("SELECT * FROM review WHERE id_restaurante = :id_restaurante order by id desc")
    fun getByRestauranteId(id_restaurante: Int):  List<Review>

    @Query("SELECT SUM(puntuacion) FROM review WHERE id_restaurante = :id_hamburguesa")
     fun getRatingByHamburguesa(id_hamburguesa: Int): Double

    @Query("SELECT count(*) FROM review WHERE id_restaurante = :id")
     fun getNumeroDeReviewsByHamburguesa(id: Int) : Int
}