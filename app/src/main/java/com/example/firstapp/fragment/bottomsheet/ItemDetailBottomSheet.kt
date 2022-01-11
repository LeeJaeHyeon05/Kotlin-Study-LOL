package com.example.firstapp.fragment.bottomsheet

import android.os.Bundle
import android.text.Html
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.core.text.HtmlCompat
import androidx.fragment.app.activityViewModels
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.databinding.ItemDetailBottomSheetContentBinding
import com.example.firstapp.groupie.GroupieItemFrom
import com.example.firstapp.groupie.GroupieItemInto
import com.example.firstapp.model.Item
import com.example.firstapp.model.ItemViewModel
import com.example.firstapp.util.getBaseImageUrl
import com.example.firstapp.util.getItemDescriptionToHtml
import com.google.android.material.bottomsheet.BottomSheetDialogFragment
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import com.squareup.picasso.Picasso
import com.xwray.groupie.GroupieAdapter

class ItemDetailBottomSheet(private val itemId: String) : BottomSheetDialogFragment() {

    private lateinit var binding: ItemDetailBottomSheetContentBinding
    private lateinit var fromAdapter: GroupieAdapter
    private lateinit var intoAdapter: GroupieAdapter

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

        val item: Item = itemViewModel.allItemList.value?.find { it.id == itemId }!!

        Picasso.get().load("${getBaseImageUrl()}/item/${item.id}.png").into(binding.itemDetailImage)
        binding.itemDetailName.text = item.name
        binding.itemDetailPrice.text = "${getString(R.string.price)} ${item.itemGold!!.total} (${item.itemGold!!.base}) ${getString(R.string.sell)} ${item.itemGold!!.sell}"
        binding.itemDetailDesc.text = Html.fromHtml(getItemDescriptionToHtml(item.description), HtmlCompat.FROM_HTML_MODE_COMPACT)

        Picasso.get().load("${getBaseImageUrl()}/item/${item.id}.png").into(binding.itemCombinationImage)
        binding.itemCombinationName.text = item.name
        binding.itemCombinationPrice.text = "${getString(R.string.price)} ${item.itemGold!!.total} (${item.itemGold!!.base})"

        val typeToken = object : TypeToken<List<String>>() {}.type
        val fromList = Gson().fromJson<List<String>>(item.from, typeToken)
        val intoList = Gson().fromJson<List<String>>(item.into, typeToken)

        val fromItemList = itemViewModel.allItemList.value?.filter { fromList.contains(it.id) }.orEmpty()
        val intoItemList = itemViewModel.allItemList.value?.filter { intoList.contains(it.id) }.orEmpty()

        if (fromItemList.isEmpty()) binding.itemCombinationLayout.visibility = View.GONE
        else binding.itemCombinationLayout.visibility = View.VISIBLE
        if (intoItemList.isEmpty()) binding.itemUpperBuildLayout.visibility = View.GONE
        else binding.itemUpperBuildLayout.visibility = View.VISIBLE

        fromAdapter = GroupieAdapter()
        fromAdapter.addAll(fromItemList.map { GroupieItemFrom(it, handleClickItem) })

        intoAdapter = GroupieAdapter()
        intoAdapter.addAll(intoItemList.map { GroupieItemInto(it, handleClickItem) })

        binding.itemCombinationRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = fromAdapter
        }

        binding.itemUpperBuildRecyclerView.apply {
            layoutManager = LinearLayoutManager(context)
            adapter = intoAdapter
        }

        return binding.root
    }

    private val handleClickItem: (String) -> Unit = {
        val itemDetailBottomSheet = ItemDetailBottomSheet(it)
        itemDetailBottomSheet.show(
            requireActivity().supportFragmentManager,
            TAG
        )
    }
}