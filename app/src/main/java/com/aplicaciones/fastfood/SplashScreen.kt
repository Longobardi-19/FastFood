package com.aplicaciones.fastfood

import android.app.Activity
import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Handler
import android.view.WindowManager
import android.view.animation.Animation
import android.view.animation.AnimationUtils
import android.widget.ImageView

class SplashScreen : Activity() {
    val SPLASH_CREEN = 4000
    private lateinit var desplazamiento_arriba: Animation
    private lateinit var desplazamiento_abajo: Animation

    private lateinit var  imageView: ImageView
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        window.setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN)
        setContentView(R.layout.activity_splash_screen)


        desplazamiento_arriba = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_arriba)
        desplazamiento_abajo = AnimationUtils.loadAnimation(this, R.anim.desplazamiento_abajo)

        imageView = findViewById(R.id.logoImageView)

        imageView.animation = desplazamiento_arriba

        Handler().postDelayed({
            val intent = Intent(this, LoginActivity::class.java)
            startActivity(intent)
            finish()
        }, SPLASH_CREEN.toLong())

        

    }
}