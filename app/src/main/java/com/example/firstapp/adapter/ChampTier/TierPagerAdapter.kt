package com.example.firstapp.adapter.ChampTier

import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.DiffUtil
import androidx.viewpager2.adapter.FragmentStateAdapter
import androidx.viewpager2.adapter.FragmentViewHolder
import com.example.firstapp.model.tier.TierLine
import com.example.firstapp.util.TierPagerDifferUtil

// ViewPager2에서 사용될 adapter
class TierPagerAdapter(fragment:Fragment) : FragmentStateAdapter(fragment) {

    override fun getItemCount(): Int {
        return 5
    }

    override fun createFragment(position: Int): Fragment {
        TODO("Not yet implemented")
    }

    //
    override fun getItemId(position: Int): Long {
        return super.getItemId(position)
    }

    //
    override fun containsItem(itemId: Long): Boolean {
        return super.containsItem(itemId)
    }

    override fun onBindViewHolder(
        holder: FragmentViewHolder,
        position: Int,
        payloads: MutableList<Any>
    ) {
        super.onBindViewHolder(holder, position, payloads)
    }

    fun setItems(newItems: TierLine) {
        val callback = TierPagerDifferUtil(items, newItems)
        val diff = DiffUtil.calculateDiff(callback)

        items.clear()
        items.addAll(newItems)

        diff.dispatchUpdatesTo(this)
    }
}