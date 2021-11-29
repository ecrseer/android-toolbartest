package br.pro.aguiar.ep7produtos.ui.produtos.exibe

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
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

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(
            R.layout.exibe_produto_fragment,
            container,
            false)

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

}