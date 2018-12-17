package Repository

import com.example.pichau.drcarango.Data.Oficina
import com.example.pichau.drcarango.Services.RestAPIWebService
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.MutableLiveData
import android.util.Log
import retrofit2.Call
import retrofit2.Response
import retrofit2.Callback



class OficinasRepository(){
    val webService:RestAPIWebService by lazy{
        RestAPIWebService.create()
    }
    fun getOficinas(tipoRanking:String):LiveData<List<Oficina>> {
        val data:MutableLiveData<List<Oficina>> by lazy{
            MutableLiveData<List<Oficina>>()
        }

        webService.getOficinas(tipoRanking).enqueue(object:Callback<List<Oficina>> {
            override fun onFailure(call: Call<List<Oficina>>, t: Throwable) {
                Log.e("error","erro consulta webservice. Mensagem : "+t.message + "StackTrace : "+t.stackTrace)
            }

            override fun onResponse(call: Call<List<Oficina>>, response: Response<List<Oficina>>) {
                data.value=response.body()
            }

        })
        //data.value=webService.getOficinas(tipoRanking).execute().body()

        return data
        }


    }


