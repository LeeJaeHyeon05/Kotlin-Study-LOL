package com.example.firstapp.fragment

import android.os.Bundle
import android.view.*
import androidx.appcompat.widget.SearchView
import androidx.fragment.app.Fragment
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.GridLayoutManager
import com.example.firstapp.R
import com.example.firstapp.adapter.ItemListAdapter
import com.example.firstapp.bottomsheet.ItemSortBottomSheet
import com.example.firstapp.databinding.FragmentItemBinding
import com.example.firstapp.model.ItemViewModel
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemFragment : Fragment() {

    private lateinit var binding: FragmentItemBinding

    private val itemViewModel: ItemViewModel by activityViewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setHasOptionsMenu(true)
    }

    override fun onCreateOptionsMenu(menu: Menu, inflater: MenuInflater) {
        menu.clear()
        inflater.inflate(R.menu.item_menu, menu)

        val menuItem: MenuItem = menu.findItem(R.id.action_search)
        val searchView: SearchView = menuItem.actionView as SearchView
        searchView.queryHint = getString(R.string.item_name)

        searchView.setOnQueryTextFocusChangeListener { v, hasFocus ->
            menu.findItem(R.id.action_sort).isVisible = !hasFocus
        }
        searchView.setOnQueryTextListener(object : SearchView.OnQueryTextListener {
            override fun onQueryTextSubmit(query: String?): Boolean {
                return false
            }

            override fun onQueryTextChange(newText: String?): Boolean {
                return false
            }
        })
    }

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = FragmentItemBinding.inflate(layoutInflater)

        binding.itemList.run {
            adapter = ItemListAdapter(emptyList())
            layoutManager = GridLayoutManager(requireContext(), 5)
        }

        itemViewModel.dataList.observe(viewLifecycleOwner) {
            (binding.itemList.adapter as ItemListAdapter).setData(it)
        }

        return binding.root
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        when (item.itemId) {
            R.id.action_sort -> {
                val itemSortBottomSheet = ItemSortBottomSheet()
                itemSortBottomSheet.show(
                    requireActivity().supportFragmentManager,
                    ItemSortBottomSheet.TAG
                )
            }
        }

        return super.onOptionsItemSelected(item)
    }

    override fun onResume() {
        super.onResume()

        itemViewModel.loadData()
    }
}