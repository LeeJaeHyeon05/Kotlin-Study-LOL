package com.example.firstapp.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.model.Data
import com.squareup.picasso.Picasso
import de.hdodenhof.circleimageview.CircleImageView

class ItemListAdapter(private val dataSet: List<Data>) :
    RecyclerView.Adapter<ItemListAdapter.ViewHolder>() {

    /**
     * Provide a reference to the type of views that you are using
     * (custom ViewHolder).
     */
    class ViewHolder(view: View) : RecyclerView.ViewHolder(view) {
        val itemImage: CircleImageView
        val itemName: TextView

        init {
            // Define click listener for the ViewHolder's View.
            itemImage = view.findViewById(R.id.itemImage)
            itemName = view.findViewById(R.id.itemName)
        }
    }

    // Create new views (invoked by the layout manager)
    override fun onCreateViewHolder(viewGroup: ViewGroup, viewType: Int): ViewHolder {
        // Create a new view, which defines the UI of the list item
        val view = LayoutInflater.from(viewGroup.context)
            .inflate(R.layout.item, viewGroup, false)

        return ViewHolder(view)
    }

    // Replace the contents of a view (invoked by the layout manager)
    override fun onBindViewHolder(viewHolder: ViewHolder, position: Int) {

        // Get element from your dataset at this position and replace the
        // contents of the view with that element

        Picasso.get().load("https://ddragon.leagueoflegends.com/cdn/11.22.1/img/item/${dataSet.get(position).id}.png").into(viewHolder.itemImage);
        viewHolder.itemName.text = dataSet.get(position).name
    }

    // Return the size of your dataset (invoked by the layout manager)
    override fun getItemCount() = dataSet.size

}
