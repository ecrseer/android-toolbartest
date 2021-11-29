package br.pro.aguiar.ep7produtos.ui.produtos.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import br.pro.aguiar.ep7produtos.models.Produto
import br.pro.aguiar.ep7produtos.repository.ProdutoDao

class FormProdutoViewModel : ViewModel() {

    private val _status: MutableLiveData<Boolean> = MutableLiveData()
    val status: LiveData<Boolean> = _status

    private val _msg: MutableLiveData<String> = MutableLiveData()
    val msg: LiveData<String> = _msg

    init {
        _status.value = false
        _msg.value = ""
    }

    fun inserirProduto(
        nome: String,
        preco: Double,
        descricao: String) {
        _status.value = false
        val produto = Produto(nome, preco, descricao)
        // deve ocorrer de forma assíncrona
        ProdutoDao.inserir(produto)
        _status.value = true
        /*val ocorrenciaDeProblema = true
        if (ocorrenciaDeProblema)
            _msg.value = "Problemas ao salvar o produto."
        else
            _status.value = true*/
    }
}