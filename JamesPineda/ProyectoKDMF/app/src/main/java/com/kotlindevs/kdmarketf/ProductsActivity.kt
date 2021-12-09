package com.kotlindevs.kdmarketf

import android.content.ContentValues
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DividerItemDecoration
import androidx.recyclerview.widget.RecyclerView
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

        var prodsNombres: ArrayList<String> = ArrayList()
        var prodsPrecios: ArrayList<String> = ArrayList()

        dataBaseFire.collection("products")
            .get()
            .addOnSuccessListener { result ->
                for (document in result) {
                    prodsNombres.add(document.data["nombre"] as String)
                    prodsPrecios.add(document.data["precio"] as String)
                }
                info.putStringArrayList("Producto",prodsNombres)
                info.putStringArrayList("Precio",prodsPrecios)

                listRecyclerView= requireView().findViewById(R.id.recyclerProducts)
                ptAdapter=ProdsListAdapter(activity as AppCompatActivity, info)
                listRecyclerView.setHasFixedSize(true)
                listRecyclerView.adapter=ptAdapter
                listRecyclerView.addItemDecoration(DividerItemDecoration(context,DividerItemDecoration.VERTICAL))
            }
            .addOnFailureListener { exception ->
                Log.w(ContentValues.TAG, "Error getting documents.", exception)
            }
    }
}