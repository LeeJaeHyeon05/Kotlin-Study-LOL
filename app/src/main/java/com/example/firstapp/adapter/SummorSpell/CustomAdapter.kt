package com.example.firstapp.adapter.SummorSpell

import android.app.AlertDialog
import android.content.Context
import android.content.DialogInterface
import android.graphics.Rect
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageButton
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.adapter.SummorSpell.ItemsViewModel
import com.example.firstapp.R
import kotlin.io.path.createTempDirectory

class CustomAdapter(private val mList: ArrayList<ItemsViewModel>) : RecyclerView.Adapter<CustomAdapter.ViewHolder>(){

    // 아이템 레이아웃 결합
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context)
            .inflate(R.layout.item_list, parent, false)

        return ViewHolder(view)
    }


    //View에 내용 입력
    override fun onBindViewHolder(holder: CustomAdapter.ViewHolder, position: Int) {
        val itemModel = mList[position]

        val handleOnClick: View.OnClickListener = View.OnClickListener {
            val ddata = itemModel
            ddata.run {
                val dialogBuilder = AlertDialog.Builder(it.context, R.style.MyDialogTheme)
                dialogBuilder.setMessage(ddata.dialogText)
                    .setIcon(ddata.dialogIcon)
                    .setCancelable(false)
                    .setNegativeButton(R.string.nextDialogText, DialogInterface.OnClickListener { _, _ ->  })
                val alert = dialogBuilder.create()
                alert.setTitle(ddata.dialogTitle)
                alert.show()

            }
        }

        holder.imageButton.setOnClickListener(handleOnClick)
        holder.textView.text = itemModel.text

    }



    //리스트 내 아이템 개수 정하기
    override fun getItemCount(): Int {
        return mList.size
    }

    //레이아웃과 나의 View 연결
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

    //간격 줄이기
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