package com.moviles.practicabdroom.dal.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Restaurante::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id_restaurante"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Hamburguesa(
    val nombre : String,
    val precio : Double,
    val descripcion : String,
    val imagen : String,
    val puntuacion : Double,
    val id_restaurante : Int
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
}