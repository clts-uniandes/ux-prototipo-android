package com.clts.maquetadoandroid

import android.os.Bundle
import android.view.MenuItem
import android.view.View
import android.widget.Button
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import com.google.android.material.snackbar.Snackbar
import androidx.appcompat.app.AppCompatActivity
import androidx.appcompat.widget.Toolbar
import androidx.navigation.findNavController
import androidx.navigation.ui.AppBarConfiguration
import androidx.navigation.ui.navigateUp
import com.clts.maquetadoandroid.databinding.ActivityNuevaAlarmaBinding
import com.google.android.material.datepicker.MaterialDatePicker
import com.google.android.material.switchmaterial.SwitchMaterial
import com.google.android.material.textfield.TextInputLayout
import com.google.android.material.timepicker.MaterialTimePicker
import com.google.android.material.timepicker.TimeFormat
import java.text.SimpleDateFormat
import java.util.*

class NuevaAlarmaActivity : AppCompatActivity() {

    private lateinit var appBarConfiguration: AppBarConfiguration
    private lateinit var binding: ActivityNuevaAlarmaBinding

    var flag_domingo = false
    var flag_lunes = true
    var flag_martes = true
    var flag_miercoles = true
    var flag_jueves = true
    var flag_viernes = true
    var flag_sabado = false

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        binding = ActivityNuevaAlarmaBinding.inflate(layoutInflater)
        setContentView(binding.root)

        setSupportActionBar(binding.nuevaAlarmaToolbar)

        val myToolbar = findViewById<Toolbar>(R.id.nueva_alarma_toolbar)
        setSupportActionBar(myToolbar)

        supportActionBar?.apply {
            title = "Nueva Alarma"
            setDisplayHomeAsUpEnabled(true)
            setDisplayShowHomeEnabled(true)
        }

        val textoHora = findViewById<TextView>(R.id.newAlarmTimeTextView)

        val cancelarButton = findViewById<Button>(R.id.alarm_cancel_button)
        val crearButton = findViewById<Button>(R.id.alarm_create_button)

        val domingoToggle = findViewById<ImageView>(R.id.image_sunday)
        val lunesToggle = findViewById<ImageView>(R.id.image_monday)
        val martesToggle = findViewById<ImageView>(R.id.image_tuesday)
        val miercolesToggle = findViewById<ImageView>(R.id.image_wednesday)
        val juevesToggle = findViewById<ImageView>(R.id.image_thursday)
        val viernesToggle = findViewById<ImageView>(R.id.image_friday)
        val sabadoToggle = findViewById<ImageView>(R.id.image_sunday)

        val repetirToggle = findViewById<SwitchMaterial>(R.id.repetir_semana_switch)
        val fechaToggle = findViewById<SwitchMaterial>(R.id.disparar_fecha_switch)

        val contenedorSemana = findViewById<LinearLayout>(R.id.semana_layout)
        val contenedorFecha = findViewById<LinearLayout>(R.id.fecha_layout)
        val campoFecha = findViewById<TextInputLayout>(R.id.alarm_date_textInputLayout)
        val recibeFecha = findViewById<TextView>(R.id.fechaTextInput)

        textoHora.setOnClickListener {
            val timePicker: MaterialTimePicker = MaterialTimePicker.Builder().setTitleText("A")
                // set the default hour for the
                // dialog when the dialog opens
                .setHour(12)
                // set the default minute for the
                // dialog when the dialog opens
                .setMinute(10)
                // set the time format
                // according to the region
                .setTimeFormat(TimeFormat.CLOCK_12H)
                .build()
            timePicker.show(supportFragmentManager, "")
            timePicker.addOnPositiveButtonClickListener {

                val pickedHour: Int = timePicker.hour
                val pickedMinute: Int = timePicker.minute

                // check for single digit hour hour and minute
                // and update TextView accordingly
                val formattedTime: String = when {
                    pickedHour > 12 -> {
                        if (pickedMinute < 10) {
                            "${timePicker.hour - 12}:0${timePicker.minute} PM"
                        } else {
                            "${timePicker.hour - 12}:${timePicker.minute} PM"
                        }
                    }
                    pickedHour == 12 -> {
                        if (pickedMinute < 10) {
                            "${timePicker.hour}:0${timePicker.minute} PM"
                        } else {
                            "${timePicker.hour}:${timePicker.minute} PM"
                        }
                    }
                    pickedHour == 0 -> {
                        if (pickedMinute < 10) {
                            "${timePicker.hour + 12}:0${timePicker.minute} AM"
                        } else {
                            "${timePicker.hour + 12}:${timePicker.minute} AM"
                        }
                    }
                    else -> {
                        if (pickedMinute < 10) {
                            "${timePicker.hour}:0${timePicker.minute} AM"
                        } else {
                            "${timePicker.hour}:${timePicker.minute} AM"
                        }
                    }
                }

                // then update the preview TextView
                textoHora.text = formattedTime
            }
        }

