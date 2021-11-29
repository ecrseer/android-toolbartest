package br.pro.aguiar.ep7produtos.ui.produtos.form

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Button
import android.widget.EditText
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import br.pro.aguiar.ep7produtos.R
import com.google.android.material.snackbar.Snackbar

class FormProdutoFragment : Fragment() {

    companion object {
        fun newInstance() = FormProdutoFragment()
    }

    lateinit var editTextFromProdutoNome: EditText
    lateinit var editTextFromProdutoPreco: EditText
    lateinit var editTextFromProdutoDescricao: EditText
    lateinit var btnSalvarProduto: Button

    private lateinit var viewModel: FormProdutoViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.form_produto_fragment, container, false)

        editTextFromProdutoNome =
            view.findViewById(R.id.editTextFromProdutoNome)
        editTextFromProdutoPreco =
            view.findViewById(R.id.editTextFromProdutoPreco)
        editTextFromProdutoDescricao =
            view.findViewById(R.id.editTextFromProdutoDescricao)
        btnSalvarProduto =
            view.findViewById(R.id.btnSalvarProduto)

        viewModel = ViewModelProvider(this).get(FormProdutoViewModel::class.java)

        viewModel.status.observe(viewLifecycleOwner) { status ->
            if (status) // status == true
                findNavController().popBackStack()
        }

        viewModel.msg.observe(viewLifecycleOwner) { msg ->
            if (msg.isNotBlank())
                Snackbar.make(view, msg, Snackbar.LENGTH_LONG).show()
        }

        btnSalvarProduto.setOnClickListener {
            val nome = editTextFromProdutoNome.text.toString()
            val preco = editTextFromProdutoPreco.text.toString().toDouble()
            val descricao = editTextFromProdutoDescricao.text.toString()
            viewModel.inserirProduto(nome, preco, descricao)
        }

        return view
    }

}