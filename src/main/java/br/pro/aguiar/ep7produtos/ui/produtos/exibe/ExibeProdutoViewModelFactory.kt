package br.pro.aguiar.ep7produtos.ui.produtos.exibe

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider

class ExibeProdutoViewModelFactory(val id: Long): ViewModelProvider.Factory {
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        return ExibeProdutoViewModel(id) as T
    }
}