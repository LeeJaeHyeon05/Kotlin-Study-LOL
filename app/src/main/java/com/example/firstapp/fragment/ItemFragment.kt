package com.example.firstapp.fragment

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.Observer
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.adapter.ItemListAdapter
import com.example.firstapp.databinding.FragmentItemBinding
import com.example.firstapp.model.Data
import com.example.firstapp.model.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding

    private val itemViewModel: ItemViewModel by viewModels()

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(layoutInflater)

        binding.itemList.run {
            adapter = ItemListAdapter(emptyList())
            layoutManager = GridLayoutManager(requireContext(), 5)
        }

        itemViewModel.dataList.observe(requireActivity(), Observer<List<Data>> {
                it -> (binding.itemList.adapter as ItemListAdapter).setData(it)
        })

        return binding.root
    }

    override fun onResume() {
        super.onResume()

        itemViewModel.data()
    }
}