package infnet.desenvolvimentoandroid.toolbartst.ui.produtos.lista

import android.os.Bundle
import android.view.*
import android.widget.ArrayAdapter
import android.widget.EditText
import android.widget.ListView
import androidx.core.os.bundleOf
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.fragment.findNavController
import com.google.android.material.floatingactionbutton.FloatingActionButton
import com.google.android.material.snackbar.Snackbar
import infnet.desenvolvimentoandroid.toolbartst.R

class ListaProdutosFragment : Fragment() {

    companion object {
        fun newInstance() = ListaProdutosFragment()
    }

    lateinit var listViewProdutos: ListView
    lateinit var fabListaParaForm: FloatingActionButton

    private lateinit var viewModel: ListaProdutosViewModel

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        setHasOptionsMenu(true)

        var view = inflater.inflate(
            R.layout.lista_produtos_fragment,
            container,
            false)

        listViewProdutos = view.findViewById(R.id.listViewProdutos)
        fabListaParaForm = view.findViewById(R.id.fabListaParaForm)

        viewModel = ViewModelProvider(this)
                        .get(ListaProdutosViewModel::class.java)

        viewModel.produtos.observe(viewLifecycleOwner) { produtos ->
            if (produtos.isNotEmpty()) {
                listViewProdutos.adapter = ArrayAdapter(
                    requireContext(),
                    android.R.layout.simple_list_item_1,
                    produtos // toString
                )
                listViewProdutos.setOnItemClickListener { parent, view, position, id ->
                    val bundle = bundleOf(
                        "produtoId" to produtos.get(position).id
                    )
                    findNavController()
                        .navigate(R.id.listaExibeProdutoFragment, bundle)
                }
            } else
                Snackbar.make(
                    view,
                    "Nenhum produto cadastrado.",
                    Snackbar.LENGTH_LONG
                ).show()
        }

        fabListaParaForm.setOnClickListener {
            findNavController()
                .navigate(R.id.formProdutoFragment)
        }
        return view
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {

        menu.clear()
        inflater.inflate(R.menu.menu_main,menu)
        return super.onCreateOptionsMenu(menu, inflater)
    }

}