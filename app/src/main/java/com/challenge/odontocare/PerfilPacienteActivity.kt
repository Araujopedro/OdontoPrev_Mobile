package com.challenge.odontocare

import android.os.Bundle
import android.widget.ImageView
import androidx.appcompat.app.AppCompatActivity

class PerfilPacienteActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_pacienteperfil)

        val backIcon = findViewById<ImageView>(R.id.icon_back) //

        backIcon.setOnClickListener {
            finish() //
        }


    }
}
