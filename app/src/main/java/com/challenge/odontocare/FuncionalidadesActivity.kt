package com.challenge.odontocare

import android.content.Intent
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import com.challenge.odontocare.API.ViaCepService
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class FuncionalidadesActivity : AppCompatActivity() {

    private lateinit var apiService: ViaCepService
    private lateinit var editTextCep: EditText
    private lateinit var primeiroTexto: TextView
    private lateinit var segundoTexto: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_funcionalidades)

        val agendaIcon = findViewById<ImageView>(R.id.imgAgendamentos)
        val localizationIcon = findViewById<ImageView>(R.id.imgBuscarNaArea)
        val alertasIcon = findViewById<ImageView>(R.id.imgAlertas)
        val perfilIcon = findViewById<ImageView>(R.id.imgPerfilPaciente)
        val btBuscar2 = findViewById<Button>(R.id.btBuscar2)
        primeiroTexto = findViewById(R.id.primeiroTexto)
        segundoTexto = findViewById(R.id.segundoTexto)
        editTextCep = findViewById(R.id.imgBuscarClinicas)

        // Configuração do Retrofit
        val retrofit = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        apiService = retrofit.create(ViaCepService::class.java)

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

        perfilIcon.setOnClickListener {
            try {
                val intent = Intent(this, PerfilPacienteActivity::class.java)
                startActivity(intent)
            } catch (e: Exception) {
                Toast.makeText(this, "Erro ao abrir perfil: ${e.message}", Toast.LENGTH_SHORT).show()
            }
        }

        btBuscar2.setOnClickListener {
            val cep = editTextCep.text.toString().trim()
            if (cep.isNotEmpty()) {
                buscarClinicas(cep)
            } else {
                Toast.makeText(this, "Por favor, insira um CEP válido.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun buscarClinicas(cep: String) {
        apiService.buscarEnderecoPorCep(cep).enqueue(object : Callback<EnderecoResponse> {
            override fun onResponse(call: Call<EnderecoResponse>, response: Response<EnderecoResponse>) {
                if (response.isSuccessful) {
                    val endereco = response.body()
                    endereco?.let {
                        primeiroTexto.text = "Endereço: ${it.logradouro}, ${it.bairro}"
                        segundoTexto.text = "Cidade: ${it.localidade}, Estado: ${it.uf}"
                        Toast.makeText(this@FuncionalidadesActivity, "CEP não encontrado. Verifique o valor digitado.", Toast.LENGTH_LONG).show()
                    }
                } else {
                    Toast.makeText(this@FuncionalidadesActivity, "Erro ao buscar clínicas: ${response.message()}", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<EnderecoResponse>, t: Throwable) {
                Toast.makeText(this@FuncionalidadesActivity, "Erro na conexão: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })
    }
}
