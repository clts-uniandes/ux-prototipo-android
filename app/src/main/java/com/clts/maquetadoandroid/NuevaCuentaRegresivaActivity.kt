package com.clts.maquetadoandroid

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Button
import androidx.appcompat.widget.Toolbar
import com.clts.maquetadoandroid.MisRecordatoriosActivity

import com.clts.maquetadoandroid.databinding.ActivityNuevaCuentaRegresivaBinding

class NuevaCuentaRegresivaActivity : AppCompatActivity() {

    private lateinit var binding: ActivityNuevaCuentaRegresivaBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //setContentView(R.layout.activity_nueva_cuenta_regresiva)
        binding = ActivityNuevaCuentaRegresivaBinding.inflate(layoutInflater)
        val view = binding.root
        setContentView(view)

        //setSupportActionBar(binding.nuevaCuentaRegresivaToolbar)

        val myToolbar = findViewById<Toolbar>(R.id.nueva_cuenta_regresiva_toolbar)
        setSupportActionBar(myToolbar)


        supportActionBar?.apply {
            title = "Nueva Cuenta Regresiva"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val cancelarButton =findViewById<Button>(R.id.countdown_cancel_button)
        val crearButton = findViewById<Button>(R.id.countdown_create_button)

        cancelarButton.setOnClickListener {
            this.finish()
        }

        crearButton.setOnClickListener {
            //val intent = Intent(this, ListaAlarmasActivity::class.java)
            //startActivity(intent)
            finish()
        }

        setupNumberPickerDays()
        setupNumberPickerHours()
        setupNumberPickerMinSec()

    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        this.finish()
        return super.onOptionsItemSelected(item)
    }

    private fun setupNumberPickerDays() {
        val numberPicker = binding.numberpickerDays
        val values = arrayOf("00","01","02","03","04","05","06","07","08","09",
            "10","11","12","13","14","15","16","17","18","19",
            "20","21","22","23","24","25","26","27","28","29",
            "30","31","32","33","34","35","36","37","38","39",
            "40","41","42","43","44","45","46","47","48","49",
            "50","51","52","53","54","55","56","57","58","59",
            "60","61","62","63","64","65","66","67","68","69",
            "70","71","72","73","74","75","76","77","78","79",
            "80","81","82","83","84","85","86","87","88","89",
            "90","91","92","93","94","95","96","97","98","99")
        numberPicker.minValue = 0
        numberPicker.maxValue = values.size-1
        numberPicker.displayedValues = values
        numberPicker.wrapSelectorWheel = true
        /*numberPicker.setOnValueChangedListener { picker, oldVal, newVal ->
            val text = "Changed from $oldVal to $newVal"
            Toast.makeText(this@NuevaCuentaRegresivaActivity, text, Toast.LENGTH_SHORT).show()
        }*/
    }

    private fun setupNumberPickerHours() {
        val numberPickerHours = binding.numberpickerHours
        val values = arrayOf("00","01","02","03","04","05","06","07","08","09",
            "10","11","12","13","14","15","16","17","18","19",
            "20","21","22","23")
        numberPickerHours.minValue = 0
        numberPickerHours.maxValue = values.size-1
        numberPickerHours.displayedValues = values
        numberPickerHours.wrapSelectorWheel = true
    }

    private fun setupNumberPickerMinSec() {
        val numberPickerMinutes = binding.numberpickerMinutes
        val numberPickerSeconds = binding.numberpickerSeconds
        val values = arrayOf("00","01","02","03","04","05","06","07","08","09",
            "10","11","12","13","14","15","16","17","18","19",
            "20","21","22","23","24","25","26","27","28","29",
            "30","31","32","33","34","35","36","37","38","39",
            "40","41","42","43","44","45","46","47","48","49",
            "50","51","52","53","54","55","56","57","58","59")
        numberPickerMinutes.minValue = 0
        numberPickerMinutes.maxValue = values.size-1
        numberPickerMinutes.displayedValues = values
        numberPickerSeconds.minValue = 0
        numberPickerSeconds.maxValue = values.size-1
        numberPickerSeconds.displayedValues = values
        numberPickerSeconds.wrapSelectorWheel = true
        numberPickerSeconds.wrapSelectorWheel = true
    }

}