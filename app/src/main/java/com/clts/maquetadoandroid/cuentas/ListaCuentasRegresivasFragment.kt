package com.clts.maquetadoandroid.cuentas

import android.content.Context
import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.clts.maquetadoandroid.NuevaAlarmaActivity
import com.clts.maquetadoandroid.NuevaCuentaRegresivaActivity
import com.clts.maquetadoandroid.R
import com.clts.maquetadoandroid.data.CuentaRegresiva
import com.clts.maquetadoandroid.databinding.FragmentListaCuentasRegresivasBinding

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [ListaCuentasRegresivasFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaCuentasRegresivasFragment : Fragment() {

    private lateinit var binding: FragmentListaCuentasRegresivasBinding
    private var thisContext: Context? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        thisContext = container?.context
        binding = FragmentListaCuentasRegresivasBinding.inflate(inflater, container, false)
        binding.nuevaCuentaRegresivaText.text = "Nueva Cuenta Regresiva"

        val data = ArrayList<ListaCuentasRegresivasViewModel>()

        data.add(ListaCuentasRegresivasViewModel(CuentaRegresiva(
            id = 1,
            dias = "99",
            tiempo = "23:59:59",
            nombre = "Segunda cuenta"
        )))
        data.add(ListaCuentasRegresivasViewModel(CuentaRegresiva(
            id = 2,
            dias = "99",
            tiempo = "23:59:59",
            nombre = "Grabacion"
        )))
        data.add(ListaCuentasRegresivasViewModel(CuentaRegresiva(
            id = 3,
            dias = "99",
            tiempo = "23:59:59",
            nombre = "Otra cuenta"
        )))
        data.add(ListaCuentasRegresivasViewModel(CuentaRegresiva(
            id = 4,
            dias = "99",
            tiempo = "23:59:59",
            nombre = "Sorpresa"
        )))
        data.add(ListaCuentasRegresivasViewModel(CuentaRegresiva(
            id = 5,
            dias = "99",
            tiempo = "23:59:59",
            nombre = "Fin de siesta"
        )))

        val adapter = ListaCuentasRegresivasAdapter(data)

        binding.cuentasRegresivasRecyclerView.adapter = adapter

        binding.nuevaCuentaRegresivaCard.setOnClickListener {
            requireActivity().run { startActivity(Intent(this,NuevaCuentaRegresivaActivity::class.java)) }
        }

        return binding.root

        //return inflater.inflate(R.layout.fragment_lista_cuentas_regresivas, container, false)
    }

    companion object {
        /**
         * Use this factory method to create a new instance of
         * this fragment using the provided parameters.
         *
         * @param param1 Parameter 1.
         * @param param2 Parameter 2.
         * @return A new instance of fragment ListaCuentasRegresivasFragment.
         */
        // TODO: Rename and change types and number of parameters
        @JvmStatic
        fun newInstance(param1: String, param2: String) =
            ListaCuentasRegresivasFragment().apply {
                arguments = Bundle().apply {
                    putString(ARG_PARAM1, param1)
                    putString(ARG_PARAM2, param2)
                }
            }
    }
}