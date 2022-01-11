package com.example.firstapp.fragment.build

import com.example.firstapp.R
import com.example.firstapp.databinding.BuildFilterBottomItemBinding
import com.example.firstapp.databinding.ItemBuildMainBinding
import com.example.firstapp.model.mychampion.Datum
import com.xwray.groupie.databinding.BindableItem

class BuildBottomItem (val tabName: String) : BindableItem<BuildFilterBottomItemBinding>() {

    override fun bind(viewBinding: BuildFilterBottomItemBinding, position: Int) {
        viewBinding.tabName = tabName
    }

    override fun getLayout(): Int {
        return R.layout.build_filter_bottom_item
    }


}