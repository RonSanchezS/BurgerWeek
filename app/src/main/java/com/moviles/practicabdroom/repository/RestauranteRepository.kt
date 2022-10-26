package com.moviles.practicabdroom.repository

import android.content.Context
import com.moviles.practicabdroom.dal.db.AppDatabase
import com.moviles.practicabdroom.dal.entities.Hamburguesa
import com.moviles.practicabdroom.dal.entities.Restaurante

object RestauranteRepository {
    fun getAllProducts(context: Context): List<Restaurante> {
        val restauranteDao = AppDatabase.getDatabase(context).restauranteDao()
        return restauranteDao.getAll()
    }

    fun getProductoById(id: Int, context: Context): Restaurante? {
        val restauranteDao = AppDatabase.getDatabase(context).restauranteDao()
        return restauranteDao.getById(id)
    }

    fun insert(producto: Restaurante, context: Context) {
        val restauranteDao = AppDatabase.getDatabase(context).restauranteDao()
        restauranteDao.insert(producto)
    }

    fun update(producto: Restaurante, context: Context) {
        val restauranteDao = AppDatabase.getDatabase(context).restauranteDao()
        restauranteDao.update(producto)
    }

    fun delete(producto: Restaurante, context: Context) {
        val restauranteDao = AppDatabase.getDatabase(context).restauranteDao()
        restauranteDao.delete(producto)
    }
}
