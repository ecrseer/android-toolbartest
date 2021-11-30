package infnet.desenvolvimentoandroid.toolbartst.ui.produtos.exibe

import android.os.Bundle
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter

class ListaExibeViewPagerAdapter(fa:FragmentActivity,var qtd:Int) : FragmentStateAdapter(fa) {
    override fun getItemCount(): Int {
        return qtd?:2
    }

    override fun createFragment(position: Int): Fragment {
        val frag = ExibeProdutoFragment()
        val bundl = Bundle()
        val teste:Long = position.toLong()+1
        bundl.putLong("produtoId",teste)
        frag.arguments = bundl

        return frag;
    }

}