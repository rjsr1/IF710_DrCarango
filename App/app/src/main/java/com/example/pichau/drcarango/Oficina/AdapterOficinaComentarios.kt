package com.example.pichau.drcarango.Oficina

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.pichau.drcarango.Data.Comentario
import com.example.pichau.drcarango.Data.Oficina
import com.example.pichau.drcarango.ListaOficinas.OficinaListAdapter
import com.example.pichau.drcarango.R
import kotlinx.android.synthetic.main.comentario_item.view.*

class OficinaListComentario (private val oficinasList: List<Comentario>, private val context: Context) : RecyclerView.Adapter<OficinaListComentario.ViewHolderComentario>() {



    var comentarios: List<Comentario> = emptyList()

    fun loadItems(novosComentarios: List<Comentario>) {
        comentarios = novosComentarios
        notifyDataSetChanged()
    }
    override fun onBindViewHolder(holder: ViewHolderComentario, position: Int) {
        val comentario=comentarios.get(position)
        holder.comentario.setText(comentario.comentario)
        holder.nome.setText(comentario.nome)
        holder.nota.setText(comentario.nota.toString())

    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolderComentario {
        val view = LayoutInflater.from(context).inflate(R.layout.comentario_item, parent, false)
        return ViewHolderComentario(view)
    }

    override fun getItemCount(): Int {
        return comentarios.size
    }



    class ViewHolderComentario(itemView: View):RecyclerView.ViewHolder(itemView
    ){
        val comentario=itemView.tv_comentario
        val nome=itemView.tv_nome
        val nota=itemView.tv_nota

    }
}
