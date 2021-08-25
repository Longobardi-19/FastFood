package com.aplicaciones.fastfood

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ArrayAdapter
import kotlinx.android.synthetic.main.item_order.view.*

class OrderAdapter (private val mContext: Context,
                    private val listaOrders: List<Order>):
    ArrayAdapter<Order>(mContext, 0,listaOrders){
       override fun getView(position: Int, convertView: View?, parent: ViewGroup):View{
           val layout = LayoutInflater.from(mContext).inflate(R.layout.item_order,parent, false)
            val order = listaOrders[position]

           layout.pedido.text = order.pedido
           layout.precio.text = "S/.${order.precio}"
           layout.imageView.setImageResource(order.imagen)
           return layout
       }
    }