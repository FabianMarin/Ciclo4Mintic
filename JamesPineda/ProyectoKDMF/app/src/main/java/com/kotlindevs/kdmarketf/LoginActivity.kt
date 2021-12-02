package com.kotlindevs.kdmarketf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.analytics.FirebaseAnalytics
import com.google.firebase.auth.FirebaseAuth

class LoginActivity : AppCompatActivity() {
    private var edtUsername: EditText? = null
    private var edtPassword: EditText? = null
    private var btnlogin: Button? = null
    private var btnregister: Button? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        val analitycs: FirebaseAnalytics = FirebaseAnalytics.getInstance(this)
        val bundle = Bundle()
        bundle.putString("message", "Integ de fireb completa")
        analitycs.logEvent("InitScreen", bundle)

        edtUsername = findViewById(R.id.edittxtuserlogin)
        edtPassword = findViewById(R.id.edittxtpasslogin)
        btnlogin = findViewById(R.id.btnacceptlogin)
        btnregister = findViewById(R.id.btnacceptreg)
    }

    fun registrando(view: android.view.View) {
        val intento = Intent(this, RegisterActivity::class.java)
        startActivity(intento)
    }
        fun logueando(view: android.view.View) {
            var username: String = edtUsername!!.text.toString()
            var password: String = edtPassword!!.text.toString()
            var ingreso = Intent(this, PerfilActivity::class.java)
            if (username.isNotEmpty() && password.isNotEmpty()) {
                FirebaseAuth.getInstance().signInWithEmailAndPassword(username, password)
                    .addOnCompleteListener {
                        if (it.isSuccessful) {
                            Toast.makeText(applicationContext,("Logueo valido"), Toast.LENGTH_SHORT).show()
                            startActivity(ingreso)
                        } else {
                            showAlert()
                        }
                    }
            }
        }

        private fun showAlert() {
            val builder = AlertDialog.Builder(this)
            builder.setTitle("Error")
            builder.setMessage("no se pudo autenticar")
            builder.setPositiveButton("Aceptar", null)
            val dialog: AlertDialog = builder.create()
            dialog.show()
        }

    fun recupclave(view: android.view.View) {
        var username: String = edtUsername!!.text.toString()
        FirebaseAuth.getInstance().sendPasswordResetEmail(username)
        Toast.makeText(applicationContext,("Se oprimio recuperacion de clave"),
            Toast.LENGTH_SHORT).show()

    }
}
