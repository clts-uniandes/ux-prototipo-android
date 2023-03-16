package com.clts.maquetadoandroid.data

data class Alarma(

    val id: Int,
    val hora: String,
    val nombre: String?,
    val fecha: String?,
    val dias: BooleanArray?
)