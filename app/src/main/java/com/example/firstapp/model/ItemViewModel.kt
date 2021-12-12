package com.example.firstapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.repository.ItemRepository
import com.google.gson.Gson
import com.google.gson.reflect.TypeToken
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

enum class ItemSortType {
    NAME, PRICE_ASC, PRICE_DESC
}

@HiltViewModel
class ItemViewModel @Inject constructor(private val itemRepository: ItemRepository) : ViewModel() {

    private lateinit var originalDataList: List<Item>
    private val _dataList = MutableLiveData<List<Item>>()
    val dataList: LiveData<List<Item>> = _dataList
    private val _itemSortType = MutableLiveData<ItemSortType>()
    val itemSortType: LiveData<ItemSortType> = _itemSortType
    private val _searchQuery = MutableLiveData("")
    private val _tags = MutableLiveData<List<String>>()
    val tags: LiveData<List<String>> = _tags

    init {
        _itemSortType.value = ItemSortType.NAME
        _tags.value = listOf()
    }

    fun loadData() = viewModelScope.launch {
        lateinit var itemList: List<Item>

        if (::originalDataList.isInitialized) {
            itemList = originalDataList
        } else {
            itemList = itemRepository.getItems()
            originalDataList = itemList
            _dataList.value = itemList
        }

        val mutableItemList = itemList.filter { item ->
            val nameFilter = item.name.contains(_searchQuery.value.toString())
            var tagFilter = true

            val typeToken = object: TypeToken<List<String>>(){}.type
            val itemTagList = Gson().fromJson<List<String>>(item.tags, typeToken)

            for (tag in _tags.value!!) {
                if (!itemTagList.contains(tag)) {
                    tagFilter = false
                    break
                }
            }
            nameFilter && tagFilter
        }.toMutableList()

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
        loadData()
    }

    fun setSearchQuery(searchQuery: String) = viewModelScope.launch {
        _searchQuery.value = searchQuery
        loadData()
    }

    fun toggleTag(tag: String) = viewModelScope.launch {
        val tags = _tags.value!!.toMutableList()
        if (_tags.value!!.contains(tag)) {
            tags.remove(tag)
        } else {
            tags.add(tag)
        }
        _tags.value = tags
        loadData()
    }

}