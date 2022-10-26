package com.moviles.practicabdroom.repository

import android.content.Context
import com.moviles.practicabdroom.dal.db.AppDatabase
import com.moviles.practicabdroom.dal.entities.Hamburguesa
import com.moviles.practicabdroom.dal.entities.Producto

object HamburguesaRepository {
    fun getAllProducts(context: Context): List<Hamburguesa> {
        val hamburguesaDao = AppDatabase.getDatabase(context).hamburguesaDao()
        return hamburguesaDao.getAll()
    }

    fun getHamburguesaById(id: Int, context: Context): Hamburguesa? {
        val hamburguesaDao = AppDatabase.getDatabase(context).hamburguesaDao()
        return hamburguesaDao.getById(id)
    }

    fun getHamburguesasByRestauranteId(id : Int, context : Context) :  List<Hamburguesa>{
        val hamburguesaDao = AppDatabase.getDatabase(context).hamburguesaDao()
        return hamburguesaDao.getByRestauranteId(id)
    }

    fun insert(producto: Hamburguesa, context: Context) {
        val hamburguesaDao = AppDatabase.getDatabase(context).hamburguesaDao()
        hamburguesaDao.insert(producto)
    }

    fun update(producto: Hamburguesa, context: Context) {
        val hamburguesaDao = AppDatabase.getDatabase(context).hamburguesaDao()
        hamburguesaDao.update(producto)
    }

    fun delete(producto: Hamburguesa, context: Context) {
        val hamburguesaDao = AppDatabase.getDatabase(context).hamburguesaDao()
        hamburguesaDao.delete(producto)
    }
}