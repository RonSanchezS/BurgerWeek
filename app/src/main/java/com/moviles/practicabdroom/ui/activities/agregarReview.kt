package com.moviles.practicabdroom.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.RatingBar
import android.widget.Toast
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Review
import com.moviles.practicabdroom.repository.HamburguesaRepository
import com.moviles.practicabdroom.repository.ReviewRepository

class agregarReview : AppCompatActivity() {

    private lateinit var btnGuardar : Button
    private lateinit var btnCancelar : Button

    private var id : Int = 0

    private lateinit var texto : EditText
    private lateinit var calificacion : RatingBar


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agregar_review)

        setUpListView()
    }

    private fun setUpListView() {
        btnGuardar = findViewById(R.id.button)
        btnCancelar = findViewById(R.id.button2)

        texto = findViewById(R.id.rtTexto)
        calificacion = findViewById(R.id.rtReview)



        id = intent.getIntExtra("hamburguesaId", 0)


        setUpListeners()
    }

    private fun setUpListeners() {
        btnGuardar.setOnClickListener {
            val texto = texto.text.toString()
            val calificacion = calificacion.rating
            val review = Review(
                texto = texto,
                puntuacion = calificacion.toInt(),
                id_restaurante = id
            )
            Toast.makeText(this, review.toString(), Toast.LENGTH_SHORT).show()
           ReviewRepository.insert(review, this)
            finish()
        }
        btnCancelar.setOnClickListener {
            finish()
        }
    }
}