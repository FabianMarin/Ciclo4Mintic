package com.kotlindevs.kdmarketf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.fragment.app.Fragment
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import java.lang.ref.Reference

class DetailsProdsFragment : Fragment() {
    private val dataBaseFire= FirebaseFirestore.getInstance()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmentDet=inflater.inflate(R.layout.fragment_details_prods, container, false)
        //val nombre=requireArguments().getString("nombre")
        //val precio=requireArguments().getString("precio")
        //val cantidad=requireArguments().getString("cantidad")
        //val descripcion=requireArguments().getString("descripcion")
        var desc:String?=null
        var imgP:String?=null
        //val categoria=requireArguments().getString("categoria")
        //val urlimg=requireArguments().getString("imagenurl")

        val idDocumentoProd=requireArguments().getString("idProducto")

        val txtNombPr: TextView= fragmentDet.findViewById(R.id.txtNombprodfb)
        val txtPrecioPr: TextView= fragmentDet.findViewById(R.id.txtPrecprodfb)
        val txtCantPr: TextView= fragmentDet.findViewById(R.id.txtCantprodfb)
        var txtDescPr: TextView= fragmentDet.findViewById(R.id.txtDescripprodfb)
        val txtCatPr: TextView= fragmentDet.findViewById(R.id.txtCategprodfb)
        val imgProd: ImageView= fragmentDet.findViewById(R.id.Imgprodfb)
        /*
        txtNombPr.text=nombre
        txtPrecioPr.text=precio
        txtCantPr.text=cantidad
        txtDescPr.text=descripcion
        txtCatPr.text=categoria
         */

        var documentoProdDet=dataBaseFire.collection("products")
            .document(idDocumentoProd.toString())

        documentoProdDet.get().addOnSuccessListener {
            txtNombPr.text = it.get("nombre") as String?
            txtPrecioPr.text = it.get("precio") as String?
            txtCantPr.text = it.get("cantidad") as String?
            txtCatPr.text = it.get("categoria") as String?
            txtDescPr.text = it.get("descripcion") as String?
            imgP=it.get("imagen") as String?

            Glide.with(this)
                .load(imgP)
                .into(imgProd)
        }


        return fragmentDet
    }
}