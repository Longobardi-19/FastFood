package com.aplicaciones.fastfood

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu

class OrderActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_order)
    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {
        menuInflater.inflate(R.menu.order_menu, menu)

        return super.onCreateOptionsMenu(menu)
    }


}