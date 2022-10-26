package com.moviles.practicabdroom.ui.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.moviles.practicabdroom.dal.entities.Restaurante
import com.moviles.practicabdroom.dal.entities.Tipo

class RestauranteSpinner(
    context : Context,
    var objects : MutableList<Restaurante>
) :  ArrayAdapter<Restaurante>(
context,
android.R.layout.simple_spinner_item,
objects
) {

    fun getIdForRestaurante(restaurante : Restaurante) : Int{
        val restaurante = objects.indexOf(restaurante)
        val id = objects[restaurante].id
        return id
    }
}