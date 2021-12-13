package com.example.firstapp.adapter.skin

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.fragment.skin.SkinByChampionFragment
import com.example.firstapp.fragment.skin.SkinByThemeFragment

class SkinPagerFragmentAdapter(fragmentActivity: FragmentActivity) : FragmentStateAdapter(fragmentActivity){
    var fragments : ArrayList<Fragment> = ArrayList()

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment { // 페이지 연결
        return when(position){
            0 -> SkinByChampionFragment()
            else -> SkinByThemeFragment()
        }
    }

}