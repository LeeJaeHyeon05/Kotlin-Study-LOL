package com.example.firstapp.fragment.ChampTier

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentTierBinding
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/
class TierFragment : Fragment(R.layout.fragment_tier) {

    @SuppressLint("UseCompatLoadingForDrawables")
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

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragmentList.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragmentList[position]
            }
        }
        binding.viewPager.adapter = adapter

        // tab과 viewPager2를 연결시킨다
        TabLayoutMediator(binding.tabs, binding.viewPager) { tab: TabLayout.Tab, i: Int ->
            if (i == 0) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_top)
            } else if (i == 1) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_jng)
            } else if (i == 2) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_mid)
            } else if (i == 3) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_adc)
            } else if (i == 4) {
                tab.icon = requireContext().getDrawable(R.drawable.ic_sup)
            }

        }.attach()

        return binding.root
    }
}