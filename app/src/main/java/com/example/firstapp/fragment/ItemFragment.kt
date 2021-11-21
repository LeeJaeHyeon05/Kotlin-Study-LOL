package com.example.firstapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.adapter.ItemListAdapter
import com.example.firstapp.database.dao.ItemDao
import com.example.firstapp.databinding.FragmentItemBinding
import com.example.firstapp.model.Data
import com.example.firstapp.model.ItemJson
import com.example.firstapp.util.getJsonDataFromAsset
import com.google.gson.Gson
import dagger.hilt.android.AndroidEntryPoint
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers.IO
import kotlinx.coroutines.launch
import javax.inject.Inject

@AndroidEntryPoint
class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding

    @Inject
    lateinit var itemDao: ItemDao

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(layoutInflater)

        val jsonFileString = getJsonDataFromAsset(requireActivity().applicationContext, "item.json")
        val gson = Gson()
        val itemJson = gson.fromJson(jsonFileString, ItemJson::class.java)
        val data: Map<String, Data> = itemJson.data

        for ((key, value) in data) value.id = key
        val dataList = data.map { it.value }

        CoroutineScope(IO).launch {
            dataList.forEach { itemDao.insertAll(it) }
        }

        binding.itemList.run {
            adapter = ItemListAdapter(dataList)
            layoutManager = GridLayoutManager(requireContext(), 5)
        }

        return binding.root
    }

}