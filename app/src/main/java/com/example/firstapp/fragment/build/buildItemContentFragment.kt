package com.example.firstapp.fragment.build

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import com.example.firstapp.R
import com.example.firstapp.databinding.BuildFilterBottomContentBinding
import com.example.waterexample.ui.base.BaseFragment


class buildItemContentFragment (val data : List<String>): BaseFragment<BuildFilterBottomContentBinding>(R.layout.build_filter_bottom_content) {

    private val viewModel: BuildViewModel by activityViewModels()


    override fun init() {

    }

}