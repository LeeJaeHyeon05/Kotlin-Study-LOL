package com.example.firstapp.fragment.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.example.firstapp.databinding.BuildFiterBottomContentBinding
import com.google.android.material.bottomsheet.BottomSheetDialogFragment

class BuildFilterBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding : BuildFiterBottomContentBinding

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {


        return super.onCreateView(inflater, container, savedInstanceState)
    }
}