package com.example.pichau.drcarango.Data

import com.fasterxml.jackson.annotation.JsonProperty


data class Usuario (@JsonProperty("email") val email: String,
                    @JsonProperty("senha") val senha:String,
                    @JsonProperty("nome") val nome:String,
                    @JsonProperty("id") val id:String)