package com.example.firstapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.repository.ItemRepository
import com.google.gson.Gson
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ItemSortType {
    NAME, PRICE_ASC, PRICE_DESC
}

@HiltViewModel
class ItemViewModel @Inject constructor(private val itemRepository: ItemRepository) : ViewModel() {

    private lateinit var originalDataList: List<Items>
    private val _dataList = MutableLiveData<List<Items>>()
    val dataList: LiveData<List<Items>> = _dataList
    private val _itemSortType = MutableLiveData<ItemSortType>()
    val itemSortType: LiveData<ItemSortType> = _itemSortType

    init {
        _itemSortType.value = ItemSortType.NAME
    }

    fun loadData() = viewModelScope.launch {
        lateinit var itemList: List<Items>

        if (::originalDataList.isInitialized) {
            itemList = originalDataList
        } else {
            itemList = itemRepository.getItems()
            originalDataList = itemList
            _dataList.value = itemList
        }

        val mutableItemList = itemList.toMutableList()
        mutableItemList.forEach {
            it.itemImage = Gson().fromJson(it.image, ItemImage::class.java)
            it.itemGold = Gson().fromJson(it.gold, ItemGold::class.java)
        }

        if (_itemSortType.value === ItemSortType.NAME) mutableItemList.sortBy { it.name }
        if (_itemSortType.value === ItemSortType.PRICE_ASC) mutableItemList.sortBy { it.itemGold!!.total }
        if (_itemSortType.value === ItemSortType.PRICE_DESC) mutableItemList.sortByDescending { it.itemGold!!.total }

        _dataList.value = mutableItemList.toList()
    }

    fun setItemSortType(itemSortType: ItemSortType) = viewModelScope.launch {
        _itemSortType.value = itemSortType
    }

}