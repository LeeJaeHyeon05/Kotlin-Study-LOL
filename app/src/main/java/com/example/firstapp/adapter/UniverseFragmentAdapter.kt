package com.example.firstapp.adapter

import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.fragment.universe.*

class UniverseFragmentAdapter(fragment: Fragment) : FragmentStateAdapter(fragment) {

    val fragments: ArrayList<Fragment> = ArrayList()

    init {
        fragments.add(UniverseChampFragment())
        fragments.add(UniverseRegionFragment())
        fragments.add(UniverseNovelFragment())
        fragments.add(UniverseComicFragment())
        fragments.add(UniverseVideoFragment())
    }

    override fun getItemCount(): Int {
        return fragments.size
    }

    override fun createFragment(position: Int): Fragment {
        return fragments[position]
    }
}