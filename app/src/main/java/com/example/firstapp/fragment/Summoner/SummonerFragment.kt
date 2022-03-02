package com.example.firstapp.fragment.summoner

import android.R
import android.annotation.SuppressLint
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.viewpager2.adapter.FragmentStateAdapter
import com.example.firstapp.databinding.FragmentSummonerBinding
import com.google.android.material.tabs.TabLayoutMediator
import dagger.hilt.android.AndroidEntryPoint

import android.widget.ArrayAdapter

import android.text.Editable

import android.text.TextWatcher


@AndroidEntryPoint
class SummonerFragment : Fragment() {
    @SuppressLint("UseCompatLoadingForDrawables")
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        val fragments: ArrayList<Fragment> = ArrayList()
        fragments.add(SummonerFavFragment())
        fragments.add(SummonerRecentFragment())

        val binding = FragmentSummonerBinding.inflate(inflater, container, false)
        val result = arrayOf("소환사", "어쩌고", "산타할아버러지", "몰라")


        val adapter = object : FragmentStateAdapter(this) {
            override fun getItemCount(): Int {
                return fragments.size
            }

            override fun createFragment(position: Int): Fragment {
                return fragments[position]
            }
        }
        binding.viewPager2.adapter = adapter

        binding.tvAutoFirst.setAdapter(
            ArrayAdapter(
                requireContext(),
                R.layout.simple_dropdown_item_1line,
                result
            )
        )

        binding.tvAutoFirst.addTextChangedListener(object : TextWatcher {
            override fun beforeTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun onTextChanged(charSequence: CharSequence, i: Int, i1: Int, i2: Int) {}
            override fun afterTextChanged(editable: Editable) {
            //초성검색 후
            //해당내용만 items에 담은 후 showdropdown
                runFirstComplete(binding.tvAutoFirst, result)
            }
        })



        TabLayoutMediator(binding.tabs2, binding.viewPager2) { tab, position ->
            if (position == 0) {
                tab.icon = requireContext().getDrawable(com.example.firstapp.R.drawable.ic_heart)
                tab.text = resources.getString(com.example.firstapp.R.string.summoner_tab_favorite)

            } else if (position == 1) {
                tab.icon = requireContext().getDrawable(com.example.firstapp.R.drawable.ic_history)
                tab.text = resources.getString(com.example.firstapp.R.string.summoner_tab_recent)

            }

        }.attach()


        return binding.root
    }


    private fun runFirstComplete(tvAutoFirst: AutoFirstTextView, result: Array<String>) {

        val rstList: ArrayList<String> = ArrayList()
        if (tvAutoFirst.length() > 1) {

            for (i in result.indices) {
                val bResult: Boolean =
                    SoundSearcher.matchString(result[i], tvAutoFirst.text.toString())
                if (bResult) {
                    rstList.add(result[i])
                }
            }

            if (rstList.size > 0) {
                tvAutoFirst.setAdapter(
                    ArrayAdapter(
                        requireContext(),
                        R.layout.simple_dropdown_item_1line,
                        rstList
                    )
                )
                tvAutoFirst.showDropDown()
            } else {
                tvAutoFirst.dismissDropDown()
            }
        } else {
            tvAutoFirst.dismissDropDown()
        }


    }


}