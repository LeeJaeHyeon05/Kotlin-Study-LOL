package com.example.firstapp.fragment.build

import android.view.Gravity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.BuildFilterBottomContentBinding
import com.example.firstapp.model.BuildViewModel
import com.example.waterexample.ui.base.BaseFragment
import com.xwray.groupie.GroupieAdapter


class buildItemContentFragment (val data : List<BuildFilter>): BaseFragment<BuildFilterBottomContentBinding>(R.layout.build_filter_bottom_content) {

    private val viewModel: BuildViewModel by activityViewModels()
    private val groupAdapter = GroupieAdapter()
    private lateinit var groupLayoutManager: GridLayoutManager


    override fun init() {

        val handleClickFilterItem = {
//            viewModel.toggleTag(it)
            viewModel.removeBottomFragment()
        }

        groupLayoutManager = GridLayoutManager(context, 5).apply {
            spanSizeLookup = groupAdapter.spanSizeLookup
        }
        binding.recycleBuildSort.apply {
            adapter = groupAdapter.also {groupieAdapter ->
                groupieAdapter.setOnItemClickListener { item, view ->
                    if(item is BuildBottomItem){
                        handleClickFilterItem()
                    }
                }
            }
            layoutManager = groupLayoutManager
        }

        groupAdapter.update(data.map{BuildBottomItem(it.name)})
        binding.recycleBuildSort.adapter = groupAdapter

    }

}