package com.example.erropadenda

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView

class ItemAdapter(private val erropaList: List<Erropa>) : RecyclerView.Adapter<ItemAdapter.ItemViewHolder>() {

    // ViewHolder que contiene la vista de cada elemento
    class ItemViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textView: TextView = itemView.findViewById(R.id.itemTextView)
    }

    // Crear y retornar el ViewHolder para cada elemento
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_layout, parent, false)
        return ItemViewHolder(view)
    }

    // Vincular los datos con la vista
    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        val erropa = erropaList[position]
        holder.textView.text = erropa.izena
    }

    // Número total de elementos en la lista
    override fun getItemCount(): Int {
        return erropaList.size
    }
}