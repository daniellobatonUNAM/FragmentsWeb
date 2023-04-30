package com.example.examen

import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class AdaptadorOpciones(private val myDataList: List<ItemOpcion>) :
    RecyclerView.Adapter<AdaptadorOpciones.ViewHolder>() {

    private lateinit var nombreOpcion: String
    private lateinit var urlOpcion: String
    var onItemClickListener: AdaptadorOpciones.OnItemClickListener? = null


    interface OnItemClickListener {
        fun onItemClick2(item: ItemOpcion)
    }

    inner class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val titleTextView: TextView = view.findViewById(R.id.opcionTitulo)
        fun bind(item: ItemOpcion) {
            itemView.setOnClickListener {
                onItemClickListener?.onItemClick2(item)
            }
        }
    }

    fun getItem(position: Int): ItemOpcion {
        return myDataList[position]
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        val view = LayoutInflater.from(parent.context).inflate(R.layout.opcion_layout, parent, false)

        return ViewHolder(view).apply {
            view.setOnClickListener {
                //Índice del elemento
                val position = bindingAdapterPosition

                //Item específico
                val item = getItem(position)
            }
        }

    }

    override fun onBindViewHolder(holder: AdaptadorOpciones.ViewHolder, position: Int) {
        val item: ItemOpcion = myDataList[position]
        holder.titleTextView.text = item.title
        holder.titleTextView.text = item.title
        holder.bind(item)
    }

    override fun getItemCount(): Int {
        return myDataList.size
    }


}