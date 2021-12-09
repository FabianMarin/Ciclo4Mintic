package com.kotlindevs.kdmarketf

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.RecyclerView

class ProdsListAdapter(context: AppCompatActivity,
   val info: Bundle) : RecyclerView.Adapter<ProdsListAdapter.ProdViewHolder>()
{
    class ProdViewHolder(val layout: View): RecyclerView.ViewHolder(layout)

    private var context: AppCompatActivity = context

    var prodsNombres : ArrayList<String> = info.getStringArrayList("Producto") as ArrayList<String>
    var prodsPrecios : ArrayList<String> = info.getStringArrayList("Precio") as ArrayList<String>

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ProdViewHolder {
        val layout=LayoutInflater.from(parent.context).inflate(R.layout.products_list,
        parent,false)
        return ProdViewHolder(layout)
    }

    override fun onBindViewHolder(holder: ProdViewHolder, position: Int) {
        var nombProd=holder.layout.findViewById<TextView>(R.id.txtprodnom)
        nombProd.text=prodsNombres[position]
        var precProd=holder.layout.findViewById<TextView>(R.id.txtprodprec)
        precProd.text=prodsPrecios[position]

    }

    override fun getItemCount(): Int {
        return prodsNombres.size
    }
}