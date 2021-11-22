package com.kotlindevs.kdmarketf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.google.firebase.auth.FirebaseAuth

class PerfilActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)
    }
    fun cerrarsesion(view: android.view.View) {
        FirebaseAuth.getInstance().signOut()
        onBackPressed()
        val cerrandoses = Intent(this, MainActivity::class.java)
        startActivity(cerrandoses)
    }
}