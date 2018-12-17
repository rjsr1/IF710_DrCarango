package  com.example.pichau.drcarango

import com.example.pichau.drcarango.Data.Oficina
import com.example.pichau.drcarango.Oficina.OficinaViewModel
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.support.v7.widget.RecyclerView
import android.view.View
import android.widget.Button
import android.widget.ProgressBar
import android.widget.TextView
import com.example.pichau.drcarango.Data.Comentario
import com.example.pichau.drcarango.ListaOficinas.OficinaListAdapter
import com.example.pichau.drcarango.Oficina.OficinaListComentario
import kotlinx.android.synthetic.main.activity_perfil_oficina.*

class PerfilOficinaActivity : AppCompatActivity(),View.OnClickListener {
    override fun onClick(v: View?) {
       if(v?.id==btnMaps.id  ){
           LoadMap()
       }
    }

    private fun LoadMap() {
        intent= Intent(this,MapsActivity::class.java)
        intent.putExtra("lat",mOficina.lat)
        intent.putExtra("lng",mOficina.lng)
        startActivity(intent)
    }


    lateinit var mNomeOficina: TextView;
    lateinit var mEnderecoOficina: TextView;
    lateinit var mFoneOficina: TextView;
    lateinit var mPromocaoOficina: TextView;
    lateinit var mPGPerfilOficina:ProgressBar
    lateinit var recyclerViewcomentarios:RecyclerView
    lateinit var btnMaps:Button
    lateinit var btnComentar:Button
    lateinit var mOficina:Oficina

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_perfil_oficina)
        recyclerViewcomentarios=rv_comentarios_oficina
        mNomeOficina=tv_nome_oficina_perfil
        mFoneOficina=tv_fone_oficina
        mEnderecoOficina=tv_endereco_oficina
        mPromocaoOficina=tv_promocao_oficina
        mPGPerfilOficina=progressBar_PerfilOficina
        btnMaps=btn_abrir_maps
        btnComentar=btn_comentar
        btnMaps.setOnClickListener(this)
        val model = ViewModelProviders.of(this).get(OficinaViewModel::class.java)
        mPGPerfilOficina.visibility=View.VISIBLE
        val adapterComentarios= OficinaListComentario(emptyList(),this)
        val layoutManager = LinearLayoutManager(this)
        recyclerViewcomentarios.layoutManager = layoutManager
        recyclerViewcomentarios.adapter = adapterComentarios
        recyclerViewcomentarios.setHasFixedSize(true)

        model.getOficinaData(intent.extras.getInt("id")).observe(this, Observer<Oficina> {
            oficina->
            mOficina= oficina!!
            mNomeOficina.setText(oficina.nome)
            mEnderecoOficina.setText(oficina.endereco)
            mPromocaoOficina.setText(oficina.promocao)
            mFoneOficina.setText(oficina.fone)
            mPGPerfilOficina.visibility=View.GONE
        })
        model.getComentarios(intent.extras.getInt("id")).observe(this,Observer<List<Comentario>>{comentarios->
            adapterComentarios.loadItems(comentarios?: emptyList())
        })
    }


}
