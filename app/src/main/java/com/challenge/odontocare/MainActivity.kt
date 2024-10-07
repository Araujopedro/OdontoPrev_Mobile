package com.challenge.odontocare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val loginButton = findViewById<Button>(R.id.bt_entrar)
        val emailField = findViewById<EditText>(R.id.Edit_Text)
        val passwordField = findViewById<EditText>(R.id.Edit_Senha)
        val progressBar = findViewById<ProgressBar>(R.id.Progessbar)

        loginButton.setOnClickListener {
            val email = emailField.text.toString()
            val password = passwordField.text.toString()

            progressBar.visibility = ProgressBar.VISIBLE

            try {
                if (email.isNotEmpty() && password.isNotEmpty()) {
                    val intent = Intent(this, FuncionalidadesActivity::class.java)
                    startActivity(intent)

                    finish()
                } else {
                    Toast.makeText(this, "Por favor, preencha todos os campos.", Toast.LENGTH_SHORT).show()
                    progressBar.visibility = ProgressBar.INVISIBLE
                }
            } catch (e: Exception) {
                Toast.makeText(this, "Erro: ${e.message}", Toast.LENGTH_SHORT).show()
                progressBar.visibility = ProgressBar.INVISIBLE
            }
        }
    }
}

