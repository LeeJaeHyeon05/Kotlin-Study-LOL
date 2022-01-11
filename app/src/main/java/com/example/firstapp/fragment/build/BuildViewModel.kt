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


     val tabData = listOf<String>("공통", "역할", "역할군","지역")

    //ViewPager Groupie에 들어갈 내용
    val commonItem = listOf<String>("모두", "무료", "즐겨찾기","버프", "너프")
    val ruleItem = listOf<String>("탑", "정글", "미드","원거리 딜러","서포터")
    val ruleguneItem = listOf<String>("암살자", "전사", "마법사","탱커","원거리 딜러","서포터")
    val locationData = listOf<String>("준비중")

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

