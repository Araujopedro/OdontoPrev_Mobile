package com.challenge.odontocare

import android.os.Bundle
import android.widget.Button
import android.widget.CalendarView
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class AgendamentosActivity : AppCompatActivity() {
    private lateinit var calendarView: CalendarView
    private lateinit var btConfirmarAgendamento: Button
    private lateinit var btCancelar: Button
    private lateinit var iconBack: ImageView

    private var selectedDate: String = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_agendamentos)

        calendarView = findViewById(R.id.calendarView)
        btConfirmarAgendamento = findViewById(R.id.btConfirmarAgendamento)
        btCancelar = findViewById(R.id.btCancelar)
        iconBack = findViewById(R.id.icon_back)

        calendarView.setOnDateChangeListener { _, year, month, dayOfMonth ->
            selectedDate = "$dayOfMonth/${month + 1}/$year"
            Toast.makeText(this, "Data selecionada: $selectedDate", Toast.LENGTH_SHORT).show()
        }

        btConfirmarAgendamento.setOnClickListener {
            try {
                confirmarAgendamento()
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao confirmar agendamento: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        btCancelar.setOnClickListener {
            finish()
        }

        iconBack.setOnClickListener {
            finish()
        }
    }

    private fun confirmarAgendamento() {
        if (selectedDate.isNotEmpty()) {
            Toast.makeText(this, "Agendamento confirmado para: $selectedDate", Toast.LENGTH_SHORT).show()
            finish()
        } else {
            Toast.makeText(this, "Por favor, selecione uma data antes de confirmar.", Toast.LENGTH_SHORT).show()
            throw IllegalArgumentException("Data não selecionada.")
        }
    }
}
