package com.kotlindevs.kdmarketf

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore
import com.google.firebase.firestore.QueryDocumentSnapshot
import com.google.firebase.firestore.QuerySnapshot

class ProductsActivity : Fragment() {
    private val dataBaseFire= FirebaseFirestore.getInstance()

    var info:Bundle= Bundle()
    private lateinit var listRecyclerView: RecyclerView
    private lateinit var ptAdapter: RecyclerView.Adapter<ProdsListAdapter.ProdViewHolder>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val fragmento: View = inflater.inflate(R.layout.activity_products, container, false)
        return fragmento
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        //var prodsNombres: ArrayList<String> = ArrayList()
        //var prodsPrecios: ArrayList<String> = ArrayList()
        //var prodsCantidad: ArrayList<String> = ArrayList()
        //var prodsCategoria: ArrayList<String> = ArrayList()
        //var urlProductos: ArrayList<String> = ArrayList()
        var idsProductos: ArrayList<String> = ArrayList()

        dataBaseFire.collection("products")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    idsProductos.add(document.id as String)
                    //prodsNombres.add(document.data["nombre"] as String)
                    //prodsPrecios.add(document.data["precio"] as String)
                    //prodsCantidad.add(document.data["cantidad"] as String)
                    //prodsCategoria.add(document.data["categoria"] as String)
                    //urlProductos.add(document.data["imagen"] as String)
                }
                //info.putStringArrayList("Producto",prodsNombres)
                //info.putStringArrayList("Precio",prodsPrecios)
                //info.putStringArrayList("Cantidad",prodsCantidad)
                //info.putStringArrayList("Categoria",prodsCategoria)
                //info.putStringArrayList("ImagenUrl",urlProductos)
                info.putStringArrayList("IdsProds",idsProductos)

                adaptarDatos()
                }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents.", exception)
            }
    }
    private fun adaptarDatos(){
        listRecyclerView= requireView().findViewById(R.id.recyclerProducts)
        ptAdapter=ProdsListAdapter(activity as AppCompatActivity, info)
        listRecyclerView.setHasFixedSize(true)
        listRecyclerView.adapter=ptAdapter
        listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
    }

}