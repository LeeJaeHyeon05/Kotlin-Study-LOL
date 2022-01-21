package com.example.firstapp.fragment.build

import android.view.Gravity
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.*
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.BuildFilterBottomContentBinding
import com.example.firstapp.model.BuildViewModel
import com.example.waterexample.ui.base.BaseFragment
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import kotlinx.coroutines.launch


@AndroidEntryPoint
class BuildItemContentFragment (val listSize : Int): BaseFragment<BuildFilterBottomContentBinding>(R.layout.build_filter_bottom_content) {

    private val viewModel: BuildViewModel by activityViewModels()
    private val groupAdapter = GroupieAdapter()
    private lateinit var groupLayoutManager: GridLayoutManager



    override fun init() {
        val GroupItem = viewModel.totalItem.get(listSize)

        repeatOnStarted {
            GroupItem.collect {
                groupAdapter.update(GroupItem.value)

            }
        }

        val handleClickFilterItem: (String)-> Unit  = {
//            viewModel.changeTag(it)
            viewModel.removeBottomFragment()
        }

        groupLayoutManager = GridLayoutManager(context, 5).apply {
            spanSizeLookup = groupAdapter.spanSizeLookup
        }
        binding.recycleBuildSort.apply {
            adapter = groupAdapter.also {groupieAdapter ->
                groupieAdapter.setOnItemClickListener { item, view ->
                    if(item is BuildBottomItem){
                        item.buildFilteritem.selected = false
//                        viewModel.changeColor(listSize)
                    }
                }
            }
            layoutManager = groupLayoutManager
        }


        binding.recycleBuildSort.adapter = groupAdapter

    }

}