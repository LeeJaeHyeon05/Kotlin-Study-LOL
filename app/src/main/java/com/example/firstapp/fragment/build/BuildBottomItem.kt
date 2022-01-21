package com.example.firstapp.fragment.build

import android.view.View
import com.example.firstapp.R
import com.example.firstapp.databinding.BuildFilterBottomItemBinding
import com.xwray.groupie.databinding.BindableItem

class BuildBottomItem (val buildFilteritem: BuildFilter) : BindableItem<BuildFilterBottomItemBinding>() {




    override fun bind(binding: BuildFilterBottomItemBinding, position: Int) {
        with(binding){
            buildFilter = buildFilteritem

            when (buildFilteritem.selected) {
                true -> binding.filterButton.visibility = View.GONE
                false -> binding.filterButton.visibility = View.VISIBLE
            }
        }

    }

    override fun getLayout(): Int {
        return R.layout.build_filter_bottom_item
    }


}