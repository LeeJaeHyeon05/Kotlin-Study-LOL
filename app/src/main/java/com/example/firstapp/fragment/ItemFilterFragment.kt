package com.example.firstapp.fragment

import android.os.Bundle
import android.view.Gravity
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.drawerlayout.widget.DrawerLayout
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentItemFilterBinding
import com.example.firstapp.groupie.GroupieItemFilter
import com.example.firstapp.groupie.GroupieItemFilterHeader
import com.example.firstapp.model.ItemFilter
import com.example.firstapp.model.ItemViewModel
import com.xwray.groupie.GroupieAdapter
import com.xwray.groupie.Section
import com.xwray.groupie.groupiex.plusAssign

class ItemFilterFragment : Fragment() {

    private lateinit var binding: FragmentItemFilterBinding
    private lateinit var groupAdapter: GroupieAdapter

    private val itemViewModel: ItemViewModel by activityViewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentItemFilterBinding.inflate(layoutInflater)

        initLayout()

        return binding.root
    }

    private fun initLayout() {

        val handleClickFilterItem: (String) -> Unit = {
            itemViewModel.toggleTag(it)
            (binding.root.parent as DrawerLayout).closeDrawer(Gravity.END)
        }

        groupAdapter = GroupieAdapter().apply {
            setOnItemClickListener { item, _ ->
                if (item is GroupieItemFilter) {
                    handleClickFilterItem(item.itemFilter.key)
                }
            }
        }

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

        val startItemSection = Section()
        startItemSection.setHeader(GroupieItemFilterHeader(getString(R.string.start_item)))
        startItemSection.addAll(startItems.map { GroupieItemFilter(it) })
        groupAdapter += startItemSection

        val specializationItemSection = Section()
        specializationItemSection.setHeader(GroupieItemFilterHeader(getString(R.string.specialization_item)))
        specializationItemSection.addAll(specializationItems.map { GroupieItemFilter(it) })
        groupAdapter += specializationItemSection

        val defenseItemSection = Section()
        defenseItemSection.setHeader(GroupieItemFilterHeader(getString(R.string.defense_item)))
        defenseItemSection.addAll(defenseItems.map { GroupieItemFilter(it) })
        groupAdapter += defenseItemSection

        val attackItemSection = Section()
        attackItemSection.setHeader(GroupieItemFilterHeader(getString(R.string.attack_item)))
        attackItemSection.addAll(attackItems.map { GroupieItemFilter(it) })
        groupAdapter += attackItemSection

        val magicItemSection = Section()
        magicItemSection.setHeader(GroupieItemFilterHeader(getString(R.string.magic_item)))
        magicItemSection.addAll(magicItems.map { GroupieItemFilter(it) })
        groupAdapter += magicItemSection

        val movementItemSection = Section()
        movementItemSection.setHeader(GroupieItemFilterHeader(getString(R.string.movement_item)))
        movementItemSection.addAll(movementItems.map { GroupieItemFilter(it) })
        groupAdapter += movementItemSection

        binding.itemFilterGroupRecyclerView.run {
            layoutManager = LinearLayoutManager(context)
            adapter = groupAdapter
        }

        itemViewModel.tags.observe(viewLifecycleOwner) { tags ->
            startItems.forEach { it.selected = tags.contains(it.key) }
            specializationItems.forEach { it.selected = tags.contains(it.key) }
            defenseItems.forEach { it.selected = tags.contains(it.key) }
            attackItems.forEach { it.selected = tags.contains(it.key) }
            magicItems.forEach { it.selected = tags.contains(it.key) }
            movementItems.forEach { it.selected = tags.contains(it.key) }
            binding.itemFilterGroupRecyclerView.adapter!!.notifyDataSetChanged()
        }
    }
}