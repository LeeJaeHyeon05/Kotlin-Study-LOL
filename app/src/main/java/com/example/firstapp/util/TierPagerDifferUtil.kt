package com.example.firstapp.util

import androidx.recyclerview.widget.DiffUtil
import com.example.firstapp.model.tier.TierLine

class TierPagerDifferUtil(private val oldList: List<TierLine>, private val newList: List<TierLine>):DiffUtil.Callback() {
    override fun getOldListSize() = oldList.size

    override fun getNewListSize() = newList.size

    override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }

    override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
        TODO("Not yet implemented")
    }
}