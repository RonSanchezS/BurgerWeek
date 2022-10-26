package com.moviles.practicabd.ui.activities

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Spinner
import androidx.appcompat.app.AppCompatActivity
import com.moviles.practicabdroom.R
import com.moviles.practicabdroom.dal.entities.Producto
import com.moviles.practicabdroom.dal.entities.Tipo
import com.moviles.practicabdroom.repository.ProductoRepository
import com.moviles.practicabdroom.repository.TipoRepository
import com.moviles.practicabdroom.ui.adapters.TipoSpinnerAdapter

class FormProducto : AppCompatActivity() {
    private lateinit var spinnerAdapter: TipoSpinnerAdapter
    private lateinit var btnSave: Button
    private lateinit var btnCancel: Button
    private lateinit var txtProductName: EditText
    private lateinit var txtProductDescription: EditText
    private lateinit var txtProductPrice: EditText
    private lateinit var spTipos: Spinner

    private var id = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_form_producto)
        btnSave = findViewById(R.id.btnSave)
        btnCancel = findViewById(R.id.btnCancel)
        txtProductName = findViewById(R.id.txtProductName)
        txtProductDescription = findViewById(R.id.txtProductDescription)
        txtProductPrice = findViewById(R.id.txtProductPrice)
        spTipos = findViewById(R.id.spTipos)
        id = intent.getIntExtra("productoId", 0)

        loadTipos()

        if (id > 0) {
            loadProductoForm()
        }
        setupEventListeners()
    }

    private fun loadTipos() {
        val tipos = TipoRepository.getAllTipos(this)
        spinnerAdapter = TipoSpinnerAdapter(this, tipos as MutableList<Tipo>)
        spTipos.adapter = spinnerAdapter
    }

    private fun loadProductoForm() {
        val producto = ProductoRepository.getProductoById(id, this) ?: return
        txtProductName.setText(producto.nombre)
        txtProductDescription.setText(producto.descripcion)
        txtProductPrice.setText(producto.precio.toString())
        val idTipo = producto.idTipo
        val tipoIndex = spinnerAdapter.getIndexForTipo(idTipo)
        spTipos.setSelection(tipoIndex)
    }

    private fun setupEventListeners() {
        btnSave.setOnClickListener {
            saveClicked()
        }
        btnCancel.setOnClickListener {
            finish()
        }
    }

    private fun saveClicked() {
        val name = txtProductName.text.toString()
        val description = txtProductDescription.text.toString()
        val price = txtProductPrice.text.toString().toDouble()
        val selectedTipoPosition = spTipos.selectedItemPosition
        val selectedTipo = spTipos.adapter.getItem(selectedTipoPosition) as Tipo
        val product = Producto(
            nombre = name,
            descripcion = description,
            precio = price,
            idTipo = selectedTipo.id
        )
        if (id == 0) {
            ProductoRepository.insert(product, this)
        } else {
            product.id = id
            ProductoRepository.update(product, this)
        }
        finish()
    }
}