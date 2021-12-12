package com.example.firstapp.model

import androidx.lifecycle.*
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

    private val mDataList: MutableLiveData<List<Item>> = MutableLiveData<List<Item>>(emptyList())
    private val mItemSortType: MutableLiveData<ItemSortType> = MutableLiveData<ItemSortType>(ItemSortType.NAME)
    private val mSearchQuery: MutableLiveData<String> = MutableLiveData<String>("")
    private val mTags: MutableLiveData<List<String>> = MutableLiveData<List<String>>(emptyList())
    private val mSelectedItem: MutableLiveData<Item> = MutableLiveData<Item>(null)

    val itemSortType: LiveData<ItemSortType> = mItemSortType
    val tags: LiveData<List<String>> = mTags
    val selectedItem: LiveData<Item> = mSelectedItem
    val uiDataList: MediatorLiveData<List<Item>> = MediatorLiveData<List<Item>>()

    val nameAndTagFilter: () -> Unit = {
        val filteredItemList = mDataList.value?.filter { item ->
            val nameFilter = item.name.contains(mSearchQuery.value.toString())
            var tagFilter = true

            val typeToken = object : TypeToken<List<String>>() {}.type
            val itemTagList = Gson().fromJson<List<String>>(item.tags, typeToken)

            for (tag in mTags.value!!) {
                if (!itemTagList.contains(tag)) {
                    tagFilter = false
                    break
                }
            }
            nameFilter && tagFilter
        }.orEmpty()
        uiDataList.postValue(filteredItemList)
    }

    init {
        uiDataList.value = emptyList()
        uiDataList.addSource(mDataList) { itemList -> uiDataList.postValue(itemList.sortedBy { it.name }) }
        uiDataList.addSource(mItemSortType) { sortType ->
            if (sortType === ItemSortType.NAME) uiDataList.postValue(uiDataList.value?.sortedBy { it.name }.orEmpty())
            if (sortType === ItemSortType.PRICE_ASC) uiDataList.postValue(uiDataList.value?.sortedBy { it.itemGold?.total }.orEmpty())
            if (sortType === ItemSortType.PRICE_DESC) uiDataList.postValue(uiDataList.value?.sortedByDescending { it.itemGold?.total }.orEmpty())
        }

        uiDataList.addSource(mSearchQuery) { nameAndTagFilter() }
        uiDataList.addSource(mTags) { nameAndTagFilter() }

        viewModelScope.launch {
            val items = itemRepository.getItems()
            items.forEach { item ->
                item.itemImage = Gson().fromJson(item.image, ItemImage::class.java)
                item.itemGold = Gson().fromJson(item.gold, ItemGold::class.java)
            }
            mDataList.postValue(items)
        }
    }

    fun setItemSortType(itemSortType: ItemSortType) = viewModelScope.launch {
        mItemSortType.postValue(itemSortType)
    }

    fun setSearchQuery(searchQuery: String) = viewModelScope.launch {
        mSearchQuery.postValue(searchQuery)
    }

    fun toggleTag(tag: String) = viewModelScope.launch {
        val tags = mTags.value!!.toMutableList()
        if (tags.contains(tag)) {
            tags.remove(tag)
        } else {
            tags.add(tag)
        }
        mTags.postValue(tags)
    }

    fun setSelectedItem(it: String) = viewModelScope.launch {
        mSelectedItem.postValue(mDataList.value?.find { item -> item.id == it })
    }
}