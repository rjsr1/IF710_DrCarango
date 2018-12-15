package Services

import Data.Oficina
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.GET
import retrofit2.http.Path

interface RestAPIWebService{


    @GET("/oficinas/{tipoRanking}")
    fun getOficinas(@Path("tipoRanking") tipoRanking:String): Call<List<Oficina>>

    //companion object that initialize retrofit
    companion object {
        fun create(): RestAPIWebService {

            val retrofit = Retrofit.Builder()
                   .addConverterFactory(
                           JacksonConverterFactory.create())
                    .baseUrl("https://drcarangoback.herokuapp.com/")
                    .build()

            return retrofit.create(RestAPIWebService::class.java)
        }
    }
}