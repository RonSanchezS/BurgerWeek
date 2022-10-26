package com.moviles.practicabdroom.ui.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Hamburguesa
import com.moviles.practicabdroom.repository.HamburguesaRepository
import com.moviles.practicabdroom.repository.ProductoRepository
import com.moviles.practicabdroom.repository.RestauranteRepository
import com.moviles.practicabdroom.ui.adapters.HamburguesaAdapter

class HamburguesasDeRestaurante : AppCompatActivity(),
    HamburguesaAdapter.onHamburguesaListener {
    private lateinit var recyclerViewHamburguesas: RecyclerView
    private lateinit var adapter: HamburguesaAdapter
    private lateinit var btnFlotante: FloatingActionButton
    private var idRestaurante = 0;
    override fun onCreate(savedInstanceState: Bundle?) {


        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_hamburguesas_de_restaurante)

        setUpListView();
        getHamburguesas();
    }

    override fun onResume() {
        super.onResume()
        refreshData()
    }

    private fun refreshData() {
        val products = HamburguesaRepository.getHamburguesasByRestauranteId(idRestaurante, this);
        adapter.refreshData(products)
    }

    private fun setUpListView() {
        idRestaurante = intent.getIntExtra("restauranteId", 1)
        recyclerViewHamburguesas = findViewById(R.id.recyclerdeHamburguesas)
        btnFlotante = findViewById(R.id.floatingActionButton)
        Toast.makeText(this, "idRestaurante: $idRestaurante", Toast.LENGTH_SHORT).show()
        setUpListeners();
    }

    private fun setUpListeners() {
        btnFlotante.setOnClickListener {
            val intent = Intent(this, agregarHamburguesa::class.java)
            startActivity(intent)
        }


    }

    private fun getHamburguesas() {
        val hamburguesas = HamburguesaRepository.getHamburguesasByRestauranteId(idRestaurante, this)
        adapter = HamburguesaAdapter(hamburguesas as ArrayList<Hamburguesa>, this)
        recyclerViewHamburguesas.adapter = adapter
        recyclerViewHamburguesas.layoutManager = LinearLayoutManager(this);

    }
    private fun getReviews(){

    }

    override fun onHamburguesaClick(hamburguesa: Hamburguesa) {
        val intent = Intent(this, agregarReview::class.java)
        intent.putExtra("hamburguesaId", hamburguesa.id)
        startActivity(intent)


    }


}