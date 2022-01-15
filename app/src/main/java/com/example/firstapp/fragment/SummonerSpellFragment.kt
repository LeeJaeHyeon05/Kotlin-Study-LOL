package com.example.firstapp.fragment

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.GridLayoutManager
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.HowlingFragment
import com.example.firstapp.LolspallFragment
import com.example.firstapp.adapter.summorSpell.ItemsViewModel
import com.example.firstapp.R
import com.example.firstapp.adapter.summorSpell.CustomAdapter
import com.example.firstapp.databinding.FragmentSummonerSpellBinding
import com.google.android.material.tabs.TabLayoutMediator

class SummonerSpellFragment : Fragment() {

    //전역 변수로 바인딩 객체 선언
    private var mBinding: FragmentSummonerSpellBinding? = null
    //편의성을 위한 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        mBinding = FragmentSummonerSpellBinding.inflate(inflater,container, false)


        val lolFragment = LolspallFragment()
        val howlingFragment = HowlingFragment()

        val fragments = arrayListOf<Fragment>(lolFragment, howlingFragment)

        val tabAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }

        }
        binding.viewPager2.adapter = tabAdapter


        TabLayoutMediator(binding.tabBar, binding.viewPager2) {tab, position ->
            when (position) {
                0 -> tab.setText(R.string.lol)
                else -> tab.setText(R.string.HowlingAbyss)
            }
        }.attach()


        return binding.root

    }

    //프래그먼트가 파괴 될때
    override fun onDestroy() {
        mBinding =null
        super.onDestroy()
    }
}
