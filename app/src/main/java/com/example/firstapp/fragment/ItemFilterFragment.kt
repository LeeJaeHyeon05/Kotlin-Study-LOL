package com.example.firstapp.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.adapter.ItemFilterGroupListAdapter
import com.example.firstapp.databinding.FragmentItemFilterBinding
import com.example.firstapp.model.ItemFilter
import com.example.firstapp.model.ItemFilterGroup
import com.example.firstapp.model.ItemViewModel

class ItemFilterFragment : Fragment() {

    private lateinit var binding: FragmentItemFilterBinding

    private val itemViewModel: ItemViewModel by activityViewModels()

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
            ItemFilter(getString(R.string.all_item_filter1), ""),
            ItemFilter(getString(R.string.all_item_filter2), ""),
            ItemFilter(getString(R.string.all_item_filter3), ""),
            ItemFilter(getString(R.string.all_item_filter4), "")
        )
        val startItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.start_item_filter1), "Lane"),
            ItemFilter(getString(R.string.start_item_filter2), "Jungle")
        )
        val specializationItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.specialization_item_filter1), "Consumable"),
            ItemFilter(getString(R.string.specialization_item_filter2), "GoldPer"),
            ItemFilter(getString(R.string.specialization_item_filter3), "Vision"),
            ItemFilter(getString(R.string.specialization_item_filter4), "Trinket")
        )
        val defenseItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.defense_item_filter1), "Health"),
            ItemFilter(getString(R.string.defense_item_filter2), "Armor"),
            ItemFilter(getString(R.string.defense_item_filter3), "SpellBlock"),
            ItemFilter(getString(R.string.defense_item_filter4), "HealthRegen")
        )
        val attackItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.attack_item_filter1), "Damage"),
            ItemFilter(getString(R.string.attack_item_filter2), "CriticalStrike"),
            ItemFilter(getString(R.string.attack_item_filter3), "AttackSpeed"),
            ItemFilter(getString(R.string.attack_item_filter4), "LifeSteal"),
            ItemFilter(getString(R.string.attack_item_filter5), "ArmorPenetration"),
        )
        val magicItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.magic_item_filter1), "SpellDamage"),
            ItemFilter(getString(R.string.magic_item_filter2), "MagicPenetration"),
            ItemFilter(getString(R.string.magic_item_filter3), "CooldownReduction"),
            ItemFilter(getString(R.string.magic_item_filter4), "Mana"),
            ItemFilter(getString(R.string.magic_item_filter5), "ManaRegen"),
        )
        val movementItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter(getString(R.string.movement_item_filter1), "Boots"),
            ItemFilter(getString(R.string.movement_item_filter2), "NonbootsMovement"),
        )

        val allItemsGroup = ItemFilterGroup(getString(R.string.all_item), allItems)
        val startItemsGroup = ItemFilterGroup(getString(R.string.start_item), startItems)
        val specializationItemsGroup = ItemFilterGroup(getString(R.string.specialization_item), specializationItems)
        val defenseItemsGroup = ItemFilterGroup(getString(R.string.defense_item), defenseItems)
        val attackItemsGroup = ItemFilterGroup(getString(R.string.start_item), attackItems)
        val magicItemsGroup = ItemFilterGroup(getString(R.string.magic_item), magicItems)
        val movementItemsGroup = ItemFilterGroup(getString(R.string.movement_item), movementItems)

        val itemFilterGroupList: ArrayList<ItemFilterGroup> =
            arrayListOf(allItemsGroup, startItemsGroup, specializationItemsGroup, defenseItemsGroup, attackItemsGroup, magicItemsGroup, movementItemsGroup)

        val handleClickFilterItem: (String) -> Unit = {
            itemViewModel.toggleTag(it)
            (binding.root.parent as DrawerLayout).closeDrawer(Gravity.END)
        }

        binding.itemFilterGroupRecyclerView.run {
            adapter = ItemFilterGroupListAdapter(itemFilterGroupList, handleClickFilterItem)
            layoutManager = LinearLayoutManager(context)
        }

        itemViewModel.tags.observe(viewLifecycleOwner, Observer { tags ->
            allItems.forEach { it.selected = tags.contains(it.key) }
            startItems.forEach { it.selected = tags.contains(it.key) }
            specializationItems.forEach { it.selected = tags.contains(it.key) }
            defenseItems.forEach { it.selected = tags.contains(it.key) }
            attackItems.forEach { it.selected = tags.contains(it.key) }
            magicItems.forEach { it.selected = tags.contains(it.key) }
            movementItems.forEach { it.selected = tags.contains(it.key) }
            binding.itemFilterGroupRecyclerView.adapter!!.notifyDataSetChanged()
        })
    }
}