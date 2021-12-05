package com.example.firstapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.adapter.ItemFilterListAdapter
import com.example.firstapp.databinding.FragmentItemFilterBinding
import com.example.firstapp.model.ItemFilter

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
            ItemFilter("신화급"),
            ItemFilter("전설급"),
            ItemFilter("서사급"),
            ItemFilter("기본"),
        )

        val startItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter("공격로"),
            ItemFilter("정글"),
        )

        val specializationItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter("소모품"),
            ItemFilter("골드획득"),
            ItemFilter("시야"),
            ItemFilter("장신구"),
        )

        val defenseItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter("체력"),
            ItemFilter("방어력"),
            ItemFilter("마법 저항"),
            ItemFilter("체력 회복"),
        )

        val attackItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter("공격력"),
            ItemFilter("치명타"),
            ItemFilter("공격 속도"),
            ItemFilter("생명력 흡수"),
            ItemFilter("방어구 관통력"),
        )

        val magicItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter("주문력"),
            ItemFilter("마법 관통력"),
            ItemFilter("스킬 가속"),
            ItemFilter("마나"),
            ItemFilter("마나 회복"),
        )

        val movementItems: ArrayList<ItemFilter> = arrayListOf(
            ItemFilter("장화"),
            ItemFilter("기타 이동 관련"),
        )

        binding.allItemList.run {
            adapter = ItemFilterListAdapter(allItems)
            layoutManager = LinearLayoutManager(context)
        }

        binding.startItemList.run {
            adapter = ItemFilterListAdapter(startItems)
            layoutManager = LinearLayoutManager(context)
        }

        binding.specializationItemList.run {
            adapter = ItemFilterListAdapter(specializationItems)
            layoutManager = LinearLayoutManager(context)
        }

        binding.defenseItemList.run {
            adapter = ItemFilterListAdapter(defenseItems)
            layoutManager = LinearLayoutManager(context)
        }

        binding.attackItemList.run {
            adapter = ItemFilterListAdapter(attackItems)
            layoutManager = LinearLayoutManager(context)
        }

        binding.magicItemList.run {
            adapter = ItemFilterListAdapter(magicItems)
            layoutManager = LinearLayoutManager(context)
        }

        binding.movementItemList.run {
            adapter = ItemFilterListAdapter(movementItems)
            layoutManager = LinearLayoutManager(context)
        }
    }
}