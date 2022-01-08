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

        binding.tabLayout2.run {
            this.addTab(newTab().setText("공통"))
            this.addTab(newTab().setText("무료"))
            this.addTab(newTab().setText("역할군"))
            this.addTab(newTab().setText("지역"))

        }






        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


