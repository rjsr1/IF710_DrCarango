package com.example.pichau.drcarango.Data

import com.fasterxml.jackson.annotation.JsonProperty

data class Comentario(@JsonProperty("cliente") val cliente: Int,
                      @JsonProperty("nome") val nome: String,
                      @JsonProperty("comentario") val comentario: String,
                      @JsonProperty("nota") val nota: Double,
                      @JsonProperty("oficina") val oficina: Int)