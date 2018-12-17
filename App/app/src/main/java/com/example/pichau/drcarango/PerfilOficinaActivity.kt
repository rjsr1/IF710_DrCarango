package com.example.pichau.drcarango

import com.example.pichau.drcarango.Data.Oficina
import com.example.pichau.drcarango.Oficina.OficinaViewModel
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_perfil_oficina.*

class PerfilOficinaActivity : AppCompatActivity() {


    lateinit var mNomeOficina: TextView;
    lateinit var mEnderecoOficina: TextView;
    lateinit var mFoneOficina: TextView;
    lateinit var mPromocaoOficina: TextView;



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_oficina)


        mNomeOficina=tv_nome_oficina
        mFoneOficina=tv_fone_oficina
        mEnderecoOficina=tv_endereco_oficina
        mPromocaoOficina=tv_promocao_oficina

        val model = ViewModelProviders.of(this).get(OficinaViewModel::class.java)
        model.getOficinaData(intent.extras.getInt("id")).observe(this, Observer<Oficina> {
            oficina->
            mNomeOficina.setText(oficina?.nome)
            mEnderecoOficina.setText(oficina?.endereco)
            mPromocaoOficina.setText(oficina?.promocao)
            mFoneOficina.setText(oficina?.fone)

        })
    }


}
