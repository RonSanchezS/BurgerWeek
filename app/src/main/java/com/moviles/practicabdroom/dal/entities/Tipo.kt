package com.moviles.practicabdroom.dal.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
data class Tipo(
    val nombre: String
) {
    @PrimaryKey(autoGenerate = true)
    var id: Int = 0
    override fun toString(): String {
        return nombre
    }
}
