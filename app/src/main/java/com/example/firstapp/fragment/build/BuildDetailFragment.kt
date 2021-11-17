package com.example.firstapp.fragment.build

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentBuildDetailBinding
import com.example.firstapp.fragment.build.detail.DetailViewPagerAdapter

class BuildDetailFragment : Fragment() {

    lateinit var binding: FragmentBuildDetailBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentBuildDetailBinding.inflate(inflater, container, false)

        val adapter = DetailViewPagerAdapter(this)
        binding.viewPager.adapter = adapter

        return binding.root
    }

}