package com.kotlindevs.kdmarketf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.google.firebase.firestore.FirebaseFirestore

class ProdsListAdapter(context: AppCompatActivity,
   val info: Bundle) : RecyclerView.Adapter<ProdsListAdapter.ProdViewHolder>()
{
    private val dataBaseFire= FirebaseFirestore.getInstance()
    class ProdViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    private var context: AppCompatActivity = context

    //private var prodsNombres : ArrayList<String> = info.getStringArrayList("Producto") as ArrayList<String>
    //private var prodsPrecios : ArrayList<String> = info.getStringArrayList("Precio") as ArrayList<String>
    //private var prodsCantidad : ArrayList<String> = info.getStringArrayList("Cantidad") as ArrayList<String>
    //private var prodsCategoria : ArrayList<String> = info.getStringArrayList("Categoria") as ArrayList<String>
    //private var prodsImgs : ArrayList<String> = info.getStringArrayList("ImagenUrl") as ArrayList<String>
    private var prodsIds : ArrayList<String> = info.getStringArrayList("IdsProds") as ArrayList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdViewHolder {
        val layout=LayoutInflater.from(parent.context).inflate(R.layout.products_list,
        parent,false)
        return ProdViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ProdViewHolder, position: Int) {
        val nombProd=holder.layout.findViewById<TextView>(R.id.txtprodnom)
        //nombProd.text=prodsNombres[position]
        val precProd=holder.layout.findViewById<TextView>(R.id.txtprodprec)
        //precProd.text=prodsPrecios[position]
        //val prodsCant=prodsCantidad[position]
        //val prodsCatg=prodsCategoria[position]
        val imgProd=holder.layout.findViewById<ImageView>(R.id.imageProdView)
        val prodsIdsPr=prodsIds[position]

        dataBaseFire.collection("products").document(prodsIdsPr.toString())
            .get().addOnSuccessListener {
            nombProd.text = it.get("nombre") as String?
            precProd.text = it.get("precio") as String?
            val urlImgP=it.get("imagen") as String?

                Glide.with(context).load(urlImgP)
                    .into(holder.layout.findViewById(R.id.imageProdView))
        }



        holder.layout.setOnClickListener{
            val datosDetProd = Bundle()

            //datosDetProd.putString("nombre",prodsNombres[position])
            //datosDetProd.putString("precio",prodsPrecios[position])
            //datosDetProd.putString("cantidad",prodsCant)
            //datosDetProd.putString("imagenurl",prodsImgs[position])
            datosDetProd.putString("idProducto",prodsIdsPr)
            //datosDetProd.putString("categoria",prodsCatg)

            context.supportFragmentManager
            .beginTransaction()
            .setReorderingAllowed(true)
                .replace(R.id.frmContaineracfs,
                    DetailsProdsFragment::class.java,datosDetProd,"detail")
                .addToBackStack("")
                .commit()
        }
    }
    override fun getItemCount(): Int {
        return prodsIds.size
    }
}