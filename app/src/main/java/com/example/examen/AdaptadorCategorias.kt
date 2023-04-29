package com.example.examen

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

open class AdaptadorCategorias(private val myDataList: List<ItemCategoria>) : RecyclerView.Adapter<AdaptadorCategorias.MyViewHolder>() {

    inner class MyViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
    }

    fun getItem(position: Int): ItemCategoria {
        return myDataList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return MyViewHolder(view).apply {
            view.setOnClickListener {
                //Índice del elemento
                val position = bindingAdapterPosition

                //Item específico
                val item = getItem(position)
            }
        }
    }

    override fun onBindViewHolder(holder: MyViewHolder, position: Int) {
        holder.titleTextView.text = myDataList[position].title
    }

    override fun getItemCount(): Int {
        return myDataList.size
    }
}
