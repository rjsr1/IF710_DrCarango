package com.example.pichau.drcarango

import Data.Oficina
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.pichau.drcarango.databinding.ListaOficinasViewBinding


class OficinasAdapter(var items: List<Oficina>) : RecyclerView.Adapter<OficinasAdapter.ViewHolder>(), AdapterItemsContract{
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding: ListaOficinasViewBinding = ListaOficinasViewBinding.inflate(inflater, parent, false)
        return ViewHolder(binding)
    }

    override fun replaceItems(items: List<*>) {
        this.items = items as List<Oficina>
        notifyDataSetChanged()
    }

    override fun getItemCount(): Int {
        return items.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(items[position])
    }

    class ViewHolder(val binding: ListaOficinasViewBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(oficina: Oficina) {
            binding.recyclerView = oficina
            binding.executePendingBindings()
        }
    }
}