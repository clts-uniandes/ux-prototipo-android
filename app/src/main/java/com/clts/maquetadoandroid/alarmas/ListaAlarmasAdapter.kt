package com.clts.maquetadoandroid.alarmas

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clts.maquetadoandroid.ListaAlarmasViewModel
import com.clts.maquetadoandroid.R
import com.clts.maquetadoandroid.data.Alarma

class ListaAlarmasAdapter(private val alarmasList: List<ListaAlarmasViewModel>): RecyclerView.Adapter<ListaAlarmasAdapter.AlarmasViewHolder>() {

    /* Creates and inflates view and return AlarmaViewHolder. */
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AlarmasViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.alarma_item, parent, false)
        return AlarmasViewHolder(view)
    }

    override fun onBindViewHolder(holder: AlarmasViewHolder, position: Int) {
        val alarmasViewModel = alarmasList[position]

        holder.alarmaHoraTextView.text = alarmasViewModel.alarma.hora
        holder.alarmaNombreTextView.text = alarmasViewModel.alarma.nombre
        //snackbar?
        /*holder.deleteButton.setOnClickListener{  view ->
            Snackbar.make(view, "Replace with your own action", Snackbar.LENGTH_LONG)
                .setAction("Action", null).show() }*/
    }

    override fun getItemCount(): Int {
        return alarmasList.size
    }

    class AlarmasViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        val alarmaHoraTextView: TextView = itemView.findViewById(R.id.alarm_hour)
        val alarmaNombreTextView: TextView = itemView.findViewById(R.id.alarm_name)
        //pending static arrow image
        //val collectorCardView: MaterialCardView = view.findViewById(R.id.collector_card)
        //val deleteButton: ImageView = itemView.findViewById(R.id.delete_icon)
    }


}