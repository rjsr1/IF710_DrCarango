package com.example.pichau.drcarango

import Data.Oficina
import ListaOficinas.ListaOficinasViewModel
import ListaOficinas.OficinaListAdapter
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.util.Log
import kotlinx.android.synthetic.main.activity_lista_oficinas.*

class ListaOficinasActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_lista_oficinas)
        val recyclerView = oficina_list_recyclerview
        val adapter = OficinaListAdapter(emptyList(), this)
        val layoutManager =  LinearLayoutManager(this)
        recyclerView.layoutManager = layoutManager
        recyclerView.adapter=adapter
        recyclerView.setHasFixedSize(true)
        val model = ViewModelProviders.of(this).get(ListaOficinasViewModel::class.java)
        model.getOficinas().observe(this, Observer<List<Oficina>> {oficinas ->
            Log.d("debug",oficinas?.get(0)?.fone)
            Log.d("debug","OficinasAtualizadas")
            adapter.loadItems(oficinas?:emptyList())
        })
    }
}
