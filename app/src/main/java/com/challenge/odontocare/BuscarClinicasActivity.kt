package com.challenge.odontocare

import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.challenge.odontocare.API.ViaCepService
import retrofit2.*
import retrofit2.converter.gson.GsonConverterFactory

class BuscarClinicasActivity : AppCompatActivity() {

    private lateinit var etBuscarClinicas: EditText
    private lateinit var btBuscarClinicas: Button
    private lateinit var primeiroTexto: TextView
    private lateinit var segundoTexto: TextView
    private lateinit var terceiroTexto: TextView
    private lateinit var iconBack: Button
    private lateinit var retrofit: Retrofit
    private lateinit var viaCepService: ViaCepService

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_buscarnasuaarea)

        etBuscarClinicas = findViewById(R.id.Edit_CEP)
        btBuscarClinicas = findViewById(R.id.btBuscar)
        iconBack = findViewById(R.id.buttonBack)

        retrofit = Retrofit.Builder()
            .baseUrl("https://viacep.com.br/ws/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        viaCepService = retrofit.create(ViaCepService::class.java)

        iconBack.setOnClickListener {
            finish()
        }

        btBuscarClinicas.setOnClickListener {
            val cep = etBuscarClinicas.text.toString().trim()
            if (isCepValido(cep)) {
                buscarClinicas(cep)
            } else {
                Toast.makeText(this, "Por favor, insira um CEP válido de 8 dígitos.", Toast.LENGTH_SHORT).show()
            }
        }
    }

    private fun isCepValido(cep: String): Boolean {
        return cep.matches(Regex("^[0-9]{8}$"))
    }

    private fun buscarClinicas(cep: String) {
        val call = viaCepService.buscarClinicasPorCep(cep)
        call.enqueue(object : Callback<List<ClinicaResponse>> {
            override fun onResponse(call: Call<List<ClinicaResponse>>, response: Response<List<ClinicaResponse>>) {
                if (response.isSuccessful) {
                    val clinicas = response.body()
                    if (clinicas.isNullOrEmpty()) {
                        primeiroTexto.text = "Nenhuma clínica encontrada para o CEP informado."
                    } else {
                        primeiroTexto.text = "Clínicas encontradas:"
                        segundoTexto.text = ""
                        terceiroTexto.text = ""
                        clinicas.forEachIndexed { index, clinica ->
                            segundoTexto.append("${index + 1}. ${clinica.nome}, ${clinica.endereco}, Telefone: ${clinica.telefone}\n\n")
                        }
                    }
                } else {
                    Toast.makeText(this@BuscarClinicasActivity, "Erro ao buscar clínicas.", Toast.LENGTH_SHORT).show()
                }
            }

            override fun onFailure(call: Call<List<ClinicaResponse>>, t: Throwable) {
                Toast.makeText(this@BuscarClinicasActivity, "Erro de rede: ${t.message}", Toast.LENGTH_SHORT).show()
            }
        })

        val listaDeClinicas = listOf(
            ClinicaResponse("Clínica Solution", "Rua Anastácio, 123", "1111-2222"),
            ClinicaResponse("Clínica Smile", "Avenida Brigadeiro Henrique Fontinelli, 456", "3333-4444"),
            ClinicaResponse("Clínica Odontocare", "Avenida Paulista, 500", "5555-8888"),
            ClinicaResponse("Clínica Sorriso Perfeito", "Rua dos Lírios, 42, Jardim Paulista", "9999-6666")
        )

        val recyclerView: RecyclerView = findViewById(R.id.recyclerViewClinicas)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = ClinicasAdapter(listaDeClinicas)
    }
}
