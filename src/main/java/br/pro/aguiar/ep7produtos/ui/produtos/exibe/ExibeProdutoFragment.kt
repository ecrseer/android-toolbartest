package br.pro.aguiar.ep7produtos.ui.produtos.exibe

import android.os.Bundle
import android.view.*
import android.widget.EditText
import android.widget.TextView
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.pro.aguiar.ep7produtos.R

class ExibeProdutoFragment : Fragment() {

    companion object {
        fun newInstance() = ExibeProdutoFragment()
    }

    private lateinit var viewModel: ExibeProdutoViewModel
    private var produtoId: Long? = null
    lateinit var precoTxt: EditText

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)
        val view = inflater.inflate(
            R.layout.exibe_produto_fragment,
            container,
            false)
        precoTxt=view.findViewById(R.id.edtTextPreco)
        produtoId = arguments?.getLong("produtoId")
        if (produtoId == null)
            findNavController().popBackStack()

        viewModel = ViewModelProvider(
            this,
            ExibeProdutoViewModelFactory(produtoId!!))
            .get(ExibeProdutoViewModel::class.java)



        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel.produto.observe(viewLifecycleOwner){ produto ->
            view.findViewById<TextView>(R.id.textViewProdutoNome)
                .text = produto.nome
        }
    }
    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()
        inflater.inflate(R.menu.menu_produto,menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

    override fun onPause() {
        super.onPause()
    }
    fun salvaAlteracao(novoPreco:Double):Boolean{
        viewModel.produto.value?.apply {
            preco = novoPreco
        }
        findNavController().navigate(R.id.listaProdutosFragment)
        return true
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        val novoPreco = precoTxt.text.toString().toDouble()
        return when(item.itemId){
            R.id.menu_btn_salvar -> salvaAlteracao(novoPreco)
            else->super.onOptionsItemSelected(item)
        }

    }

}