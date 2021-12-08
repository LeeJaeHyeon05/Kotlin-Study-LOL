package com.example.firstapp.fragment.build.detail.MyBuild

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.databinding.ItemMyBuildBinding

class MyBuildItemAdapter(var myBuildData : MutableList<MyBuildData>): RecyclerView.Adapter<MyBuildItemAdapter.MyBuildItemViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MyBuildItemViewHolder =
        MyBuildItemViewHolder(ItemMyBuildBinding.inflate(LayoutInflater.from(parent.context), parent, false))

    override fun getItemCount(): Int = 0

    override fun onBindViewHolder(holder: MyBuildItemViewHolder, position: Int) {

    }

    class MyBuildItemViewHolder(val binding: ItemMyBuildBinding): RecyclerView.ViewHolder(binding.root){
        fun setData(){

        }
    }
}

data class MyBuildData(
    val title: String,
    val item: List<String>,
    val spell: List<String>
)