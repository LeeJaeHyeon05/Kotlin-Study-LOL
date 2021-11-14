package com.example.firstapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.firstapp.R
import com.example.firstapp.adapter.ItemListAdapter
import com.example.firstapp.model.Data
import com.example.firstapp.model.ItemJson
import com.example.firstapp.util.getJsonDataFromAsset
import com.google.gson.Gson

class ItemFragment : Fragment() {
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view = inflater.inflate(R.layout.fragment_item, container, false)

        val jsonFileString = getJsonDataFromAsset(requireActivity().applicationContext, "item.json")
        val gson = Gson()
        val itemJson = gson.fromJson(jsonFileString, ItemJson::class.java)
        val data: Map<String, Data> = itemJson.data
        for((key, value) in data) value.id = key
        val dataList = data.map { it.value }
        val mItemListAdapter = ItemListAdapter(dataList)

        val recyclerView: RecyclerView = view.findViewById(R.id.itemList)
        recyclerView.adapter = mItemListAdapter
        recyclerView.layoutManager = GridLayoutManager(requireContext(), 5)

        return view
    }

}