package com.example.firstapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.data.repository.di.BuildRepository
import com.example.firstapp.fragment.build.BuildFilter
import com.example.firstapp.fragment.build.BuildItem
import com.example.firstapp.util.MutableEventFlow
import com.example.firstapp.util.asEventFlow
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


    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery

    //viewmodel에서 activity로 이벤트를 처리한다.
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()



    val commonItems: ArrayList<BuildFilter> = arrayListOf(
        BuildFilter("모두", "all"),
        BuildFilter("무료", "free"),
        BuildFilter("버프", "buff"),
        BuildFilter("너프", "nerf"),
        BuildFilter("즐겨찾기", "free"),
    )

    val roleItems: ArrayList<BuildFilter> = arrayListOf(
        BuildFilter("탑", "Top"),
        BuildFilter("정글", "jungle"),
        BuildFilter("미드", "Mid"),
        BuildFilter("원거리딜러", "MarksMan"),
        BuildFilter("서포터", "Support")
    )

    val roleGroupItems : ArrayList<BuildFilter> = arrayListOf(
        BuildFilter("암살자", "Top"),
        BuildFilter("전사", "Mid"),
        BuildFilter("마법사", "MarksMan"),
        BuildFilter("탱커", "MarksMan"),
        BuildFilter("원거리 딜러", "MarksMan"),
        BuildFilter("서포터", "Support")
    )

    val locationItems : ArrayList<BuildFilter> = arrayListOf(
        BuildFilter("준비" ,"준비중")
    )

    val totalItems  = arrayListOf<List<BuildFilter>>(commonItems,roleItems,roleGroupItems,locationItems)




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
                    .map{ BuildItem(it) }

                _ChampionList.value = originalChampionList
            }
        }
    }

    fun setSearchQuery(searchQuery: String) = viewModelScope.launch {
        _searchQuery.value = searchQuery
        _ChampionList.value = originalChampionList.filter {chapion->
            chapion.dataNum.name.contains(_searchQuery.value.toString())}
        }

    fun removeBottomFragment() {
        event(Event.removeBottomFragment("dummy"))
    }


    private fun event(event: BuildViewModel.Event) {
        viewModelScope.launch {
            _eventFlow.emit(event)
        }
    }


    sealed class Event {
        data class removeBottomFragment(
            val event: String
        ) : Event()
    }
}

