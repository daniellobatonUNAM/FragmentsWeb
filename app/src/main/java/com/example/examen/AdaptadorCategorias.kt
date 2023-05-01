package com.example.examen

import android.content.Context
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.AdapterView
import android.widget.Spinner
import android.widget.TextView
import android.widget.Toast
import androidx.recyclerview.widget.RecyclerView

open class AdaptadorCategorias(private val myDataList: List<ItemCategoria>) :
    RecyclerView.Adapter<AdaptadorCategorias.ViewHolder>() {

    private lateinit var nombreItem: String
    var onItemClickListener: OnItemClickListener? = null

    interface OnItemClickListener {
        fun onItemClick1(item: ItemCategoria)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.titleTextView)
        fun bind(item: ItemCategoria) {
            itemView.setOnClickListener {
                setNombreItem(item.title)
                onItemClickListener?.onItemClick1(item)
            }
        }
    }

    fun setNombreItem(nombre: String){
        nombreItem = nombre
    }

    fun getItem(position: Int): ItemCategoria {
        return myDataList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)

        return ViewHolder(view).apply {
            view.setOnClickListener {
                //Índice del elemento
                val position = bindingAdapterPosition

                //Item específico
                val item = getItem(position)
            }
        }

    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val item: ItemCategoria = myDataList[position]
        holder.titleTextView.text = item.title
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return myDataList.size
    }
}
