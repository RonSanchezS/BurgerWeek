package com.moviles.practicabdroom.repository

import android.content.Context
import com.moviles.practicabdroom.dal.db.AppDatabase
import com.moviles.practicabdroom.dal.entities.Tipo

object TipoRepository {
    fun getAllTipos(context: Context): List<Tipo> {
        val tipoDao = AppDatabase.getDatabase(context).tipoDao()
        return tipoDao.getAll()
    }

    fun getTipoById(id: Int, context: Context): Tipo? {
        val tipoDao = AppDatabase.getDatabase(context).tipoDao()
        return tipoDao.getById(id)
    }

    fun insert(tipo: Tipo, context: Context) {
        val tipoDao = AppDatabase.getDatabase(context).tipoDao()
        tipoDao.insert(tipo)
    }

    fun update(tipo: Tipo, context: Context) {
        val tipoDao = AppDatabase.getDatabase(context).tipoDao()
        tipoDao.update(tipo)
    }

    fun delete(tipo: Tipo, context: Context) {
        val tipoDao = AppDatabase.getDatabase(context).tipoDao()
        tipoDao.delete(tipo)
    }
}
