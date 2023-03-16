package com.clts.maquetadoandroid.cuentas

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clts.maquetadoandroid.R

class ListaCuentasRegresivasAdapter(private val cuentasRegresivasList: List<ListaCuentasRegresivasViewModel>) :
    RecyclerView.Adapter<ListaCuentasRegresivasAdapter.CuentasRegresivasViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CuentasRegresivasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.cuenta_regresiva_item, parent, false)
        return CuentasRegresivasViewHolder(view)
    }

    override fun onBindViewHolder(holder: CuentasRegresivasViewHolder, position: Int) {
        val cuentasRegresivasViewModel = cuentasRegresivasList[position]

        holder.cuentaRegresivaTiempoTextView.text =
            cuentasRegresivasViewModel.cuentaRegresiva.dias + " Days " + cuentasRegresivasViewModel.cuentaRegresiva.tiempo
        holder.cuentaRegresivaNombreTextView.text = cuentasRegresivasViewModel.cuentaRegresiva.nombre
    }

    override fun getItemCount(): Int {
        return cuentasRegresivasList.size
    }

    class CuentasRegresivasViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val cuentaRegresivaTiempoTextView: TextView = itemView.findViewById(R.id.countdown_time)
        val cuentaRegresivaNombreTextView: TextView = itemView.findViewById(R.id.countdown_name)
    }

}