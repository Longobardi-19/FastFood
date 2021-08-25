package com.aplicaciones.fastfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import androidx.lifecycle.LiveData
import androidx.lifecycle.Observer
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.activity_order.*

class OrderActivity : AppCompatActivity() {

    private lateinit var database: AppDatabase
    private lateinit var order: Order
    private  lateinit var orderLiveData: LiveData<Order>


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)

        database = AppDatabase.getDatabase(this)
        val idOrder = intent.getIntExtra("id",0)

        orderLiveData = database.orders().get(idOrder)

        orderLiveData.observe(this, Observer {
            order = it
            pedido_order.text = order.pedido
            order_id.text = order.idOrder.toString()
            precio_order.text = "S/.${order.precio}"
            cantidad_order.text = order.cantidad.toString()
            fecha_order.text = order.fecha
            cliente_order.text = order.cliente
            tipoPago_order.text = order.tipoPago
            notaOrden_order.text = order.notaOrden
            direccion_order.text = order.direccion
            referencia_order.text = order.referencia
            estadoOrden_order.text = order.estadoOrden

        })


    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.order_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.edit_item -> {
                val intent = Intent(this, NuevaOrderActivity::class.java)
                intent.putExtra("order", order)
                startActivity(intent)
            }

            R.id.delete_item -> {
                orderLiveData.removeObservers(this)

                CoroutineScope(Dispatchers.IO).launch {
                    database.orders().delete(order)
                    this@OrderActivity.finish()
                }
            }

        }

        return super.onOptionsItemSelected(item)
    }
}