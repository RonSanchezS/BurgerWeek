package com.moviles.practicabdroom.dal.entities

import android.content.Context
import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.ForeignKey.CASCADE
import androidx.room.PrimaryKey
import com.moviles.practicabdroom.repository.TipoRepository

@Entity(
    foreignKeys = [ForeignKey(
        entity = Tipo::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("idTipo"),
        onDelete = CASCADE
    )]
)
data class Producto(
    val nombre: String,
    val descripcion: String,
    val precio: Double,
    val idTipo: Int
) {
    fun getTipo(context: Context): Tipo? {
        return TipoRepository.getTipoById(idTipo, context)
    }

    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}