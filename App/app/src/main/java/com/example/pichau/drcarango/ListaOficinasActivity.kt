package com.example.pichau.drcarango

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.os.Bundle
import android.support.v4.widget.DrawerLayout
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import android.view.View
import com.example.pichau.drcarango.Data.Oficina
import com.example.pichau.drcarango.ListaOficinas.ListaOficinasViewModel
import com.example.pichau.drcarango.ListaOficinas.OficinaListAdapter
import kotlinx.android.synthetic.main.activity_lista_oficinas.*
import org.jetbrains.anko.toast

class ListaOficinasActivity : AppCompatActivity(), OficinaListAdapter.onItemClickListener {

    lateinit var mAdapterOficina: OficinaListAdapter

    override fun onItemClickListener(V: View, pos: Int) {
        val intent = Intent(this, PerfilOficinaActivity::class.java)
        intent.putExtra("id", mAdapterOficina.oficinas.get(pos).id)
        startActivity(intent)
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_lista_oficinas)
        val recyclerView = oficina_list_recyclerview
        val adapter = OficinaListAdapter(emptyList(), this, this)
        mAdapterOficina = adapter
        val layoutManager = LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter = adapter
        recyclerView.setHasFixedSize(true)
        val model = ViewModelProviders.of(this).get(ListaOficinasViewModel::class.java)
        model.getOficinas().observe(this, Observer<List<Oficina>> { oficinas ->
            adapter.loadItems(oficinas ?: emptyList())
        })
    }
}
