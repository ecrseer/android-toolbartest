package infnet.desenvolvimentoandroid.toolbartst.ui.produtos.form

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import infnet.desenvolvimentoandroid.toolbartst.models.Produto
import infnet.desenvolvimentoandroid.toolbartst.repository.ProdutoDao

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