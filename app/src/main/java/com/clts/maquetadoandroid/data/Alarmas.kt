package com.clts.maquetadoandroid.data

import android.content.res.Resources

fun alarmaList(resources: Resources): List<Alarma> {
    return listOf(
        Alarma(
            id = 1,
            hora = "12:59 PM",
            nombre = "Segunda alarma",
            fecha = "2 Mayo 2022",
            dias = null
        ),
        Alarma(
            id = 2,
            hora = "12:59 PM",
            nombre = "Mi alarma",
            fecha = null,
            dias = booleanArrayOf(false, true, true, true, true, true, false)
        ),
        Alarma(
            id = 3,
            hora = "12:59 PM",
            nombre = "Huevos",
            fecha = null,
            dias = booleanArrayOf(false, true, true, true, true, true, false)
        ),
        Alarma(
            id = 4,
            hora = "12:59 PM",
            nombre = "Fontanero",
            fecha = null,
            dias = booleanArrayOf(false, true, true, true, true, true, false)
        ),
        Alarma(
            id = 5,
            hora = "12:59 PM",
            nombre = "Examen",
            fecha = null,
            dias = booleanArrayOf(false, true, true, true, true, true, false)
        ),
        Alarma(
            id = 6,
            hora = "12:59 PM",
            nombre = "Primera alarma",
            fecha = null,
            dias = booleanArrayOf(false, true, true, true, true, true, false)
        )
    )
}