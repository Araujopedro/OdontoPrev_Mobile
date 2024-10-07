package com.challenge.odontocare

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class BuscarClinicasActivity : AppCompatActivity() {

    private lateinit var etBuscarClinicas: EditText
    private lateinit var btBuscarClinicas: Button
    private lateinit var primeiroTexto: TextView
    private lateinit var segundoTexto: TextView
    private lateinit var terceiroTexto: TextView
    private lateinit var iconBack: ImageView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscarnasuaarea)

        etBuscarClinicas = findViewById(R.id.etLocalizacao)
        btBuscarClinicas = findViewById(R.id.btBuscar)
        primeiroTexto = findViewById(R.id.primeirotexto)
        segundoTexto = findViewById(R.id.segundotexto)
        terceiroTexto = findViewById(R.id.terceirotexto)
        iconBack = findViewById(R.id.icon_back)

        iconBack.setOnClickListener {
            finish()
        }

        btBuscarClinicas.setOnClickListener {
            try {
                buscarClinicas()
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao buscar clínicas: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun buscarClinicas() {
        val localizacao = etBuscarClinicas.text.toString().trim()

        if (localizacao.isNotEmpty()) {
            primeiroTexto.text = "Clínica Sorriso Feliz - Rua das Flores, 123"
            segundoTexto.text = "Clínica OdontoCare - Av. Central, 456"
            terceiroTexto.text = "Clínica Saúde Dental - Rua da Esperança, 789"
        } else {
            throw IllegalArgumentException("O campo de localização não pode estar vazio.")
        }
    }
}
