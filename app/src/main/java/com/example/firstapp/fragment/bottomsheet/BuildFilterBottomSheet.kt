package com.example.firstapp.fragment.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.activityViewModels
import com.example.firstapp.R
import com.example.firstapp.adapter.build.BuildFragmentAdapter
import com.example.firstapp.databinding.BuildFiterBottomBinding
import com.example.firstapp.fragment.build.BuildFilter
import com.example.firstapp.fragment.build.buildItemContentFragment


import com.example.firstapp.model.BuildViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.android.material.tabs.TabLayoutMediator

class BuildFilterBottomSheet : BottomSheetDialogFragment() {

    private lateinit var buildFragmentAdapter: BuildFragmentAdapter
    private var _binding: BuildFiterBottomBinding? = null
    private val binding get() = _binding!!
    private val buildViewModel: BuildViewModel by activityViewModels()
    val tabData = listOf<String>("공통", "역할", "역할군","지역")
    companion object {
        const val TAG = "BuildFilterBottomSheet"
    }
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding =  DataBindingUtil.inflate(inflater, R.layout.build_fiter_bottom, container, false)
        initLayout()






        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }

    private fun initLayout() {
        val totalItems  = arrayListOf<List<BuildFilter>>()

        val commonItems: ArrayList<BuildFilter> = arrayListOf(
            BuildFilter("모두", "all"),
            BuildFilter("무료", "free"),
            BuildFilter("버프", "buff"),
            BuildFilter("너프", "nerf"),
            BuildFilter("즐겨찾기", "free"),
        )

        totalItems.add(commonItems)

        val roleItems: ArrayList<BuildFilter> = arrayListOf(
            BuildFilter("탑", "Top"),
            BuildFilter("정글", "jungle"),
            BuildFilter("미드", "Mid"),
            BuildFilter("원거리딜러", "MarksMan"),
            BuildFilter("서포터", "Support")
        )

        totalItems.add(roleItems)

        val roleGroupItems : ArrayList<BuildFilter> = arrayListOf(
            BuildFilter("암살자", "Top"),
            BuildFilter("전사", "Mid"),
            BuildFilter("마법사", "MarksMan"),
            BuildFilter("탱커", "MarksMan"),
            BuildFilter("원거리 딜러", "MarksMan"),
            BuildFilter("서포터", "Support")
        )

        totalItems.add(roleGroupItems)
        val locationItems : ArrayList<BuildFilter> = arrayListOf(
            BuildFilter("준비" ,"준비중")
        )

        totalItems.add(locationItems)
        buildFragmentAdapter  = BuildFragmentAdapter(totalItems, this.activity?: this.requireActivity())
        binding.viewPager2.adapter = buildFragmentAdapter




        TabLayoutMediator(binding.tabLayout2,binding.viewPager2){tab,position->
            tab.text = tabData[position]
        }.attach()
    }
}


