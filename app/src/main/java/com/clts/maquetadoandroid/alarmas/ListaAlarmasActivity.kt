package com.clts.maquetadoandroid.alarmas

import android.content.Context
import android.os.Bundle
import android.view.LayoutInflater
import android.view.MenuItem
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.activity.viewModels
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView

import com.clts.maquetadoandroid.ListaAlarmasViewModel
import com.clts.maquetadoandroid.R
import com.clts.maquetadoandroid.ViewPagerAdapter
import com.clts.maquetadoandroid.data.Alarma
import com.clts.maquetadoandroid.databinding.ActivityListaAlarmasBinding
import com.google.android.material.navigation.NavigationView
import com.google.android.material.tabs.TabLayoutMediator

//const val ALARMA_ID = "alarma_id"

val tabNames = arrayOf("Alarmas", "Cuentas Regresivas")

class ListaAlarmasActivity : AppCompatActivity() {

    /*private var _binding: ActivityListaAlarmasBinding? = null
    private val binding get() = _binding!!
    private val listaAlarmasViewModel by viewModels<ListaAlarmasViewModel>()
    private var thisContext: Context? = null*/

    private lateinit var binding: ActivityListaAlarmasBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_lista_alarmas)

        //val recyclerView = findViewById<RecyclerView>(R.id.alarmas_recyclerView)

        //recyclerView.layoutManager = LinearLayoutManager(this)

        //val data = ArrayList<ListaAlarmasViewModel>()

        binding = ActivityListaAlarmasBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            setSupportActionBar(findViewById(R.id.main_toolbar))

            toggle = ActionBarDrawerToggle(this@ListaAlarmasActivity, drawerLayout, R.string.open_drawer, R.string.close_drawer)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)


        }




        setupViewPager()
        setupTabLayout()


        //val adapter = ListaAlarmasAdapter(data)

        //recyclerView.adapter = adapter

        /*val nuevaAlarmaTextView: TextView = findViewById<TextView>(R.id.nueva_alarma_text)
        nuevaAlarmaTextView.text = "Nueva alarma"*/

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

    private fun setupTabLayout() {
        TabLayoutMediator(
            binding.tabLayout, binding.viewPager
        ) { tab, position -> tab.text = tabNames[position] }.attach()
    }


    private fun setupViewPager() {
        val adapter = ViewPagerAdapter(this, 2)
        binding.viewPager.adapter = adapter
    }

    override fun onBackPressed() {
        val viewPager = binding.viewPager
        if (viewPager.currentItem == 0) {
            // If the user is currently looking at the first step, allow the system to handle the
            // Back button. This calls finish() on this activity and pops the back stack.
            super.onBackPressed()
        } else {
            // Otherwise, select the previous step.
            viewPager.currentItem = viewPager.currentItem - 1
        }
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (toggle.onOptionsItemSelected(item)){
            true
        }
        return super.onOptionsItemSelected(item)
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