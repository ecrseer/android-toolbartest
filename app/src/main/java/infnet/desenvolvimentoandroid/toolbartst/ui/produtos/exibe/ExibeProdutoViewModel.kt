package infnet.desenvolvimentoandroid.toolbartst.ui.produtos.exibe

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import infnet.desenvolvimentoandroid.toolbartst.models.Produto
import infnet.desenvolvimentoandroid.toolbartst.repository.ProdutoDao

class ExibeProdutoViewModel(val id: Long) : ViewModel() {

    private val _produto: MutableLiveData<Produto> = MutableLiveData()
    val produto: LiveData<Produto> = _produto

    init {
        _produto.value = ProdutoDao.exibir(id)
    }
}