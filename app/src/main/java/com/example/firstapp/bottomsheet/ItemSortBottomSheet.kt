package com.example.firstapp.bottomsheet

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.activityViewModels
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemSortBottomSheetContentBinding
import com.example.firstapp.model.ItemSortType
import com.example.firstapp.model.ItemViewModel
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class ItemSortBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: ItemSortBottomSheetContentBinding

    private val itemViewModel: ItemViewModel by activityViewModels()

    companion object {
        const val TAG = "ItemSortBottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        binding = ItemSortBottomSheetContentBinding.inflate(layoutInflater)

        binding.sortNameLayout.setOnClickListener(handleOnClick)
        binding.sortPriceAscLayout.setOnClickListener(handleOnClick)
        binding.sortPriceDescLayout.setOnClickListener(handleOnClick)

        itemViewModel.itemSortType.observe(viewLifecycleOwner) {
            binding.sortNameCheck.visibility = View.GONE
            binding.sortPriceAscCheck.visibility = View.GONE
            binding.sortPriceDescCheck.visibility = View.GONE

            when (it) {
                ItemSortType.NAME -> binding.sortNameCheck.visibility = View.VISIBLE
                ItemSortType.PRICE_ASC -> binding.sortPriceAscCheck.visibility = View.VISIBLE
                ItemSortType.PRICE_DESC -> binding.sortPriceDescCheck.visibility = View.VISIBLE
                null -> binding.sortNameCheck.visibility = View.VISIBLE
            }
        }

        return binding.root
    }

    private val handleOnClick: View.OnClickListener = View.OnClickListener {
        when (it.id) {
            R.id.sort_name_layout -> {
                itemViewModel.setItemSortType(ItemSortType.NAME)
            }
            R.id.sort_price_asc_layout -> {
                itemViewModel.setItemSortType(ItemSortType.PRICE_ASC)
            }
            R.id.sort_price_desc_layout -> {
                itemViewModel.setItemSortType(ItemSortType.PRICE_DESC)
            }
        }

        dismiss()
    }
}