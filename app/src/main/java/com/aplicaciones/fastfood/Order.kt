package com.aplicaciones.fastfood

import androidx.room.Entity
import androidx.room.PrimaryKey
import java.io.Serializable
import java.util.*


@Entity(tableName= "orders")
class Order (

    val nom_pedido: String,
    val precio: Double,
    val cantidad: Int,
    val fecha: Date,
    val cliente: String,
    val tipo_pago: String,
    val nota_orden: String,
    val direccion: String,
    val referencia: String,
    val estado_orden: String,
    @PrimaryKey(autoGenerate = true)
    var idOrder: Int=0

        ): Serializable