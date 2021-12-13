package com.example.firstapp.adapter.SummorSpell

import android.app.AlertDialog
import android.content.DialogInterface
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.adapter.SummorSpell.ItemsViewModel
import com.example.firstapp.R

class CustomAdapter2(private val mList: ArrayList<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter2.ViewHolder>() {
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomAdapter2.ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: CustomAdapter2.ViewHolder, position: Int) {
        val itemModel = mList[position]

        val handleOnClick: View.OnClickListener = View.OnClickListener {
            val ddata = itemModel
            ddata.run {
                val dialogBuilder = AlertDialog.Builder(it.context, R.style.MyDialogTheme)
                dialogBuilder.setMessage(ddata.dialogText)
                    .setIcon(ddata.dialogIcon)
                    .setCancelable(false)
                    .setNegativeButton(
                        R.string.nextDialogText,
                        DialogInterface.OnClickListener { _, _ -> })
                val alert = dialogBuilder.create()
                alert.setTitle(ddata.dialogTitle)
                alert.show()

            }
        }

        holder.imageButton.setOnClickListener(handleOnClick)
        holder.textView.text = itemModel.text

    }

    override fun getItemCount(): Int {
        return mList.size
    }


    class ViewHolder(ItemView: View) : RecyclerView.ViewHolder(ItemView) {
        val imageButton: ImageButton = itemView.findViewById(R.id.rv_button)
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