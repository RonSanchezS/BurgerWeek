package com.moviles.practicabdroom.dal.db

import android.content.Context
import androidx.room.Database
import androidx.room.Room.databaseBuilder
import androidx.room.RoomDatabase
import com.moviles.practicabdroom.dal.dao.*
import com.moviles.practicabdroom.dal.entities.*

@Database(
    entities = [Producto::class, Tipo::class, Hamburguesa::class, Restaurante::class, Review::class],
    version = 6
)
abstract class AppDatabase : RoomDatabase() {

    abstract fun hamburguesaDao(): HamburguesaDao
    abstract fun restauranteDao(): RestauranteDao
    abstract fun reviewDao(): ReviewDao
    abstract fun productoDao(): ProductoDao
    abstract fun tipoDao(): TipoDao

    companion object {
        private var instance: AppDatabase? = null

        fun getDatabase(context: Context): AppDatabase {
            if (instance == null) {
                instance = databaseBuilder(
                    context,
                    AppDatabase::class.java,
                    "practica_bd_room"
                )
                    .allowMainThreadQueries()
                    .fallbackToDestructiveMigration()
                    .build()
            }
            return instance!!
        }
    }
}
