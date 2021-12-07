package com.example.firstapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.adapter.ItemFilterGroupListAdapter
import com.example.firstapp.databinding.FragmentItemFilterBinding
import com.example.firstapp.model.ItemFilter
import com.example.firstapp.model.ItemFilterGroup

class ItemFilterFragment : Fragment() {

    private lateinit var binding: FragmentItemFilterBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemFilterBinding.inflate(layoutInflater)

        initLayout()

        return binding.root
    }

    private fun initLayout() {

        val allItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.all_item_filter1)),
            ItemFilter(getString(R.string.all_item_filter2)),
            ItemFilter(getString(R.string.all_item_filter3)),
            ItemFilter(getString(R.string.all_item_filter4))
        )
        val startItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.start_item_filter1)),
            ItemFilter(getString(R.string.start_item_filter2))
        )
        val specializationItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.specialization_item_filter1)),
            ItemFilter(getString(R.string.specialization_item_filter2)),
            ItemFilter(getString(R.string.specialization_item_filter3)),
            ItemFilter(getString(R.string.specialization_item_filter4))
        )
        val defenseItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.defense_item_filter1)),
            ItemFilter(getString(R.string.defense_item_filter2)),
            ItemFilter(getString(R.string.defense_item_filter3)),
            ItemFilter(getString(R.string.defense_item_filter4))
        )
        val attackItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.attack_item_filter1)),
            ItemFilter(getString(R.string.attack_item_filter2)),
            ItemFilter(getString(R.string.attack_item_filter3)),
            ItemFilter(getString(R.string.attack_item_filter4)),
            ItemFilter(getString(R.string.attack_item_filter5)),
        )
        val magicItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.magic_item_filter1)),
            ItemFilter(getString(R.string.magic_item_filter2)),
            ItemFilter(getString(R.string.magic_item_filter3)),
            ItemFilter(getString(R.string.magic_item_filter4)),
            ItemFilter(getString(R.string.magic_item_filter5)),
        )
        val movementItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.movement_item_filter1)),
            ItemFilter(getString(R.string.movement_item_filter2)),
        )

        val allItemsGroup = ItemFilterGroup(getString(R.string.all_item), allItems)
        val startItemsGroup = ItemFilterGroup(getString(R.string.start_item), startItems)
        val specializationItemsGroup = ItemFilterGroup(getString(R.string.specialization_item), specializationItems)
        val defenseItemsGroup = ItemFilterGroup(getString(R.string.defense_item), defenseItems)
        val attackItemsGroup = ItemFilterGroup(getString(R.string.start_item), attackItems)
        val magicItemsGroup = ItemFilterGroup(getString(R.string.magic_item), magicItems)
        val movementItemsGroup = ItemFilterGroup(getString(R.string.movement_item), movementItems)

        val itemFilterGroupList: ArrayList<ItemFilterGroup> = arrayListOf(allItemsGroup, startItemsGroup, specializationItemsGroup, defenseItemsGroup, attackItemsGroup, magicItemsGroup, movementItemsGroup)

        binding.itemFilterGroupRecyclerView.run {
            adapter = ItemFilterGroupListAdapter(itemFilterGroupList)
            layoutManager = LinearLayoutManager(context)
        }
    }
}