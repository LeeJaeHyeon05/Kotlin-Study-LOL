package com.example.firstapp.fragment.ChampTier

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R
import androidx.databinding.DataBindingUtil
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.adapter.ChampTier.Tier1Adapter
import com.example.firstapp.databinding.FragmentTierTopBinding

class TierTopFragment:Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val binding = DataBindingUtil.
        inflate<FragmentTierTopBinding>(inflater, R.layout.fragment_tier_top, container, false)

        // RecyclerView 초기화
        binding.tier1Recycler.layoutManager = GridLayoutManager(context, 4)
        val adapter = Tier1Adapter()
        binding.tier1Recycler.adapter = adapter


        return binding.root
    }
}