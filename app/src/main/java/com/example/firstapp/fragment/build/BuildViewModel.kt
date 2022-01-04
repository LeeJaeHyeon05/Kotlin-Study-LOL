package com.example.firstapp.fragment.build

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.data.repository.di.BuildRepository
import com.example.firstapp.model.mychampion.Champion
import com.example.firstapp.model.mychampion.Datum
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class BuildViewModel @Inject constructor(
    private val buildRepository: BuildRepository
) : ViewModel() {

    private lateinit var originalChampionList : List<BuildItem>



    private val _ChampionList  = MutableStateFlow<List<BuildItem>>(emptyList())
    val mChampionList = _ChampionList


     val tabData = listOf<String>(    "공통", "무료", "역할군","지역")

    private val _searchQuery = MutableStateFlow("")

    val searchQuery = _searchQuery

    fun getChampion() {
        viewModelScope.launch {
            buildRepository.getChampions(
                    onSuccess = {

                    },
                    onError = {

                    },
                    onException = {

                    }

            ).collect {Champion ->
                originalChampionList = Champion.data.values.toList()
                    .sortedBy { it.name }
                    .map{BuildItem(it)}

                _ChampionList.value = originalChampionList
            }
        }
    }

    fun setSearchQuery(searchQuery: String) = viewModelScope.launch {
        _searchQuery.value = searchQuery
        _ChampionList.value = originalChampionList.filter {chapion->
            chapion.dataNum.name.contains(_searchQuery.value.toString())}
        }
    }

