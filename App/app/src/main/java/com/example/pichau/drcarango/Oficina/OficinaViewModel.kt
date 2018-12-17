package com.example.pichau.drcarango.Oficina


import com.example.pichau.drcarango.Data.Oficina
import com.example.pichau.drcarango.Services.RestAPIWebService
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.arch.lifecycle.ViewModel
import android.util.Log
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class OficinaViewModel:ViewModel(){
val webService: RestAPIWebService by lazy {
    RestAPIWebService.create()
}

var oficina: MutableLiveData<Oficina> = MutableLiveData()


    fun getOficinaData(id:Int):LiveData<Oficina>{
        getOficina(id)
        return oficina
    }

    private fun getOficina(idOficina:Int){
        webService.getOficina(idOficina).enqueue(object : Callback<Oficina> {
            override fun onFailure(call: Call<Oficina>, t: Throwable) {
                Log.e("webService"," menssagem : "+t.message+" causa :  "+t.cause)
                Log.e("WebService", "falha ao carregar informações do usuario")
            }

            override fun onResponse(call: Call<Oficina>, response: Response<Oficina>) {

                oficina.value = response.body()

                Log.d("webService",oficina.value.toString())
            }

        })
    }
}