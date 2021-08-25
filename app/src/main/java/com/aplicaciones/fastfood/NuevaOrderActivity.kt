package com.aplicaciones.fastfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class NuevaOrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_nueva_order)

        var idOrder: Int? = null
        if(intent.hasExtra("order")){
            val order = intent.extras?.getSerializable("order")as Order

            pedido_et.setText(order.pedido)
            precio_et.setText(order.precio.toString())
            cantidad_et.setText(order.cantidad)
            fecha_et.setText(order.fecha)
            cliente_et.setText(order.cliente)
            tipoPago_et.setText(order.tipoPago)
            notaOrden_et.setText(order.notaOrden)
            direccion_et.setText(order.direccion)
            referencia_et.setText(order.referencia)
            estadoOrden_et.setText(order.estadoOrden)
            total_et.setText(order.total)
            idOrder = order.idOrder

        }

        val database = AppDatabase.getDatabase(this)

        save_btn.setOnClickListener{
            val pedido = pedido_et.text.toString()
            val precio = precio_et.text.toString().toDouble()
            val cantidad = cantidad_et.text.toString()
            val fecha = fecha_et.text.toStrin()
            val cliente = cliente_et.text.toString()
            val tipoPago = tipoPago_et.text.ToString()
            val notaOrden = notaOrden_et.text.toString()
            val direccion = direccion_et.text.toString()
            val referencia = referencia_et.text.toString()
            val estadoOrden = estadoOrden_et.text.toString()
            val total = total_et.text.toString.toDouble()


            val order = Order( pedido, precio, cantidad, fecha, cliente, tipoPago, notaOrden,
            direccion, referencia, estadoOrden, total, R.drawable.order)

            if( idOrder != null){
                CoroutineScope(Dispatchers.IO).launch{
                    order.idOrder= idOrder
                    database.orders().update(order)
                    this@NuevaOrderActivity.finish()
                }
            }else{
                CoroutineScope(Dispatchers.IO).launch {
                    database.orders().insertAll(order)

                    this@NuevaOrderActivity.finish()
                }
            }

        }
    }
}