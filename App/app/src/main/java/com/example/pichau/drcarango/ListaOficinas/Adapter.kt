package com.example.pichau.drcarango.ListaOficinas

import com.example.pichau.drcarango.Data.Oficina
import android.content.Context
import android.support.v7.widget.RecyclerView
import android.support.v7.widget.RecyclerView.Adapter
import android.view.LayoutInflater
import android.view.View
import android.view.View.OnClickListener
import android.view.ViewGroup
import com.example.pichau.drcarango.R
import kotlinx.android.synthetic.main.oficina_item.view.*

class OficinaListAdapter(private val oficinasList: List<Oficina>, private val context: Context, private val mItemListClickListener: onItemClickListener) : Adapter<OficinaListAdapter.ViewHolder>() {


    interface onItemClickListener {
        fun onItemClickListener(V: View, pos: Int)
    }

    var oficinas: List<Oficina> = emptyList()

    fun loadItems(novasOficinas: List<Oficina>) {
        oficinas = novasOficinas
        notifyDataSetChanged()
    }


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(context).inflate(R.layout.oficina_item, parent, false)
        return ViewHolder(view, mItemListClickListener)

    }

    override fun getItemCount(): Int {
        return oficinas.size//To change body of created functions use File | Settings | File Templates.
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val oficina = oficinas.get(position)
        holder.nome.setText(oficina.nome)
        holder.endereco.setText(oficina.endereco)
        holder.fone.setText(oficina.fone)
        holder.promocao.setText(oficina.promocao)
    }


    class ViewHolder(itemView: View, clickListener: onItemClickListener) : RecyclerView.ViewHolder(itemView), OnClickListener {
        val clickListener = clickListener
        var mItemView = itemView

        init {
            mItemView.setOnClickListener(this)
        }


        override fun onClick(v: View?) {
            clickListener.onItemClickListener(mItemView, adapterPosition)
        }

        val nome = itemView.tv_nome_oficina_perfil
        val endereco = itemView.tv_endereco_oficina
        val fone = itemView.tv_fone_oficina
        val promocao = itemView.tv_promocao_oficina
    }
}

