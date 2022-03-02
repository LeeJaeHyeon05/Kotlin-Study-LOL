package com.example.firstapp.fragment.rune

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.firstapp.R
import de.hdodenhof.circleimageview.CircleImageView


class RuneAdapter(private val context: Context): RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    var datas = mutableListOf<Item>()

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        val view: View?
        return when(viewType) {
            BIG_POSITION -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.rune_item_list,
                    parent,
                    false
                )
                MultiViewHolder1(view)
            }
            else  -> {
                view = LayoutInflater.from(parent.context).inflate(
                    R.layout.rune_item_small_list, parent, false
                )
                MultiViewHolder2(view)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when(datas[position].type) {
            BIG_POSITION -> {
                (holder as MultiViewHolder1).bind(datas[position])
                holder.setIsRecyclable(false)
            } else -> {
                (holder as MultiViewHolder2).bind(datas[position])
                holder.setIsRecyclable(false)
            }
        }
    }

    inner class MultiViewHolder1(view: View): RecyclerView.ViewHolder(view) {
        private val runeImg: ImageButton = view.findViewById(R.id.bigRuneItem)

        fun bind(item: Item) {
            Glide.with(itemView).load(item.image).into(runeImg)
        }
    }

    inner class MultiViewHolder2(view: View): RecyclerView.ViewHolder(view) {
        private val smallRuneImg: ImageButton = view.findViewById(R.id.SmallRuneItem)

        fun bind(item: Item) {
            Glide.with(itemView).load(item.image).into(smallRuneImg)
        }
    }

    override fun getItemCount(): Int = datas.size

    override fun getItemViewType(position: Int): Int {
        return datas[position].type
    }
}