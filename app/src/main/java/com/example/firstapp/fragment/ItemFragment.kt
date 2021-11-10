package com.example.firstapp.fragment

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import com.example.firstapp.R
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
        val data = itemJson.data

        return view
    }
}