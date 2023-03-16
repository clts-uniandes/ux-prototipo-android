package com.clts.maquetadoandroid

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.clts.maquetadoandroid.alarmas.ListaAlarmasFragment
import com.clts.maquetadoandroid.cuentas.ListaCuentasRegresivasFragment

class ViewPagerAdapter(fragmentActivity: FragmentActivity, private var totalCount: Int) : FragmentStateAdapter(fragmentActivity) {

    override fun getItemCount(): Int {
        return totalCount
    }

    override fun createFragment(position: Int): Fragment {
        return when (position) {
            0 -> ListaAlarmasFragment()
            1 -> ListaCuentasRegresivasFragment()
            else -> ListaCuentasRegresivasFragment()
        }
    }
}