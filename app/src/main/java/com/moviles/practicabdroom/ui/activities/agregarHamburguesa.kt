package com.moviles.practicabdroom.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import android.widget.Toast
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Hamburguesa
import com.moviles.practicabdroom.dal.entities.Restaurante
import com.moviles.practicabdroom.repository.HamburguesaRepository
import com.moviles.practicabdroom.repository.RestauranteRepository
import com.moviles.practicabdroom.ui.adapters.RestauranteSpinner

class agregarHamburguesa : AppCompatActivity() {

    private lateinit var spRestaurante: Spinner

    private lateinit var txtNombre: EditText
    private lateinit var txtPrecio: EditText
    private lateinit var txtDescripcion: EditText
    private lateinit var txtImagen: EditText

    private lateinit var restauranteSpinner: RestauranteSpinner

    private lateinit var btnGuardar: Button
    private lateinit var btnCancelar: Button

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_hamburguesa)

        initListView();
    }

    private fun initListView() {
        spRestaurante = findViewById(R.id.spinnerRestaurantes)

        loadRestaurantes();

        txtNombre = findViewById(R.id.txtNombreHamburguesa)
        txtPrecio = findViewById(R.id.txtPrecio)
        txtImagen = findViewById(R.id.txtImagen)
        txtDescripcion = findViewById(R.id.txtDescripcion)
        btnGuardar = findViewById(R.id.btnGuardarHamburguesa)
        btnCancelar = findViewById(R.id.btnCancelarHamburguesa)
        addListeners();
    }

    private fun loadRestaurantes() {
        val restaurantes = RestauranteRepository.getAllProducts(this)
        restauranteSpinner = RestauranteSpinner(this, restaurantes as MutableList<Restaurante>)
        spRestaurante.adapter = restauranteSpinner
    }

    private fun addListeners() {
        btnGuardar.setOnClickListener {
            saveClicked();
        }
        btnCancelar.setOnClickListener {
            finish();
        }
    }

    private fun saveClicked() {
        val nombre = txtNombre.text.toString()
        val precio = txtPrecio.text.toString().toDouble()
        val descripcion = txtDescripcion.text.toString()
        val imagen = txtImagen.text.toString()
        val restaurante = spRestaurante.selectedItem.toString()
        val idRestaurante = restaurante[0].toString().toInt();
        val hamburguesa = Hamburguesa(
            nombre = nombre,
            precio = precio,
            descripcion = descripcion,
            id_restaurante = idRestaurante,
            puntuacion = 0.0,
            imagen = imagen
        )
      //  Toast.makeText(this, hamburguesa.toString(), Toast.LENGTH_SHORT).show()
        HamburguesaRepository.insert(hamburguesa, this)
        finish()


    }
}