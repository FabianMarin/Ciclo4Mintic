package com.kotlindevs.kdmarketf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    fun onLogin(view: android.view.View) {
        val intento= Intent(this, LoginActivity::class.java)
        startActivity(intento)
    }

    fun onRegister(view: android.view.View) {
        val intenreg= Intent(this, RegisterActivity::class.java)
        startActivity(intenreg)
    }

    fun onListaProds(view: android.view.View) {
        val intenprods= Intent(this, FragmentosActivity::class.java)
        startActivity(intenprods)
    }

}