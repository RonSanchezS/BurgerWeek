package com.moviles.practicabd.ui.activities

import android.content.Intent
import android.os.Build
import android.os.Bundle
import android.os.StrictMode
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.moviles.practicabd.ui.adapters.ProductoAdapter
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Producto
import com.moviles.practicabdroom.dal.entities.Restaurante
import com.moviles.practicabdroom.repository.RestauranteRepository
import com.moviles.practicabdroom.ui.activities.FormRestaurante
import com.moviles.practicabdroom.ui.activities.HamburguesasDeRestaurante
import com.moviles.practicabdroom.ui.adapters.RestauranteAdapter


class MainActivity : AppCompatActivity(), ProductoAdapter.OnProductoListener,
    RestauranteAdapter.onRestauranteListener {
    private lateinit var adapter: RestauranteAdapter
    private lateinit var lstRestaurantes: RecyclerView
    private lateinit var btnCreateProduct: FloatingActionButton

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val SDK_INT = Build.VERSION.SDK_INT
        if (SDK_INT > 8) {
            val policy = StrictMode.ThreadPolicy.Builder()
                .permitAll().build()
            StrictMode.setThreadPolicy(policy)
            //your codes here
        }

        lstRestaurantes = findViewById(R.id.lstProducts)
        btnCreateProduct = findViewById(R.id.btnCreateProduct)

        setupRecyclerView()
        setupEventListeners()
    }

    private fun setupEventListeners() {
        btnCreateProduct.setOnClickListener {
            val intent = Intent(this, FormRestaurante::class.java)
            startActivity(intent)
        }
    }

    private fun setupRecyclerView() {
        val restaurantes = RestauranteRepository.getAllProducts(this)
        adapter = RestauranteAdapter(restaurantes as ArrayList<Restaurante>, this)
        lstRestaurantes.adapter = adapter
        lstRestaurantes.layoutManager = LinearLayoutManager(this)
    }

    override fun onResume() {
        super.onResume()
        refreshData()
    }

    private fun refreshData() {
        val products = RestauranteRepository.getAllProducts(this)
        adapter.refreshData(products)
    }

    override fun onProductoEdit(producto: Producto) {
       // val intent = Intent(this, FormProducto::class.java)
      //  intent.putExtra("productoId", producto.id)
      //  startActivity(intent)
    }

    override fun onProductoDelete(producto: Producto) {
       // ProductoRepository.delete(producto, this)
       // adapter.removeItem(producto)
    }

    override fun onRestauranteClick(restaurante: Restaurante) {
        val intent = Intent(this, HamburguesasDeRestaurante::class.java)
        intent.putExtra("restauranteId", restaurante.id)
        intent.putExtra("nombreRestaurante", restaurante.nombre);
        startActivity(intent)
    }


}