package com.moviles.practicabdroom.ui.adapters

import android.content.Context
import android.widget.ArrayAdapter
import com.moviles.practicabdroom.dal.entities.Tipo

class TipoSpinnerAdapter(
        context: Context,
        var objects: MutableList<Tipo>
    ) :
            ArrayAdapter<Tipo>(
                context,
                android.R.layout.simple_spinner_item,
                objects
            ) {
        fun getIndexForTipo(idTipo: Int): Int {
            val index = objects.indexOfFirst { it.id == idTipo }
            return index
        }

    }