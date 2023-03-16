package com.clts.maquetadoandroid.alarmas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.clts.maquetadoandroid.ListaAlarmasViewModel
import com.clts.maquetadoandroid.NuevaAlarmaActivity
import com.clts.maquetadoandroid.R
import com.clts.maquetadoandroid.data.Alarma
import com.clts.maquetadoandroid.databinding.FragmentListaAlarmasBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListaAlarmasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaAlarmasFragment : Fragment() {

    private lateinit var binding: FragmentListaAlarmasBinding
    private var thisContext: Context? = null

    // TODO: Rename and change types of parameters
    private var param1: String? = null
    private var param2: String? = null

    override fun onCreate(savedInstanceState: Bundle?) {

        super.onCreate(savedInstanceState)
        /*arguments?.let {

            param1 = it.getString(ARG_PARAM1)
            param2 = it.getString(ARG_PARAM2)
        }*/
        //val nuevaAlarmaButton = binding.nuevaAlarmaCard

    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        thisContext = container?.context
        binding = FragmentListaAlarmasBinding.inflate(inflater, container, false)
        binding.nuevaAlarmaText.text = "Nueva Alarma"

        val data = ArrayList<ListaAlarmasViewModel>()

        data.add(
            ListaAlarmasViewModel(
                Alarma(
                id = 1,
                hora = "12:59 PM",
                nombre = "Mi alarma",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )
            )
        )
        data.add(
            ListaAlarmasViewModel(
                Alarma(
                id = 2,
                hora = "12:59 PM",
                nombre = "Huevos",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )
            )
        )
        data.add(
            ListaAlarmasViewModel(
                Alarma(
                id = 3,
                hora = "12:59 PM",
                nombre = "Fontanero",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )
            )
        )
        data.add(
            ListaAlarmasViewModel(
                Alarma(
                id = 4,
                hora = "12:59 PM",
                nombre = "Examen",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )
            )
        )
        data.add(
            ListaAlarmasViewModel(
                Alarma(
                id = 5,
                hora = "12:59 PM",
                nombre = "Primera alarma",
                fecha = null,
                dias = booleanArrayOf(false, true, true, true, true, true, false)
            )
            )
        )

        val adapter = ListaAlarmasAdapter(data)

        binding.alarmasRecyclerView.adapter = adapter

        binding.nuevaAlarmaCard.setOnClickListener {
            requireActivity().run { startActivity(Intent(this, NuevaAlarmaActivity::class.java))
            }

        }

        return binding.root
        //return inflater.inflate(R.layout.fragment_lista_alarmas, container, false)

    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //binding.nuevaAlarmaText.text = "Nueva alarma"
    }

    /*companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListaAlarmasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListaAlarmasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }*/

}