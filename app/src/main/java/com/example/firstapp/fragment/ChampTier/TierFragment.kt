package com.example.firstapp.fragment.ChampTier

import android.annotation.SuppressLint
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentTierBinding
import com.example.firstapp.model.TierViewModel
import com.example.firstapp.util.getCurrentFragment
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint
import timber.log.Timber

/**
 * @author mmol93
 * @email ljws93@naver.com
 * @since 2021/11/10
 **/

@AndroidEntryPoint
class TierFragment : Fragment(R.layout.fragment_tier) {

    // activityViewModels: Activity의 viewModel에 접근하도록 한다
    private val tierViewModel: TierViewModel by activityViewModels()

    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // 챔피언 데이터를 받기 위한 객체
        // fragment 객체 생성
//        val topFragment = EachLineTierFragment(0)
//        val jungFragment = EachLineTierFragment(1)
//        val midFragment = EachLineTierFragment(2)
//        val botFragment = EachLineTierFragment(3)
//        val supFragment = EachLineTierFragment(4)

        val topFragment = TierTopFragment()
        val jungFragment = TierJungFragment()
        val midFragment = TierMidFragment()
        val botFragment = TierAdcFragment()
        val supFragment = TierSupFragment()

        val fragments = arrayListOf<Fragment>(topFragment, jungFragment, midFragment, botFragment, supFragment)

        val binding = FragmentTierBinding.inflate(inflater, container, false)

        /* viewModel로 데이터 갱신하고
           각 fragment에 데이터 분배하기
         */
        tierViewModel.tierDataList.observe(viewLifecycleOwner, Observer {
            Timber.d("TierFragment에서 Jsoup 데이터 갱신함")
        })

        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
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