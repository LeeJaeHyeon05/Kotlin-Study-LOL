package com.example.firstapp.model

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.repository.ItemRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class ItemViewModel @Inject constructor(private val itemRepository: ItemRepository): ViewModel() {

    private val _dataList = MutableLiveData<List<Items>>()
    val dataList: LiveData<List<Items>> = _dataList

    fun data() = viewModelScope.launch {
        val itemList = itemRepository.getItems()
        _dataList.value = itemList
    }

}