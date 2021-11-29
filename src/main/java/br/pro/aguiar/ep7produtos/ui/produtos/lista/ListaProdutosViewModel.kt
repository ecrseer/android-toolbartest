package br.pro.aguiar.ep7produtos.ui.produtos.lista

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pro.aguiar.ep7produtos.models.Produto
import br.pro.aguiar.ep7produtos.repository.ProdutoDao

class ListaProdutosViewModel : ViewModel() {

    private val _produtos: MutableLiveData<List<Produto>> by lazy {
        MutableLiveData<List<Produto>>()
    }
    val produtos: LiveData<List<Produto>> = _produtos

    init {
        consultarProdutos()
    }

    private fun consultarProdutos(){
        // escopo de chamada assíncrona
        _produtos.value = ProdutoDao.listar()
    }

}