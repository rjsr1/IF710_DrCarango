package com.example.pichau.drcarango.ListaOficinas

import com.example.pichau.drcarango.Data.Oficina
import com.example.pichau.drcarango.Services.RestAPIWebService
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class ListaOficinasViewModel : ViewModel() {

    val webService: RestAPIWebService by lazy {
        RestAPIWebService.create()
    }

    private lateinit var oficinas: MutableLiveData<List<Oficina>>

    //var repoListOficinas: OficinasRepository()


    fun getOficinas(): LiveData<List<Oficina>> {
        if (!::oficinas.isInitialized) {
            oficinas = MutableLiveData()
            loadOficinas()
        }
        return oficinas
    }

    private fun loadOficinas() {
        //Usar Depois o Repository
        webService.getOficinas("1").enqueue(object : Callback<List<Oficina>> {
            override fun onFailure(call: Call<List<Oficina>>, t: Throwable) {
                Log.e("error", "erro consulta webservice. Mensagem : " + t.message + "StackTrace : " + t.stackTrace)
            }

            override fun onResponse(call: Call<List<Oficina>>, response: Response<List<Oficina>>) {
                oficinas.value = response.body()

            }

        })
    }
}