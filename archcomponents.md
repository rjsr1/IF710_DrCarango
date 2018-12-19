Usado arquitetura sugerida pela documentação. 
- Acesso ao servidor eh feito pelo WebService, utilizando retrofit2.
- As Views utilizam componentes viewmodel para observar mudanças nos dados.
- Os viewmodels fazem chamada ao WebService e atualizam os livedatas.

Exemplo:

Em lista de oficinas, a lista é um livedata de List<Oficina>. 
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

O viewModel é responsável por fazer a chamada ao webservice, que por sua vez utiliza o retrofit para fazer requisição ao servidor.
A view então exibe a lista mais atualizada de oficinas, chamando o metodo loadItems ao observar a mudança na lista de oficinas. 

fun loadItems(novasOficinas: List<Oficina>) {
        oficinas = novasOficinas
        notifyDataSetChanged()
    }



