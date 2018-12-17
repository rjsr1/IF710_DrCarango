package com.example.pichau.drcarango.Usuario

import com.example.pichau.drcarango.Data.Usuario
import com.example.pichau.drcarango.Data.UsuarioDTORequest
import com.example.pichau.drcarango.Services.RestAPIWebService
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class UsuarioViewModel : ViewModel() {

    val webService: RestAPIWebService by lazy {
        RestAPIWebService.create()
    }

    var usuario: MutableLiveData<Usuario> = MutableLiveData()
    var successCadastro: MutableLiveData<Boolean> = MutableLiveData()
    var successLogin:MutableLiveData<Boolean> = MutableLiveData()

    fun login(email: String, senha: String): LiveData<Usuario> {
        loginUser(email, senha)
        return usuario
    }
    fun cadastrar(email: String, senha: String):LiveData<Boolean>{
        cadastrarusuario(email,senha)
        return successCadastro;
    }

    private fun cadastrarusuario(email: String, senha: String) {
        val usuarioDTO = UsuarioDTORequest(email, senha)
        webService.cadastrarUsuario(usuarioDTO).enqueue(object:Callback<Void>{
            override fun onFailure(call: Call<Void>, t: Throwable) {
                successCadastro.value=false
            }

            override fun onResponse(call: Call<Void>, response: Response<Void>) {
                successCadastro.value=true
            }

        })
    }

    private fun loginUser(email: String, senha: String) {
        val usuarioDTO = UsuarioDTORequest(email, senha)
        webService.login(usuarioDTO).enqueue(object : Callback<Usuario> {
            override fun onFailure(call: Call<Usuario>, t: Throwable) {
                successLogin.value=false
                Log.e("webService", " menssagem : " + t.message + " causa :  " + t.cause)
                Log.e("WebService", "falha ao carregar informações do usuario")
            }

            override fun onResponse(call: Call<Usuario>, response: Response<Usuario>) {
                successLogin.value=true;
                usuario.value = response.body()
            }

        })
    }
}