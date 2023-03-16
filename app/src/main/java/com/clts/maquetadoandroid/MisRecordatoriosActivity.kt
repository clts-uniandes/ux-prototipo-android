package com.clts.maquetadoandroid

import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.appcompat.app.AppCompatActivity

import com.clts.maquetadoandroid.R
import com.clts.maquetadoandroid.ViewPagerAdapter

import com.clts.maquetadoandroid.databinding.ActivityMisRecordatoriosBinding
import com.google.android.material.tabs.TabLayoutMediator

//const val ALARMA_ID = "alarma_id"

val tabNames = arrayOf("Alarmas", "Cuentas Regresivas")

class MisRecordatoriosActivity : AppCompatActivity() {



    private lateinit var binding: ActivityMisRecordatoriosBinding
    private lateinit var toggle: ActionBarDrawerToggle

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_lista_alarmas)

        //val recyclerView = findViewById<RecyclerView>(R.id.alarmas_recyclerView)

        //recyclerView.layoutManager = LinearLayoutManager(this)

        //val data = ArrayList<ListaAlarmasViewModel>()

        binding = ActivityMisRecordatoriosBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.apply {

            setSupportActionBar(findViewById(R.id.main_toolbar))

            toggle = ActionBarDrawerToggle(this@MisRecordatoriosActivity, drawerLayout, R.string.open_drawer, R.string.close_drawer)
            drawerLayout.addDrawerListener(toggle)
            toggle.syncState()

            supportActionBar?.setDisplayHomeAsUpEnabled(true)


        }




        setupViewPager()
        setupTabLayout()



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


}