package br.pro.aguiar.ep7produtos.repository

import br.pro.aguiar.ep7produtos.models.Produto

object ProdutoDao {
    private var produtos: MutableList<Produto> = mutableListOf(
        Produto("Notebook", 5236.65, "Notebook GammerII", 1),
        Produto("TV", 1236.65, "TV SmartV", 2)
    )

    fun listar(): List<Produto> = produtos
    fun inserir(produto: Produto) {
        var id = produtos.last().id
        produto.id = ++id
        produtos.add(produto)
    }
    fun exibir(id: Long): Produto? {
        for (produto in produtos){
            if (produto.id == id) return produto
        }
        return null
    }
    fun atualizar(id: Long, produto: Produto): Boolean {
        produtos.forEachIndexed { index, prod ->
            if (prod.id == id) {
                produtos[index] = produto
                return true
            }
        }
        return false
    }
    fun excluir(id: Long): Boolean {
        produtos.forEach {prod ->
            if (prod.id == id) return produtos.remove(prod)
        }
        return false
    }
}