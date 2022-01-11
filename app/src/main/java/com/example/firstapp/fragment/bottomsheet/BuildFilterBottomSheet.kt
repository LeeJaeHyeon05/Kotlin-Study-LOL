package com.example.firstapp.fragment.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.firstapp.R
import com.example.firstapp.databinding.BuildFiterBottomBinding


import com.example.firstapp.fragment.build.BuildViewModel
import com.example.firstapp.model.ItemViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator

class BuildFilterBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BuildFiterBottomBinding? = null
    private val binding get() = _binding!!
    private val buildViewModel: BuildViewModel by activityViewModels()
    companion object {
        const val TAG = "BuildFilterBottomSheet"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding =  DataBindingUtil.inflate(inflater, R.layout.build_fiter_bottom, container, false)


        TabLayoutMediator(binding.tabLayout2,binding.viewPager2){tab,position->
            tab.text = buildViewModel.tabData[position]
        }.attach()





        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


