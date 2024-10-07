package com.challenge.odontocare

import android.os.Bundle
import android.view.View
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity

class AlertasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_alertas)

        val alertas = listOf(
            "Consulta agendada para amanhã às 10:00",
            "Lembrete: Para manter os dentes saudaveis, importante fazer uma limpeza a cada 6meses",
            "A sua consulta foi confirmada com o Dr. Silva"
        )

        exibirAlertas(alertas)

        val iconBack = findViewById<ImageView>(R.id.icon_back)
        iconBack.setOnClickListener {
            finish()
        }
    }

    private fun exibirAlertas(alertas: List<String>) {
        val txtAlerta1 = findViewById<TextView>(R.id.txtAlerta1)
        val txtAlerta2 = findViewById<TextView>(R.id.txtAlerta2)
        val txtAlerta3 = findViewById<TextView>(R.id.txtAlerta3)
        val txtMensagemErro = findViewById<TextView>(R.id.txtMensagemErro)

        if (alertas.isEmpty()) {

            txtMensagemErro.visibility = View.VISIBLE
            txtMensagemErro.text = "Nenhum alerta disponível."
            txtAlerta1.visibility = View.GONE
            txtAlerta2.visibility = View.GONE
            txtAlerta3.visibility = View.GONE
        } else {
            txtAlerta1.text = alertas.getOrNull(0) ?: ""
            txtAlerta2.text = alertas.getOrNull(1) ?: ""
            txtAlerta3.text = alertas.getOrNull(2) ?: ""

            txtAlerta1.visibility = View.VISIBLE
            txtAlerta2.visibility = View.VISIBLE
            txtAlerta3.visibility = View.VISIBLE
            txtMensagemErro.visibility = View.GONE
        }
    }
}
