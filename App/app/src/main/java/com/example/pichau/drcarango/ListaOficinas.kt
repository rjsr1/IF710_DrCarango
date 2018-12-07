package com.example.pichau.drcarango

import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.app.AppCompatActivity
import kotlinx.android.synthetic.main.lista_oficinas.*

class ListaOficinasActivity: AppCompatActivity(){
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.lista_oficinas)

        addFragmentTo(R.id.content_frame, createFragment())
        setSupportActionBar(toolbar)
    }
    fun createViewModel(): OficinasViewModel {
        return OficinasViewModel()
    }

    fun createFragment(): OficinasFragment {
        return OficinasFragment.newInstance(createViewModel())
    }
    fun AppCompatActivity.addFragmentTo(containerId: Int, fragment: Fragment, tag: String = "") {
        supportFragmentManager.beginTransaction().add(containerId, fragment, tag).commit()
    }

}