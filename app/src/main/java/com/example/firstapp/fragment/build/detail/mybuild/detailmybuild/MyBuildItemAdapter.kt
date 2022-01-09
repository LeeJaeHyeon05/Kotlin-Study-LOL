package com.example.firstapp.fragment.build.detail.mybuild.detailmybuild

import android.content.Context
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemMyBuildBinding
import com.example.firstapp.model.MyBuild

class MyBuildItemAdapter(val context: Context):
    RecyclerView.Adapter<MyBuildItemAdapter.MyBuildItemViewHolder>(){
    var myBuildData : List<MyBuild> = emptyList()

    private val diffUtilCallback = object : DiffUtil.ItemCallback<MyBuild>(){
        override fun areItemsTheSame(oldItem: MyBuild, newItem: MyBuild): Boolean {
            return oldItem.id == newItem.id
        }

        override fun areContentsTheSame(oldItem: MyBuild, newItem: MyBuild): Boolean {
            return oldItem == newItem
        }
    }

    val differ = AsyncListDiffer(this, diffUtilCallback)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBuildItemViewHolder {
        return MyBuildItemViewHolder(ItemMyBuildBinding.inflate(LayoutInflater.from(parent.context), parent, false))
    }

    override fun getItemCount(): Int = myBuildData.size

    override fun onBindViewHolder(holder: MyBuildItemViewHolder, position: Int) {
        holder.setData()

        holder.binding.itemMyBuildMenu.setOnClickListener {

            val menu = PopupMenu(context, holder.binding.itemMyBuildMenu)
            menu.inflate(R.menu.mybuild_item_menu)
            menu.setOnMenuItemClickListener {
                when(it.itemId){
                    R.id.myBuildItem_Edit -> {
                        Toast.makeText(context, "편집 $position", Toast.LENGTH_SHORT).show()
                        false
                    }

                    R.id.myBuildItem_BuildStats -> {
                        Toast.makeText(context, "빌드 통계 $position", Toast.LENGTH_SHORT).show()
                        false
                    }

                    R.id.myBuildItem_Reorder -> {
                        Toast.makeText(context, "재주문 $position", Toast.LENGTH_SHORT).show()
                        false
                    }

                    R.id.myBuildItem_Delete -> {
                        Toast.makeText(context, "삭제 $position", Toast.LENGTH_SHORT).show()
                        false
                    }

                    else -> false
                }
            }
            menu.show()
        }
    }

    inner class MyBuildItemViewHolder(val binding: ItemMyBuildBinding)
        : RecyclerView.ViewHolder(binding.root) {

        fun setData() {
            binding.itemMyBuildName.text = myBuildData[absoluteAdapterPosition].name
        }
    }
}