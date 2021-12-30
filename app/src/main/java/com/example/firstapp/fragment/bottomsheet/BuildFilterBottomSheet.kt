package com.example.firstapp.fragment.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.firstapp.databinding.BuildFiterBottomContentBinding
import com.example.firstapp.databinding.ItemSortBottomSheetContentBinding
import com.example.firstapp.fragment.build.BuildViewModel
import com.example.firstapp.model.ItemViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BuildFilterBottomSheet : BottomSheetDialogFragment() {

    private var _binding: BuildFiterBottomContentBinding? = null
    private val binding get() = _binding!!
    private val buildViewModel: BuildViewModel by activityViewModels()
    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {

        _binding = BuildFiterBottomContentBinding.inflate(layoutInflater)
        val fgAdapter = FgAdap
//        binding.tabLayout2.
        return binding.root
    }

    override fun onDestroyView() {
        super.onDestroyView()
        _binding = null
    }
}


