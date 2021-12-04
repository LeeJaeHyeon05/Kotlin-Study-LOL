package com.example.firstapp

import android.content.Context
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import kotlin.coroutines.coroutineContext

//val view = LayoutInflater.from(parent.context)
//    .inflate(R.layout.item_list, parent, false)

class CustomAdapter(private val mList: List<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {

        return ViewHolder(LayoutInflater.from(context).inflate(R.layout.item_list,parent,false))
    }

    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val ItemsViewModel = mList[position]

        holder.imageView.setImageResource(ItemsViewModel.image)
        holder.textView.text = ItemsViewModel.text
    }

    override fun getItemCount(): Int {
        return mList.size
    }

    class ViewHolder(ItemView:View) : RecyclerView.ViewHolder(ItemView) {
        val imageView: ImageView = itemView.findViewById(R.id.rv_button)
        val textView: TextView = itemView.findViewById(R.id.rv_textView)
    }

    //간격 늘리기
    class HorizontalSpaceItemDecoration(private val horizontalSpaceItemDecoration: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.right = horizontalSpaceItemDecoration
        }
    }

    class TopSpaceItemDecoration(private val TopSpaceItemDecoration: Int) : RecyclerView.ItemDecoration() {
        override fun getItemOffsets(
            outRect: Rect,
            view: View,
            parent: RecyclerView,
            state: RecyclerView.State
        ) {
            outRect.top = TopSpaceItemDecoration
        }
    }


}