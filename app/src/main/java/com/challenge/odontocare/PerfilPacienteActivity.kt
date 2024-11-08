package com.challenge.odontocare

import android.os.Bundle
import android.widget.Button
import androidx.appcompat.app.AppCompatActivity

class PerfilPacienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacienteperfil)

        val backIcon = findViewById<Button>(R.id.buttonBack) //
        backIcon.setOnClickListener {
            finish() //
        }


    }
}
