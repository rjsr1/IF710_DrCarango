package com.example.pichau.drcarango


import com.example.pichau.drcarango.Data.Usuario
import com.example.pichau.drcarango.Usuario.UsuarioViewModel
import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.View
import android.widget.EditText
import android.widget.ProgressBar
import kotlinx.android.synthetic.main.activity_sign_in.*


class SignInActivity : AppCompatActivity(),View.OnClickListener{


    override fun onClick(v: View?) {
        mProgressBar.visibility=View.VISIBLE
        modelUsuarioViewModel.login(mETEmail.text.toString(),mETSenha.text.toString())
    }

    lateinit var loginButton:View;
    lateinit var mETEmail:EditText;
    lateinit var mETSenha:EditText;
    lateinit var modelUsuarioViewModel: UsuarioViewModel;
    lateinit var mProgressBar:ProgressBar

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_sign_in)
        loginButton = btn_set_login
        mETEmail=et_email as EditText
        mETSenha=et_password as EditText
        mProgressBar=pg_signin as ProgressBar
        loginButton.setOnClickListener(this)
        val model = ViewModelProviders.of(this).get(UsuarioViewModel::class.java)
        modelUsuarioViewModel=model

        val UsuarioObserver = Observer<Usuario> { usuario->
            Log.d("ViewModel",usuario.toString())
            mProgressBar.visibility=View.GONE
            val intent = Intent(this,ListaOficinasActivity::class.java)
            startActivity(intent)
        }
        model.usuario.observe(this,UsuarioObserver)


    }
}
