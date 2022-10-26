package com.moviles.practicabdroom.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Restaurante
import com.moviles.practicabdroom.repository.RestauranteRepository

class FormRestaurante : AppCompatActivity() {

    private lateinit var editTextRestoNombre : EditText
    private lateinit var editTextTextURL : EditText
    private lateinit var btnGuardar : Button
    private lateinit var btnCancelar : Button

    private var id : Int = 0
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_restaurante)
        setUpViews();
    }

    private fun setUpViews() {
        editTextRestoNombre = findViewById(R.id.editTextRestoNombre)
        editTextTextURL = findViewById(R.id.editTextTextUrl)
        btnGuardar = findViewById(R.id.btnGuardar)
        btnCancelar = findViewById(R.id.btnCancelar)

        id = intent.getIntExtra("restauranteId", 0)

        if(id != 0){
            cargarRestaurante()
        }

        setUpEventListeners();

    }

    private fun setUpEventListeners() {


        btnGuardar.setOnClickListener {
            saveClicked()
        }
        btnCancelar.setOnClickListener {
            finish()
        }


    }

    private fun saveClicked() {
        val nombre = editTextRestoNombre.text.toString()
        val url = editTextTextURL.text.toString()
        val restaurante = Restaurante(
            nombre = nombre,
            imagen = url
        )
        if(id == 0){
            RestauranteRepository.insert(restaurante, this)

        }else{
            restaurante.id = id
            RestauranteRepository.update(restaurante, this)
        }
        finish()

    }

    private fun cargarRestaurante() {
        val nombreRestaurante = RestauranteRepository.getProductoById(id, this) ?: return
        editTextRestoNombre.setText(nombreRestaurante.nombre)
        editTextTextURL.setText(nombreRestaurante.imagen)
    }
}