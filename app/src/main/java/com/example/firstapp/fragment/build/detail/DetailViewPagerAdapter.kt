package com.example.firstapp.fragment.build.detail

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.fragment.build.BuildDetailFragment

class DetailViewPagerAdapter(fragment: BuildDetailFragment) : FragmentStateAdapter(fragment){

    val fragments = listOf<Fragment>(
        DetailBuildFragment(),
        DetailProBuildFragment(),
        DetailEtcBuildFragment(),
        DetailStatisticsFragment(),
        DetailCounterFragment(),
        DetailTipFragment(),
        DetailMyBuildFragment()
    )

    override fun getItemCount(): Int = fragments.size

    override fun createFragment(position: Int): Fragment = fragments[position]

}