        cancelarButton.setOnClickListener {
            this.finish()
        }

        crearButton.setOnClickListener {
            //val intent = Intent(this, ListaAlarmasActivity::class.java)
            //startActivity(intent)
            finish()
        }

        domingoToggle.setOnClickListener {
            if (flag_domingo) {
                domingoToggle.setImageResource(R.drawable.week_day_d_full)
                flag_domingo = false
            } else {
                domingoToggle.setImageResource(R.drawable.week_day_d)
                flag_domingo = true
            }
        }

        lunesToggle.setOnClickListener {
            if (flag_lunes) {
                lunesToggle.setImageResource(R.drawable.week_day_l_full)
                flag_lunes = false
            } else {
                lunesToggle.setImageResource(R.drawable.week_day_l)
                flag_lunes = true
            }
        }

        martesToggle.setOnClickListener {
            if (flag_martes) {
                martesToggle.setImageResource(R.drawable.week_day_m_full)
                flag_martes = false
            } else {
                martesToggle.setImageResource(R.drawable.week_day_m)
                flag_martes = true
            }
        }

        miercolesToggle.setOnClickListener {
            if (flag_miercoles) {
                miercolesToggle.setImageResource(R.drawable.week_day_m_full)
                flag_miercoles = false
            } else {
                miercolesToggle.setImageResource(R.drawable.week_day_m)
                flag_miercoles = true
            }
        }

        juevesToggle.setOnClickListener {
            if (flag_jueves) {
                juevesToggle.setImageResource(R.drawable.week_day_j_full)
                flag_jueves = false
            } else {
                juevesToggle.setImageResource(R.drawable.week_day_j)
                flag_jueves = true
            }
        }

        viernesToggle.setOnClickListener {
            if (flag_viernes) {
                viernesToggle.setImageResource(R.drawable.week_day_v_full)
                flag_viernes = false
            } else {
                viernesToggle.setImageResource(R.drawable.week_day_v)
                flag_viernes = true
            }
        }

        sabadoToggle.setOnClickListener {
            if (flag_sabado) {
                sabadoToggle.setImageResource(R.drawable.week_day_s_full)
                flag_sabado = false
            } else {
                sabadoToggle.setImageResource(R.drawable.week_day_s)
                flag_sabado = true
            }
        }

        repetirToggle.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                contenedorSemana.visibility = View.VISIBLE
                contenedorFecha.visibility = View.GONE
            } else {
                contenedorSemana.visibility = View.GONE
                contenedorFecha.visibility = View.VISIBLE
            }
        }

        fechaToggle.setOnCheckedChangeListener { compoundButton, b ->
            if (b) {
                campoFecha.visibility = View.VISIBLE
            } else {
                campoFecha.visibility = View.GONE
            }
        }

        recibeFecha.setOnClickListener {
            val datePicker = MaterialDatePicker.Builder.datePicker()
                .setSelection(MaterialDatePicker.todayInUtcMilliseconds())
                .build()
            datePicker.show(supportFragmentManager, "Escoja fecha")
            datePicker.addOnPositiveButtonClickListener {
                val dateFormatter = SimpleDateFormat("dd/MM/yyyy")
                val cal = Calendar.getInstance()
                cal.time = Date(it)
                cal.add(Calendar.DATE, 1)
                recibeFecha.text = dateFormatter.format(cal.time)
            }
        }


    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        this.finish()
        return super.onOptionsItemSelected(item)
    }

    /*override fun onSupportNavigateUp(): Boolean {
        val navController = findNavController(R.id.nav_host_fragment_content_nueva_alarma)
        return navController.navigateUp(appBarConfiguration)
                || super.onSupportNavigateUp()
    }*/
}