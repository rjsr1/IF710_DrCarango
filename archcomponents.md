Usado arquitetura sugerida pela documentação. 
- Acesso ao servidor eh feito pelo WebService, utilizando retrofit2.
- As Views utilizam componentes viewmodel para observar mudanças nos dados.
- Os viewmodels fazem chamada ao WebService e atualizam os livedatas.

Exemplo:

Em lista de oficinas, a lista é um livedata de List<Oficina>. O viewModel é responsável por fazer a chamada ao webservice, que por sua vez utiliza o retrofit para fazer requisição ao servidor.
O viewmodel então ao receber a lista, atualiza o adapter da RecyclerView.
A view então exibe a lista mais atualizada de oficinas.
