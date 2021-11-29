package br.pro.aguiar.ep7produtos.ui.produtos.exibe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.ViewModelProvider
import androidx.viewpager2.widget.ViewPager2
import br.pro.aguiar.ep7produtos.R
import br.pro.aguiar.ep7produtos.repository.ProdutoDao
import br.pro.aguiar.ep7produtos.ui.produtos.lista.ListaProdutosViewModel


/**
 * A simple [Fragment] subclass.
 * Use the [ListaExibeProdutoFragment.newInstance] factory method to
 * create an instance of this fragment.
 */
class ListaExibeProdutoFragment : Fragment() {
    // TODO: Rename and change types of parameters
    private var produtoId: Long? = null
    lateinit var listaViewModel: ListaProdutosViewModel
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        arguments?.let {
            produtoId = it?.getLong("produtoId")
        }
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        listaViewModel = ViewModelProvider(this)
            .get(ListaProdutosViewModel::class.java)

        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_lista_exibe_produto, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        val mPager = view.findViewById<ViewPager2>(R.id.mpager)
        if(mPager!=null){
            val tamanho = listaViewModel.produtos?.value?.size
            if(tamanho!=null)
                mPager.adapter = ListaExibeViewPagerAdapter(requireActivity(),tamanho)
            mPager.currentItem = (produtoId?.minus(1))?.toInt()!!
        }
    }


}