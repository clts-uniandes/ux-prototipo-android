package com.clts.maquetadoandroid.alarmas

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.clts.maquetadoandroid.ListaAlarmasViewModel
import com.clts.maquetadoandroid.R
import com.clts.maquetadoandroid.data.Alarma
import com.clts.maquetadoandroid.databinding.ActivityListaAlarmasBinding

//const val ALARMA_ID = "alarma_id"

class ListaAlarmasActivityClone : AppCompatActivity() {

    /*private var _binding: ActivityListaAlarmasBinding? = null
    private val binding get() = _binding!!
    private val listaAlarmasViewModel by viewModels<ListaAlarmasViewModel>()
    private var thisContext: Context? = null*/

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_alarmas)

        val recyclerView = findViewById<RecyclerView>(R.id.alarmas_recyclerView)

        recyclerView.layoutManager = LinearLayoutManager(this)

        val data = ArrayList<ListaAlarmasViewModel>()

        data.add(
            ListaAlarmasViewModel(Alarma(
                id = 1,
                hora = "12:59 PM",
                nombre = "Segunda alarma",
                fecha = "2 Mayo 2022",
                dias = null
            )))
        data.add(
            ListaAlarmasViewModel(Alarma(
                id = 2,
                hora = "12:59 PM",
                nombre = "Mi alarma",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )))
        data.add(
            ListaAlarmasViewModel(Alarma(
                id = 3,
                hora = "12:59 PM",
                nombre = "Huevos",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )))
        data.add(
            ListaAlarmasViewModel(Alarma(
                id = 4,
                hora = "12:59 PM",
                nombre = "Fontanero",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )))
        data.add(
            ListaAlarmasViewModel(Alarma(
                id = 5,
                hora = "12:59 PM",
                nombre = "Examen",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )))
        data.add(
            ListaAlarmasViewModel(Alarma(
                id = 6,
                hora = "12:59 PM",
                nombre = "Primera alarma",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )))

        val adapter = ListaAlarmasAdapter(data)

        recyclerView.adapter = adapter

        val nuevaAlarmaTextView: TextView = findViewById<TextView>(R.id.nueva_alarma_text)
        nuevaAlarmaTextView.text = "Nueva alarma"

        /*listaAlarmasViewModel.alarmas.observe(this) {
                alarmas -> binding.alarmasRecyclerView.adapter = thisContext?.let { ListaAlarmasAdapter(it, alarmas) }
        }*/

        //listaAlarmasViewModel.onCreate



        //setContentView(R.layout.activity_lista_alarmas)

        /*val recyclerView: RecyclerView = findViewById(R.id.alarmas_recyclerView)
        recyclerView.adapter = thisContext?.let { ListaAlarmasAdapter(it, listaAlarmasViewModel.alarmas.value) }*/

        //recyclerView.adapter = alarmasAdapter




        /*val fab: View = findViewById(R.id.fab)
        fab.setOnClickListener {
            fabOnClick()
        }*/
    }

    /*override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment
        thisContext = container?.context
        _binding = ActivityListaAlarmasBinding.inflate(inflater, container, false)
        return binding.root
    }*/

    /* Opens FlowerDetailActivity when RecyclerView item is clicked. */
    /*private fun adapterOnClick(flower: Flower) {
        val intent = Intent(this, AADetailActivity()::class.java)
        intent.putExtra(FLOWER_ID, flower.id)
        startActivity(intent)
    }*/

    /* Adds flower to flowerList when FAB is clicked. */
    /*private fun fabOnClick() {
        val intent = Intent(this, AddFlowerActivity::class.java)
        startActivityForResult(intent, newFlowerActivityRequestCode)
    }*/

    /*override fun onActivityResult(requestCode: Int, resultCode: Int, intentData: Intent?) {
        super.onActivityResult(requestCode, resultCode, intentData)

        /* Inserts flower into viewModel. */
        if (requestCode == newFlowerActivityRequestCode && resultCode == Activity.RESULT_OK) {
            intentData?.let { data ->
                val flowerName = data.getStringExtra(FLOWER_NAME)
                val flowerDescription = data.getStringExtra(FLOWER_DESCRIPTION)

                flowersListViewModel.insertFlower(flowerName, flowerDescription)
            }
        }
    }*/
}