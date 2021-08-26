package com.aplicaciones.fastfood

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName= "orders")
class Order (

    val pedido: String,
    val precio: Double,
    val cantidad: Double,
    val fecha: String,
    val cliente: String,
    val tipoPago: String,
    val direccion: String,
    val referencia: String,
    val estadoOrden: String,
    val total: Double,
    val imagen: Int,

    @PrimaryKey(autoGenerate = true)
    var idOrder: Int=0

        ): Serializable