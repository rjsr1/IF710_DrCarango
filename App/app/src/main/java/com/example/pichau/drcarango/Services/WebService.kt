package com.example.pichau.drcarango.Services

import com.example.pichau.drcarango.Data.Comentario
import com.example.pichau.drcarango.Data.Oficina
import com.example.pichau.drcarango.Data.Usuario
import com.example.pichau.drcarango.Data.UsuarioDTORequest
import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.jackson.JacksonConverterFactory
import retrofit2.http.Body
import retrofit2.http.GET
import retrofit2.http.POST
import retrofit2.http.Path

interface RestAPIWebService{

    @GET(value="oficina/{id}/comentarios")
    fun getComentarios(@Path("id") id:Int):Call<List<Comentario>>

    @GET("/oficina/{id}")
    fun getOficina(@Path("id") id:Int):Call<Oficina>

    @GET("/oficinas/{tipoRanking}")
    fun getOficinas(@Path("tipoRanking") tipoRanking:String): Call<List<Oficina>>

    @POST("usuario/login")
    fun login(@Body usuario:UsuarioDTORequest):Call<Usuario>
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