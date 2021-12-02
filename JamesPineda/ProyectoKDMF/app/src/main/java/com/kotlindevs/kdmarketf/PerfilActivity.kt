package com.kotlindevs.kdmarketf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class PerfilActivity : AppCompatActivity() {
    private val dataBaseFire= FirebaseFirestore.getInstance()
    private var user: String?=null
    private var edtemailPerf: TextView? = null
    private var edtTelefonoPerf: TextView? = null
    private var edtNombresPerf: TextView? = null
    private var edtApellidosPerf: TextView? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil)

        user=getIntent().getStringExtra("valor")
        edtemailPerf = findViewById(R.id.emaTw)
        edtTelefonoPerf = findViewById(R.id.telfTw)
        edtNombresPerf = findViewById(R.id.nombTw)
        edtApellidosPerf = findViewById(R.id.apellTw)

        devolverReg()
    }
    fun cerrarsesion(view: android.view.View) {
        FirebaseAuth.getInstance().signOut()
        onBackPressed()
        val cerrandoses = Intent(this, MainActivity::class.java)
        startActivity(cerrandoses)

    }

    private fun devolverReg() {
        dataBaseFire.collection("users").document(user.toString()).
        get().addOnSuccessListener {
            edtemailPerf!!.text = it.get("emailUser") as String?
            edtTelefonoPerf!!.text = it.get("telefono") as String?
            edtNombresPerf!!.text = it.get("nombres") as String?
            edtApellidosPerf!!.text = it.get("apellidos") as String?
        }
    }

}