package infnet.desenvolvimentoandroid.toolbartst.ui.produtos.lista

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import infnet.desenvolvimentoandroid.toolbartst.models.Produto
import infnet.desenvolvimentoandroid.toolbartst.repository.ProdutoDao

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