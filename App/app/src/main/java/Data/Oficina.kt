package Data

import com.fasterxml.jackson.annotation.JsonProperty


data class Oficina (@JsonProperty("nome") val nome: String,
                    @JsonProperty("endereco") val endereco:String,
                    @JsonProperty("fone") val fone:String,
                    @JsonProperty("promocao") val promocao:String)