package com.moviles.practicabdroom.ui.adapters

import android.graphics.drawable.Drawable
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Producto
import com.moviles.practicabdroom.dal.entities.Restaurante
import java.io.InputStream
import java.net.URL


class RestauranteAdapter(
    val data: ArrayList<Restaurante>,
    val listener: RestauranteAdapter.onRestauranteListener
) : RecyclerView.Adapter<RestauranteAdapter.RestauranteViewHolder>() {

    class RestauranteViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre = itemView.findViewById<TextView>(R.id.txtNombreRestaurante)
        val url = itemView.findViewById<ImageView>(R.id.imageViewUrl)
    }

    interface onRestauranteListener {
        fun onRestauranteClick(restaurante: Restaurante)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RestauranteViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_restaurante, parent, false)
        return RestauranteViewHolder(view)
    }


    override fun getItemCount(): Int {
        return data.size
    }


    override fun onBindViewHolder(holder: RestauranteViewHolder, position: Int) {
        val restaurante = data[position]
        holder.nombre.text = restaurante.nombre
        holder.itemView.setOnClickListener {
            listener.onRestauranteClick(restaurante)
        }


    }
    fun refreshData(products: List<Restaurante>) {
        data.clear()
        data.addAll(products)
        notifyDataSetChanged()
    }

    fun removeItem(producto: Restaurante) {
        val position = data.indexOf(producto)
        data.remove(producto)
        notifyItemRemoved(position)
    }



}

