package com.example.pichau.drcarango

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.pichau.drcarango.R.id.btn_login
import kotlinx.android.synthetic.main.activity_login.*
import org.jetbrains.anko.find

class Login : AppCompatActivity() {
    lateinit var blogin:Button
    lateinit var bcadastrar:Button
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        bcadastrar=btn_cadastrar
        blogin = btn_login
        blogin.setOnClickListener({v->
            val intent= Intent(this,SignInActivity::class.java)
            startActivity(intent)
        })
        bcadastrar.setOnClickListener({v->
            val intent= Intent(this,CadastrarActivity::class.java)
            startActivity(intent)
        })

    }
}
