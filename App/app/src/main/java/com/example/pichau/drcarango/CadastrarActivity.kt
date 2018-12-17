package com.example.pichau.drcarango

import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.EditText
import android.widget.ProgressBar
import com.example.pichau.drcarango.Usuario.UsuarioViewModel
import kotlinx.android.synthetic.main.activity_cadastrar.*
import org.jetbrains.anko.doAsync
import org.jetbrains.anko.doAsyncResult
import org.jetbrains.anko.toast

class CadastrarActivity : AppCompatActivity() {

    lateinit var  bCadastrar: Button
    lateinit var  mPGCadastrar:ProgressBar
    lateinit var mETEmail: EditText;
    lateinit var mETSenha: EditText;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastrar)
        mETEmail= et_email_cadastrar
        mETSenha = et_password_cadastrar
        mPGCadastrar = pg_cadastrar
        val model = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)
        bCadastrar = btn_set_cadastrar
        bCadastrar.setOnClickListener({v->
           pg_cadastrar.visibility= View.VISIBLE
           model.cadastrar(mETEmail.text.toString(),mETSenha.text.toString())
        })

        val observerCadastro= Observer<Boolean>{success->
            if(success!!){
                mPGCadastrar.visibility=View.GONE
                val intent = Intent(this,Login::class.java)
                startActivity(intent)
            }else{
                toast("erro ao cadastrar usuario")
            }


        }
        model.successCadastro.observe(this,observerCadastro)
    }
}
