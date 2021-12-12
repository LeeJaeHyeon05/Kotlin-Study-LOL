package com.example.firstapp.fragment.universe

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.R
import com.example.firstapp.adapter.UniverseFragmentAdapter
import com.example.firstapp.databinding.FragmentUniverseBinding
import com.google.android.material.tabs.TabLayoutMediator

class UniverseFragment : Fragment() {

    private var _binding: FragmentUniverseBinding? = null


    private val binding get() = _binding!!

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = FragmentUniverseBinding.inflate(inflater, container, false);
        val root: View = binding.root

        val adapter: FragmentStateAdapter = UniverseFragmentAdapter(this)
        binding.viewPager.adapter = adapter

        TabLayoutMediator(binding.tabLayout, binding.viewPager) {tab, position ->
            when(position) {
                0 -> tab.text = "챔피언"
                1 -> tab.text = "지역"
                2 -> tab.text = "단편소설"
                3 -> tab.text = "코믹"
                4 -> tab.text = "영상"
            }
        }.attach()

        return root
    }
}