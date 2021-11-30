package br.pro.aguiar.ep7produtos.ui.produtos.exibe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pro.aguiar.ep7produtos.models.Produto
import br.pro.aguiar.ep7produtos.repository.ProdutoDao

class ExibeProdutoViewModel(val id: Long) : ViewModel() {

    private val _produto: MutableLiveData<Produto> = MutableLiveData()
    val produto: LiveData<Produto> = _produto

    init {
        _produto.value = ProdutoDao.exibir(id)
    }
}