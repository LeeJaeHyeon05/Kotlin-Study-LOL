package com.example.firstapp.fragment.rune

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentRuneBinding
import com.example.firstapp.databinding.FragmentSummonerSpellBinding
import com.google.android.material.tabs.TabLayoutMediator

class RuneFragment : Fragment() {

    //전역 변수로 바인딩 객체 선언
    private var mBinding: FragmentRuneBinding? = null
    //편의성을 위한 바인딩 변수 재 선언
    private val binding get() = mBinding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        mBinding = FragmentRuneBinding.inflate(inflater,container, false)

        val precisionFragment = PrecisionFragment()
        val dominationFragment = DominationFragment()
        val sorceryFragment = SorceryFragment()
        val resolveFragment = ResolveFragment()
        val whimsyFragment = WhimsyFragment()

        val fragments = arrayListOf<Fragment>(precisionFragment, dominationFragment, sorceryFragment, resolveFragment, whimsyFragment)

        val tabAdapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return  fragments[position]
            }
        }
        binding.runeViewPager2.adapter = tabAdapter

        TabLayoutMediator(binding.tabBar, binding.runeViewPager2) {tab, position ->
            when (position) {
                0 -> tab.setIcon(R.drawable.precision)
                1 -> tab.setIcon(R.drawable.domination)
                2 -> tab.setIcon(R.drawable.sorcery)
                3 -> tab.setIcon(R.drawable.resolve)
                else -> tab.setIcon(R.drawable.whimsy)
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