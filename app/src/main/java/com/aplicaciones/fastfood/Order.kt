package com.aplicaciones.fastfood

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName= "orders")
class Order (

    val pedido: String,
    val precio: Double,
    val cantidad: Int,
    val fecha: Date,
    val cliente: String,
    val tipoPago: String,
    val notaOrden: String,
    val direccion: String,
    val referencia: String,
    val estadoOrden: String,
    val imagen: Int,
    val total: Double,
    @PrimaryKey(autoGenerate = true)
    var idOrder: Int=0

        ): Serializable