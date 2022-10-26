package com.moviles.practicabd.ui.adapters

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Producto

class ProductoAdapter(
    val data: ArrayList<Producto>,
    val listener: OnProductoListener
) :
    RecyclerView.Adapter<ProductoAdapter.ProductoViewHolder>() {

    class ProductoViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val lblProductName: TextView = itemView.findViewById(R.id.lblProductName)
        val lblProductPrice: TextView = itemView.findViewById(R.id.lblProductPrice)
        val btnEdit: Button = itemView.findViewById(R.id.btnEdit)
        val btnDelete: Button = itemView.findViewById(R.id.btnDelete)
        val lblType: TextView = itemView.findViewById(R.id.lblType)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProductoViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val view = inflater.inflate(R.layout.producto_item_layout, parent, false)
        return ProductoViewHolder(view)
    }

    override fun onBindViewHolder(holder: ProductoViewHolder, position: Int) {
        val producto = data[position]
        holder.lblProductName.text = producto.nombre
        holder.lblProductPrice.text = producto.precio.toString()
        holder.lblType.text = producto.getTipo(holder.lblType.context)?.nombre
        holder.btnEdit.setOnClickListener {
            listener.onProductoEdit(producto)
        }
        holder.btnDelete.setOnClickListener {
            listener.onProductoDelete(producto)
        }
    }

    override fun getItemCount(): Int {
        return data.size
    }

    fun refreshData(products: List<Producto>) {
        data.clear()
        data.addAll(products)
        notifyDataSetChanged()
    }

    fun removeItem(producto: Producto) {
        val position = data.indexOf(producto)
        data.remove(producto)
        notifyItemRemoved(position)
    }

    interface OnProductoListener {
        fun onProductoEdit(producto: Producto)
        fun onProductoDelete(producto: Producto)
    }
}