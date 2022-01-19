package com.example.firstapp.fragment.build

import android.view.View
import com.example.firstapp.R
import com.example.firstapp.databinding.BuildFilterBottomItemBinding
import com.xwray.groupie.databinding.BindableItem

class BuildBottomItem (val tabName2: String) : BindableItem<BuildFilterBottomItemBinding>() {



    override fun bind(binding: BuildFilterBottomItemBinding, position: Int) {
        with(binding){

       tabName = tabName2


        }

    }

    override fun getLayout(): Int {
        return R.layout.build_filter_bottom_item
    }


}