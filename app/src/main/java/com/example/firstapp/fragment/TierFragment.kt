package com.example.firstapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentTierBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayout.GRAVITY_FILL
import com.google.android.material.tabs.TabLayoutMediator

class TierFragment : Fragment(R.layout.fragment_tier) {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // fragment 객체 생성
        val topFragment = TierTopFragment()
        val midFragment = TierMidFragment()
        val botFragment = TierBotFragment()
        val supFragment = TierSupFragment()
        val jungFragment = TierJungFragment()

        val binding = FragmentTierBinding.inflate(inflater, container, false)
        val fragmentList = arrayOf(topFragment, jungFragment, midFragment, botFragment, supFragment)

        val adapter = object : FragmentStateAdapter(this){
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }
        }
        binding.viewPager.adapter = adapter

        // tab과 viewPager2를 연결시킨다
        TabLayoutMediator(binding.tabs, binding.viewPager){tab : TabLayout.Tab, i:Int ->
            tab.text = "탭 $i"
        }.attach()
        return binding.root
    }
}