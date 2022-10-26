package com.moviles.practicabdroom.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Hamburguesa
import com.moviles.practicabdroom.dal.entities.Review

class ReviewAdapter(val data: ArrayList<Review>) :
    RecyclerView.Adapter<ReviewAdapter.ReviewViewHolder>() {
    class ReviewViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val usuario = itemView.findViewById<TextView>(R.id.lblUsuario)
        val comentario = itemView.findViewById<TextView>(R.id.lblReview)
        val calificacion = itemView.findViewById<TextView>(R.id.lblRating)

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ReviewViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.item_review, parent, false)
        return ReviewViewHolder(view)

    }

    override fun onBindViewHolder(holder: ReviewViewHolder, position: Int) {
        val review = data[position]
        holder.usuario.text = "usuario anonimo"
        holder.comentario.text = review.texto
        holder.calificacion.text = "Rating: ${review.puntuacion}"


    }

    override fun getItemCount(): Int {
        return data.size
    }


}