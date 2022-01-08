package com.example.firstapp.fragment.build

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemBuildMainBinding
import com.example.firstapp.model.mychampion.Datum

class BuildMainAdapter( var championList : List<Datum>): ListAdapter<Datum, BuildMainAdapter.ItemViewHolder>(diffUtilCallBack){




    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder =
        ItemViewHolder(ItemBuildMainBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int {
        return championList.size
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.setData(championList[position])

        holder.binding.championImage.setOnClickListener {
            openDetailFragment()

        }
    }

    //요즘 트랜드는 activity 단에서 companion object로 만든뒤, 호출한다.
    private fun openDetailFragment() {
//        val intent = Intent(context, BuildDetailActivity::class.java)
//        context?.startActivity(intent)

    }

    class ItemViewHolder(val binding: ItemBuildMainBinding): RecyclerView.ViewHolder(binding.root){
        fun setData(championData: Datum){
            binding.championData = championData
        }
    }
}

private val diffUtilCallBack = object : DiffUtil.ItemCallback<Datum>(){
    override fun areItemsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return oldItem.id == newItem.id
    }

    override fun areContentsTheSame(oldItem: Datum, newItem: Datum): Boolean {
        return oldItem.id == newItem.id
    }


}
