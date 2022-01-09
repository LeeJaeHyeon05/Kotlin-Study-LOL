package com.example.firstapp.fragment.Summoner

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentSummonerBinding
import com.google.android.material.tabs.TabLayoutMediator


class SummonerFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragments: ArrayList<Fragment> = ArrayList()
        fragments.add(SummonerFavFragment())
        fragments.add(SummonerRecentFragment())

        val binding = FragmentSummonerBinding.inflate(inflater, container, false)


        val adapter = object :FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }
        }
        binding.viewPager2.adapter = adapter

        TabLayoutMediator(binding.tabs2, binding.viewPager2) {tab, position ->
            if(position == 0){
                tab.icon = requireContext().getDrawable(R.drawable.ic_heart)
                tab.text = resources.getString(R.string.summoner_tab_favorite)

            }
            else if(position ==1){
                tab.icon = requireContext().getDrawable(R.drawable.ic_history)
                tab.text = resources.getString(R.string.summoner_tab_recent)

            }

        }.attach()


        return binding.root
    }
}