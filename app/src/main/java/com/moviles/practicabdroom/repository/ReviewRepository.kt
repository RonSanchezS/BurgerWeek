package com.moviles.practicabdroom.repository

import android.content.Context
import com.moviles.practicabdroom.dal.db.AppDatabase
import com.moviles.practicabdroom.dal.entities.Hamburguesa
import com.moviles.practicabdroom.dal.entities.Review

object ReviewRepository {

    fun getAllProducts(context: Context): List<Review> {
        val reviewDao = AppDatabase.getDatabase(context).reviewDao()
        return reviewDao.getAll()
    }

    fun getHamburguesaById(id: Int, context: Context): Review? {
        val reviewDao = AppDatabase.getDatabase(context).reviewDao()
        return reviewDao.getById(id)
    }

    fun getReviewsByHamburguesa(id : Int, context : Context) :  List<Review>{
        val reviewDao = AppDatabase.getDatabase(context).reviewDao()
        return reviewDao.getByRestauranteId(id)
    }

    fun insert(producto: Review, context: Context) {
        val reviewDao = AppDatabase.getDatabase(context).reviewDao()
        reviewDao.insert(producto)
    }

    fun update(producto: Review, context: Context) {
        val reviewDao = AppDatabase.getDatabase(context).reviewDao()
        reviewDao.update(producto)
    }

    fun getRatingByHamburguesa(id : Int, context : Context) :  Double{
        val reviewDao = AppDatabase.getDatabase(context).reviewDao()
        return reviewDao.getRatingByHamburguesa(id)
    }

    fun delete(producto: Review, context: Context) {
        val reviewDao = AppDatabase.getDatabase(context).reviewDao()
        reviewDao.delete(producto)
    }

    fun getNumeroDeReviewsByHamburguesa(id: Int, context: Context):Int {
        val reviewDao = AppDatabase.getDatabase(context).reviewDao()
        return reviewDao.getNumeroDeReviewsByHamburguesa(id)

    }
}