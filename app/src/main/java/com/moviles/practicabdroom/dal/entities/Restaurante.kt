package com.moviles.practicabdroom.dal.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Restaurante(
    val nombre : String,
    val imagen : String,

) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    override fun toString(): String {
        return "$id - $nombre"
    }


}
