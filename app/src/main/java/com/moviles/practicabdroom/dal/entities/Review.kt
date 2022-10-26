package com.moviles.practicabdroom.dal.entities

import androidx.room.Entity
import androidx.room.ForeignKey
import androidx.room.PrimaryKey

@Entity(
    foreignKeys = [ForeignKey(
        entity = Hamburguesa::class,
        parentColumns = arrayOf("id"),
        childColumns = arrayOf("id_restaurante"),
        onDelete = ForeignKey.CASCADE
    )]
)
data class Review (
    val texto : String,
    val id_restaurante : Int,
    val puntuacion : Int,
        ){

    @PrimaryKey(autoGenerate = true)
    var id : Int = 0
}