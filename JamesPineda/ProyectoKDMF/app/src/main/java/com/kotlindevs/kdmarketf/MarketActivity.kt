package com.kotlindevs.kdmarketf

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.EditText
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class MarketActivity : AppCompatActivity() {

    private val dataBaseFire= FirebaseFirestore.getInstance()


    private var imgtxtprod: TextView? = null
    private var imagenprod: ImageView? = null
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
        imagenprod=findViewById(R.id.Imgprodfb)
        imgtxtprod=findViewById(R.id.txtImgprod)

    }

    fun TraerInfoProd() {
        var documento: String = ingreRefProd!!.text.toString()
        dataBaseFire.collection("products").document(documento).
        get().addOnSuccessListener {
            rnombProd!!.text = it.get("nombre") as String?
            descrProd!!.text = it.get("descripcion") as String?
            categProd!!.text = it.get("categoria") as String?
            imgtxtprod!!.text = it.get("imagen") as String?
    }
    }

    fun traerInfo(view: android.view.View) {
        TraerInfoProd()
        setImg()
    }
    fun setImg() {
        /*
        Glide.with(this)
            .load(imgtxtprod).into(findViewById(R.id.Imgprodfb));

         */

        Glide.with(this)
            .load("https://firebasestorage.googleapis.com/v0/b/progbasicac4.appspot.com/o/iphone2.jpg?alt=media&token=dafcf7a5-815b-4469-b731-56d30127f438")
            .into(findViewById(R.id.Imgprodfb));
    }
}
