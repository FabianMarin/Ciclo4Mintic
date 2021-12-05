package com.kotlindevs.kdmarketf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.TextView
import com.google.firebase.firestore.FirebaseFirestore

class MarketActivity : AppCompatActivity() {
    private val dataBaseFire= FirebaseFirestore.getInstance()

    private var rnombProd: TextView? = null
    private var precProd: TextView? = null
    private var cantProd: TextView? = null
    private var descrProd: TextView? = null
    private var categProd: TextView? = null
    private var ingreRefProd: EditText? = null

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_market)


        rnombProd=findViewById(R.id.txtNombprodfb)
        precProd=findViewById(R.id.txtPrecprodfb)
        cantProd=findViewById(R.id.txtCantprodfb)
        descrProd=findViewById(R.id.txtDescripprodfb)
        categProd=findViewById(R.id.txtCategprodfb)
        ingreRefProd=findViewById(R.id.edtRefprod)
    }
    fun TraerInfoProd() {
        var documento: String = ingreRefProd!!.text.toString()
        dataBaseFire.collection("products").document(documento).
        get().addOnSuccessListener {
            rnombProd!!.text = it.get("nombre") as String?
            precProd!!.text = it.get("precio") as String?
            cantProd!!.text = it.get("cantidad") as String?
            descrProd!!.text = it.get("descripcion") as String?
            categProd!!.text = it.get("categoria") as String?
    }
    }
    fun traerInfo(view: android.view.View) {
        TraerInfoProd()
    }
}
