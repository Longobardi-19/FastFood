package com.aplicaciones.fastfood

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.WindowManager
import android.widget.Toast
import com.aplicaciones.fastfood.databinding.ActivityLoginBinding
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.ktx.auth
import com.google.firebase.ktx.Firebase

class LoginActivity : AppCompatActivity() {

    private lateinit var auth : FirebaseAuth
    private  lateinit var binding: ActivityLoginBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityLoginBinding.inflate(layoutInflater)

        setContentView(binding.root)
        auth = Firebase.auth

        binding.button.setOnClickListener{
            val mEmail = binding.editTextUsername.text.toString()
            val mPassword = binding.editTextPassword.text.toString()

            when{
                mEmail.isEmpty() || mPassword.isEmpty()-> {
                    Toast.makeText(baseContext, "Ingresa los datos",
                        Toast.LENGTH_SHORT).show()
                }else ->{
                    logIn(mEmail,mPassword)
                }
            }
        }

    }
   public override fun onStart() {
        super.onStart()
       val currentUser = auth.currentUser
       if(currentUser != null){
            reload();
        }
    }

    private fun logIn(email: String, password : String){
        auth.signInWithEmailAndPassword(email, password)
            .addOnCompleteListener(this) { task ->
                if (task.isSuccessful) {
                    Log.d("TAG", "signInWithEmail:success")
                    reload()

                } else {
                    Log.w("TAG", "signInWithEmail:failure", task.exception)
                    Toast.makeText(baseContext, "Datos Incorrectos",
                        Toast.LENGTH_SHORT).show()

                }
            }
    }

   private fun reload(){
      val intent = Intent (this, MainActivity::class.java)
      this.startActivity(intent)
   }
}