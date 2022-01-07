package com.example.firstapp.fragment.build.detail

import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentActivity
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.fragment.build.detail.mybuild.detailmybuild.DetailMyBuildFragment
import com.example.firstapp.model.MyBuild

class DetailViewPagerAdapter(fragment: FragmentActivity) : FragmentStateAdapter(fragment){

     val fragments = mutableListOf<Fragment>(
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