package com.example.firstapp.fragment.bottomsheet

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.activityViewModels
import com.example.firstapp.databinding.ItemDetailBottomSheetContentBinding
import com.example.firstapp.model.ItemViewModel
import com.example.firstapp.util.getBaseImageUrl
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.squareup.picasso.Picasso

class ItemDetailBottomSheet : BottomSheetDialogFragment() {

    private lateinit var binding: ItemDetailBottomSheetContentBinding

    private val itemViewModel: ItemViewModel by activityViewModels()

    companion object {
        const val TAG = "ItemDetailBottomSheet"
    }

    override fun onCreateView(
        inflater: LayoutInflater,
        container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = ItemDetailBottomSheetContentBinding.inflate(layoutInflater)

        itemViewModel.selectedItem.observe(viewLifecycleOwner) { item ->
            Picasso.get().load("${getBaseImageUrl()}/item/${item.id}.png").into(binding.itemDetailImage)
            binding.itemDetailName.text = item.name
            binding.itemDetailPrice.text = "가격 ${item.itemGold!!.total} (${item.itemGold!!.base}) 팔기 ${item.itemGold!!.sell}"
            binding.itemDetailDesc.text = Html.fromHtml(item.description, HtmlCompat.FROM_HTML_MODE_LEGACY)

            Picasso.get().load("${getBaseImageUrl()}/item/${item.id}.png").into(binding.itemCombinationImage)
            binding.itemCombinationName.text = item.name
            binding.itemCombinationPrice.text = "가격 ${item.itemGold!!.total} (${item.itemGold!!.base})"
        }

        return binding.root
    }
}