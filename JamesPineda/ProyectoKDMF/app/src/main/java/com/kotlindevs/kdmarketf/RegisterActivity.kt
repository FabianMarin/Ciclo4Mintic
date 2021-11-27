package com.kotlindevs.kdmarketf

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast
import androidx.appcompat.app.AlertDialog
import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.firestore.FirebaseFirestore

class RegisterActivity : AppCompatActivity() {
    private val dataBaseFire=FirebaseFirestore.getInstance()

    private var edtUsername: EditText? = null
    private var edtPassword: EditText? = null
    private var btnregister: Button? = null
    private var edtConfirmPass: EditText? = null
    private var edtNombres: EditText? = null
    private var edtApellidos: EditText? = null
    private var edtTelefono: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        edtUsername = findViewById(R.id.edittxtuserreg)
        edtPassword = findViewById(R.id.edittxtpassreg)
        btnregister = findViewById(R.id.btnreg)
        edtConfirmPass = findViewById(R.id.edittxtcpassreg)
        edtNombres = findViewById(R.id.edittxtnombresreg)
        edtApellidos = findViewById(R.id.edittxtteelfreg)
        edtTelefono = findViewById(R.id.edittxtapellidosreg)
    }

    fun onTerms(view: android.view.View) {}
    fun onRegister(view: android.view.View) {
        var username: String = edtUsername!!.text.toString()
        var password: String = edtPassword!!.text.toString()
        if (username.isNotEmpty() && password.isNotEmpty()) {
            FirebaseAuth.getInstance().createUserWithEmailAndPassword(username, password)
                .addOnCompleteListener {
                    if (it.isSuccessful) {
                        Toast.makeText(applicationContext,("Registro satisfactorio"), Toast.LENGTH_SHORT).show()
                        guardarReg()
                        val intento = Intent(this, PerfilActivity::class.java)
                        startActivity(intento)
                    } else {
                        showAlert()
                    }
                }
        }
    }

    private fun guardarReg() {
        dataBaseFire.collection("users").document(edtUsername!!.text.toString()).set(
            hashMapOf(
                "emailUser" to edtUsername!!.text.toString(),
                "nombres" to edtNombres!!.text.toString(),
                "apellidos" to edtApellidos!!.text.toString(),
                "telefono" to edtTelefono!!.text.toString()
            )
        )
    }


    private fun showAlert() {
        val builder = AlertDialog.Builder(this)
        builder.setTitle("Error")
        builder.setMessage("no se pudo autenticar")
        builder.setPositiveButton("Aceptar", null)
        val dialog: AlertDialog = builder.create()
        dialog.show()
    }
}