package com.example.pichau.drcarango.Data

import com.fasterxml.jackson.annotation.JsonProperty

data class UsuarioDTORequest (@JsonProperty("email") val email: String,
                    @JsonProperty("senha") val senha:String
                    )