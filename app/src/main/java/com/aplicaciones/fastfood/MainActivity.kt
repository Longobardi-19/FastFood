package com.aplicaciones.fastfood

import android.content.DialogInterface
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.Menu
import androidx.appcompat.app.AlertDialog
import androidx.lifecycle.Observer
import com.aplicaciones.fastfood.databinding.ActivityMainBinding
import com.google.firebase.FirebaseAppLifecycleListener
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    private lateinit var auth: FirebaseAuth
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        auth = Firebase.auth

        var listaOrders = emptyList<Order>()

        val database = AppDatabase.getDatabase(this)

        database.orders().getAll().observe(this, Observer {
            listaOrders = it

            val adapter = OrderAdapter(this, listaOrders)

            lista.adapter = adapter
        })

        lista.setOnItemClickListener { parent, view, position, id ->
            val intent = Intent(this, OrderActivity::class.java)
            intent.putExtra("id", listaOrders[position].idOrder)
            startActivity(intent)

        }
        btn_agregar.setOnClickListener {
            val intent = Intent(this, NuevaOrderActivity::class.java)
            startActivity(intent)
        }


        binding.salir.setOnClickListener{
            signOut()
        }

    }

    private fun signOut(){
        Firebase.auth.signOut()
        val intent = Intent(this, LoginActivity::class.java)
        startActivity(intent)
    }



}