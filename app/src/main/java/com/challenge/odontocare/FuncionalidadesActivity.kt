package com.challenge.odontocare

import android.content.Intent
import android.os.Bundle
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class FuncionalidadesActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcionalidades)

        val agendaIcon = findViewById<ImageView>(R.id.imgAgendamentos)
        val localizationIcon = findViewById<ImageView>(R.id.imgBuscarNaArea)
        val alertasIcon = findViewById<ImageView>(R.id.imgAlertas)
        val perfilIcon = findViewById<ImageView>(R.id.imgPerfilPaciente)

        agendaIcon.setOnClickListener {
            try {
                val intent = Intent(this, AgendamentosActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao abrir agendamentos: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        localizationIcon.setOnClickListener {
            try {
                val intent = Intent(this, BuscarClinicasActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao buscar clínicas: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        alertasIcon.setOnClickListener {
            try {
                val intent = Intent(this, AlertasActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao abrir alertas: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        perfilIcon.setOnClickListener { // Adicione esta parte
            try {
                val intent = Intent(this, PerfilPacienteActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao abrir perfil: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }
    }
}

