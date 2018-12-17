package com.example.pichau.drcarango.Oficina


import com.example.pichau.drcarango.Data.Oficina
import com.example.pichau.drcarango.Services.RestAPIWebService
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import com.example.pichau.drcarango.Data.Comentario
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OficinaViewModel : ViewModel() {
    val webService: RestAPIWebService by lazy {
        RestAPIWebService.create()
    }

    var oficina: MutableLiveData<Oficina> = MutableLiveData()
    var comentarios:MutableLiveData<List<Comentario>> = MutableLiveData()

    fun getComentarios(id:Int):LiveData<List<Comentario>>{
        getComentarioData(id)
        return comentarios
    }
    fun getOficinaData(id: Int): LiveData<Oficina> {
        getOficina(id)
        return oficina
    }

    private fun getOficina(idOficina: Int) {
        webService.getOficina(idOficina).enqueue(object : Callback<Oficina> {
            override fun onFailure(call: Call<Oficina>, t: Throwable) {
                Log.e("webService", " menssagem : " + t.message + " causa :  " + t.cause)
                Log.e("WebService", "falha ao carregar informações do usuario")
            }

            override fun onResponse(call: Call<Oficina>, response: Response<Oficina>) {
                oficina.value = response.body()
            }

        })
    }
    private fun getComentarioData(idOficina:Int){
        webService.getComentarios(idOficina).enqueue(object:Callback<List<Comentario>>{
            override fun onFailure(call: Call<List<Comentario>>, t: Throwable) {
                Log.d("webService","erro ao receber comentarios de oficina")
            }

            override fun onResponse(call: Call<List<Comentario>>, response: Response<List<Comentario>>) {
                comentarios.value=response.body()
            }

        })
    }
}