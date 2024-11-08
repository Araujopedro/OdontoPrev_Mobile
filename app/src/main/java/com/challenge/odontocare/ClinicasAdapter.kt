package com.challenge.odontocare

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ClinicasAdapter(private val clinicas: List<ClinicaResponse>) : RecyclerView.Adapter<ClinicasAdapter.ClinicaViewHolder>() {

    class ClinicaViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val nomeClinica: TextView = itemView.findViewById(R.id.nomeClinica)
        val enderecoClinica: TextView = itemView.findViewById(R.id.enderecoClinica)
        val telefoneClinica: TextView = itemView.findViewById(R.id.telefoneClinica)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ClinicaViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.activity_item_clinica, parent, false)
        return ClinicaViewHolder(view)
    }

    override fun onBindViewHolder(holder: ClinicaViewHolder, position: Int) {
        val clinica = clinicas[position]
        holder.nomeClinica.text = clinica.nome
        holder.enderecoClinica.text = clinica.endereco
        holder.telefoneClinica.text = clinica.telefone
    }

    override fun getItemCount(): Int {
        return clinicas.size
    }
}
