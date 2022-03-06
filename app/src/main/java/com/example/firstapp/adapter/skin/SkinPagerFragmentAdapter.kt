package com.example.firstapp.adapter.skin

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.fragment.skin.SkinByChampionFragment
import com.example.firstapp.fragment.skin.SkinByThemeFragment
import com.example.firstapp.fragment.skin.SkinFragment

class SkinPagerFragmentAdapter(fragmentActivity: SkinFragment) : FragmentStateAdapter(fragmentActivity){
    var fragments : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment { // 페이지 연결
        return when(position){
            0 -> SkinByChampionFragment()
            else -> SkinByThemeFragment()
        }
        //return fragments[position]
    }


//    override fun getPageTitle(position: Int): CharSequence {
//        return when(position){
//            0 -> "챔피언별"
//            else -> {return "스킨 테마별"}
//        }
//    }

    fun addFragment(fragment: Fragment){
        fragments.add(fragment)
        notifyItemInserted(fragments.size - 1)
    }

    fun removeFragment(){
        fragments.removeLast()
        notifyItemRemoved(fragments.size)
    }

}