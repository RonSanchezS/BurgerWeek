package com.moviles.practicabdroom.repository

import android.content.Context
import com.moviles.practicabdroom.dal.db.AppDatabase
import com.moviles.practicabdroom.dal.entities.Producto

object ProductoRepository {
    fun getAllProducts(context: Context): List<Producto> {
        val productoDao = AppDatabase.getDatabase(context).productoDao()
        return productoDao.getAll()
    }

    fun getProductoById(id: Int, context: Context): Producto? {
        val productoDao = AppDatabase.getDatabase(context).productoDao()
        return productoDao.getById(id)
    }

    fun insert(producto: Producto, context: Context) {
        val productoDao = AppDatabase.getDatabase(context).productoDao()
        productoDao.insert(producto)
    }

    fun update(producto: Producto, context: Context) {
        val productoDao = AppDatabase.getDatabase(context).productoDao()
        productoDao.update(producto)
    }

    fun delete(producto: Producto, context: Context) {
        val productoDao = AppDatabase.getDatabase(context).productoDao()
        productoDao.delete(producto)
    }
}
