package com.example.firstapp.adapter.universe

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.commit
import androidx.fragment.app.replace

import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.databinding.FragmentUniverseRegionItemBinding
import com.example.firstapp.fragment.build.BuildDetailActivity
import com.example.firstapp.fragment.universe.UniverseComicFragment
import com.example.firstapp.fragment.universe.UniverseRegionDetailActivity
import com.example.firstapp.model.universe.UniverseRegion
import com.example.firstapp.scene.champion.info.ChampionInfoFragment.Companion.newInstance

class UniverseRegionTabAdapter(val context: Context?, var itemList: ArrayList<UniverseRegion>): RecyclerView.Adapter<UniverseRegionTabAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder =
        ViewHolder(FragmentUniverseRegionItemBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.setData(itemList[position])

        holder.binding.regionCardView.setOnClickListener{
            val intent = Intent(context, UniverseRegionDetailActivity::class.java)
            context?.startActivity(intent)
        }
    }

    override fun getItemCount(): Int =
        itemList.size

    class ViewHolder(val binding: FragmentUniverseRegionItemBinding): RecyclerView.ViewHolder(binding.root) {
        fun setData(item: UniverseRegion) {
            binding.regionBackgroundImg.setImageResource(item.img)
            binding.regionIcon.setBackgroundResource(item.icon)
            binding.regionName.text = item.name
        }
    }
}