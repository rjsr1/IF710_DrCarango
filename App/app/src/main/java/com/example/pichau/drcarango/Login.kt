package com.example.pichau.drcarango

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import com.example.pichau.drcarango.R.id.btn_login

class Login : AppCompatActivity() {
    lateinit var blogin:View

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)
        blogin = findViewById(btn_login)
        blogin.setOnClickListener({v->
            val intent= Intent(this,SignInActivity::class.java)
            startActivity(intent)
        })
    }
}
