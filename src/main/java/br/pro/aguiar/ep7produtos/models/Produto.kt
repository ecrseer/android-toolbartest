package br.pro.aguiar.ep7produtos.models

class Produto(
    var nome: String,
    var preco: Double,
    var descricao: String,
    var id: Long = 0) {

    override fun toString(): String {
        return "$nome, R$ $preco"
    }
}