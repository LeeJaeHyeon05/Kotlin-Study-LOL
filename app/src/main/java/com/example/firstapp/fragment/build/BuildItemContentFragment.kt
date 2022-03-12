package com.example.firstapp.fragment.build

import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.BuildFilterBottomContentBinding
import com.example.firstapp.model.BuildViewModel
import com.example.waterexample.ui.base.BaseFragment
import com.xwray.groupie.GroupieAdapter
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.flow.collect
import timber.log.Timber


@AndroidEntryPoint
class BuildItemContentFragment(val listSize: Int) :
    BaseFragment<BuildFilterBottomContentBinding>(R.layout.build_filter_bottom_content) {

    private val viewModel: BuildViewModel by activityViewModels()
    private val groupAdapter = GroupieAdapter()
    private lateinit var groupLayoutManager: GridLayoutManager


    override fun init() {
        val GroupItem = viewModel.totalItem.get(listSize)

        repeatOnStarted {

            GroupItem.collect { it ->
                Timber.d("GropItem Collect..")
                groupAdapter.update(it.map { BuildBottomItem(it) })
            }
        }

        val handleClickFilterItem: (BuildFilter) -> Unit = {
            viewModel.removeBottomFragment()
            viewModel.changeColor(listSize, it)
        }

        groupLayoutManager = GridLayoutManager(context, 5).apply {
            spanSizeLookup = groupAdapter.spanSizeLookup
        }
        binding.recycleBuildSort.apply {
            adapter = groupAdapter.also { groupieAdapter ->
                groupieAdapter.setOnItemClickListener { item, view ->
                    if (item is BuildBottomItem) {
//                        item.buildFilteritem.selected = true
                        handleClickFilterItem(item.buildFilteritem)
                    }
                }
            }
            layoutManager = groupLayoutManager
        }


        binding.recycleBuildSort.adapter = groupAdapter

    }

    override fun onDestroyView() {
        Timber.d("혹시 종료?")
        super.onDestroyView()
    }

    override fun onStop() {
        Timber.d("혹시 스탑?")
        super.onStop()
    }
}