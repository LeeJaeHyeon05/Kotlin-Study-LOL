package com.example.firstapp.fragment.build.detail.mybuild

import android.content.Context
import android.view.*
import android.widget.PopupMenu
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.recyclerview.widget.AsyncListDiffer
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemMyBuildBinding
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import com.example.firstapp.model.tier.TierChamp

//class MyBuildItemAdapter(var myBuildData : LiveData<MutableList<MyBuildRepositoryData>>):
//    RecyclerView.Adapter<MyBuildItemAdapter.MyBuildItemViewHolder>(){
//    lateinit var mContext : Context
//
//    private val diffUtilCallback = object : DiffUtil.ItemCallback<MyBuildRepositoryData>(){
//        override fun areItemsTheSame(oldItem: MyBuildRepositoryData, newItem: MyBuildRepositoryData): Boolean {
//            return oldItem.buildName == newItem.buildName
//        }
//
//        override fun areContentsTheSame(oldItem: MyBuildRepositoryData, newItem: MyBuildRepositoryData): Boolean {
//            return oldItem == newItem
//        }
//    }
//
//    val differ = AsyncListDiffer(this, diffUtilCallback)
//
//
//    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBuildItemViewHolder {
//        mContext = parent.context
//        return MyBuildItemViewHolder(ItemMyBuildBinding.inflate(LayoutInflater.from(parent.context), parent, false))
//    }
//
//    override fun getItemCount(): Int = myBuildData.value!!.size
//
//    override fun onBindViewHolder(holder: MyBuildItemViewHolder, position: Int) {
//        holder.setData()
//        holder.binding.itemMyBuildMenu.setOnClickListener {
//
//            val menu = PopupMenu(mContext, holder.binding.itemMyBuildMenu)
//            menu.inflate(R.menu.mybuild_item_menu)
//            menu.setOnMenuItemClickListener {
//                when(it.itemId){
//                    R.id.myBuildItem_Edit -> {
//                        Toast.makeText(mContext, "편집 $position", Toast.LENGTH_SHORT).show()
//                        false
//                    }
//
//                    R.id.myBuildItem_BuildStats -> {
//                        Toast.makeText(mContext, "빌드 통계 $position", Toast.LENGTH_SHORT).show()
//                        false
//                    }
//
//                    R.id.myBuildItem_Reorder -> {
//                        Toast.makeText(mContext, "재주문 $position", Toast.LENGTH_SHORT).show()
//                        false
//                    }
//
//                    R.id.myBuildItem_Delete -> {
//                        deleteItem(position)
//                        Toast.makeText(mContext, "삭제 $position", Toast.LENGTH_SHORT).show()
//                        false
//                    }
//
//                    else -> false
//                }
//            }
//
//            menu.show()
//        }
//    }
//
//    inner class MyBuildItemViewHolder(val binding: ItemMyBuildBinding)
//        : RecyclerView.ViewHolder(binding.root) {
//
//        fun setData() {
//            binding.itemMyBuildName.text = myBuildData.value!![absoluteAdapterPosition].buildName
//        }
//    }
//
//    private fun deleteItem(position: Int) {
//        val myBuildRepository = MyBuildRepository(mContext)
//    }
//}