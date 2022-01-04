package com.example.firstapp.fragment.build

import com.example.firstapp.R
import com.example.firstapp.databinding.ItemBuildMainBinding
import com.example.firstapp.model.mychampion.Datum
import com.xwray.groupie.databinding.BindableItem

class BuildBottomItem (val tabName: String) : BindableItem<>() {


    override fun bind(binding: ItemBuildMainBinding, position: Int) {
        binding.championData = dataNum
    }

    override fun getLayout(): Int {
        return R.layout.item_build_main
    }
}