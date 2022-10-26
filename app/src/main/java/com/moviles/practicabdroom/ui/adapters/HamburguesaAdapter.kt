package com.moviles.practicabdroom.ui.adapters

import android.graphics.drawable.Drawable
import android.media.Rating
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.annotation.Nullable
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.GlideException
import com.bumptech.glide.request.RequestListener
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Hamburguesa
import com.moviles.practicabdroom.dal.entities.Review
import com.moviles.practicabdroom.repository.ReviewRepository
import javax.sql.DataSource

class HamburguesaAdapter(
    val data: ArrayList<Hamburguesa>,
    val listener: HamburguesaAdapter.onHamburguesaListener
) : RecyclerView.Adapter<HamburguesaAdapter.HamburguesaViewHolder>() {
    class HamburguesaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nombre = itemView.findViewById<TextView>(R.id.lblNombreHamburguesa)
        val precio = itemView.findViewById<TextView>(R.id.lblPrecio)
        val descripcion = itemView.findViewById<TextView>(R.id.lblDescripcion)
        val imgHamburguesa = itemView.findViewById<ImageView>(R.id.imgHamburguesa)
        val ratingBar = itemView.findViewById<RatingBar>(R.id.lblRatingHamburguesa)
        val recyclerReviews = itemView.findViewById<RecyclerView>(R.id.recyclerReviews)
    }


    interface onHamburguesaListener {
        fun onHamburguesaClick(hamburguesa: Hamburguesa)
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): HamburguesaViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_hamburguesa, parent, false)

        return HamburguesaViewHolder(view);
    }

    override fun onBindViewHolder(holder: HamburguesaViewHolder, position: Int) {
        val hamburguesa = data[position]
        holder.nombre.text = hamburguesa.nombre
        holder.precio.text = hamburguesa.precio.toString()
        holder.descripcion.text = hamburguesa.descripcion
        try {
            
        }catch (e: Exception){

        }
            Glide.with(holder.itemView.context)
                .load(""+hamburguesa.imagen+"")
                .placeholder(R.drawable.ic_launcher_background)
                .into(holder.imgHamburguesa)



       val rating = ReviewRepository.getRatingByHamburguesa(hamburguesa.id, holder.itemView.context)
        val numeroDeReviews = ReviewRepository.getNumeroDeReviewsByHamburguesa(hamburguesa.id, holder.itemView.context)
        val resultado = rating / numeroDeReviews
        holder.ratingBar.rating = resultado.toFloat()

        holder.itemView.setOnClickListener {
            listener.onHamburguesaClick(hamburguesa)
        }

        val reviews = ReviewRepository.getReviewsByHamburguesa(hamburguesa.id, holder.itemView.context)
        holder.recyclerReviews.adapter = ReviewAdapter(reviews as ArrayList<Review>)
        holder.recyclerReviews.layoutManager = LinearLayoutManager(holder.itemView.context)
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun refreshData(products: List<Hamburguesa>) {
        data.clear()
        data.addAll(products)
        notifyDataSetChanged()
    }

}