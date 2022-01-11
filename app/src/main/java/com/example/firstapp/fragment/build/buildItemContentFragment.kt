package com.example.firstapp.fragment.build

import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.fragment.app.viewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.BuildFilterBottomContentBinding
import com.example.waterexample.ui.base.BaseFragment
import com.xwray.groupie.GroupieAdapter


class buildItemContentFragment (val data : List<String>, val spanCount: Int): BaseFragment<BuildFilterBottomContentBinding>(R.layout.build_filter_bottom_content) {

    private val viewModel: BuildViewModel by activityViewModels()
    private val groupAdapter = GroupieAdapter()
    private lateinit var groupLayoutManager: GridLayoutManager


    override fun init() {

        groupLayoutManager = GridLayoutManager(context, spanCount).apply {
            spanSizeLookup = groupAdapter.spanSizeLookup }
        binding.recycleBuildSort.apply { adapter = groupAdapter
            layoutManager = groupLayoutManager
        }

        groupAdapter.update(data.map{BuildBottomItem(it)})
        binding.recycleBuildSort.adapter = groupAdapter

    }

}