package com.example.firstapp.model

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.data.repository.di.BuildRepository
import com.example.firstapp.databinding.BuildFilterBottomItemBinding
import com.example.firstapp.fragment.build.BuildBottomItem
import com.example.firstapp.fragment.build.BuildFilter
import com.example.firstapp.fragment.build.BuildItem
import com.example.firstapp.util.MutableEventFlow
import com.example.firstapp.util.asEventFlow
import com.xwray.groupie.databinding.BindableItem
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.*
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class BuildViewModel @Inject constructor(
    private val buildRepository: BuildRepository
) : ViewModel() {

    private lateinit var originalChampionList: List<BuildItem>

    private val _ChampionList = MutableStateFlow<List<BuildItem>>(emptyList())
    val mChampionList = _ChampionList


    private val _searchQuery = MutableStateFlow("")
    val searchQuery = _searchQuery

    //viewmodel에서 activity로 이벤트를 처리한다.
    private val _eventFlow = MutableEventFlow<Event>()
    val eventFlow = _eventFlow.asEventFlow()


    //todo 해당 viewmodel에서 stateflow를 하나 만든다.


    private val _commonItemFlow = MutableStateFlow<List<BuildFilter>>(
        arrayListOf(
            BuildFilter("모두", "all"),
            BuildFilter("무료", "free"),
            BuildFilter("버프", "buff"),
            BuildFilter("너프", "nerf"),
            BuildFilter("즐겨찾기", "free"),
        )
    )
    val commonItemFlow = _commonItemFlow.asStateFlow()

    private val _roleItemFlow = MutableStateFlow<List<BuildFilter>>(
        arrayListOf(
            BuildFilter("탑", "Top"),
            BuildFilter("미드", "Mid"),
            BuildFilter("마법사", "MarksMan"),
            BuildFilter("탱커", "MarksMan"),
            BuildFilter("원거리 딜러", "MarksMan"),
            BuildFilter("서포터", "Support"),
        )
    )

    val roleItemFlow: StateFlow<List<BuildFilter>> = _roleItemFlow

    private val _roleGroupItemFlow = MutableStateFlow<List<BuildFilter>>(
        mutableListOf(
            BuildFilter("암살자", "Top"),
            BuildFilter("전사", "Mid"),
            BuildFilter("마법사", "MarksMan"),
            BuildFilter("탱커", "MarksMan"),
            BuildFilter("원거리 딜러", "MarksMan"),
            BuildFilter("서포터", "Support"),
        )
    )

    val roleGroupItemFlow = _roleGroupItemFlow.asStateFlow()

    private val _locationItemFlow = MutableStateFlow<List<BuildFilter>>(
        arrayListOf(
            BuildFilter("준비", "준비중"),
        )
    )

    val locationItemFlow = _locationItemFlow.asStateFlow()

    val totalItem =
        arrayListOf(_commonItemFlow, _roleItemFlow, _roleGroupItemFlow, _locationItemFlow)

    fun getChampion() {
        viewModelScope.launch {
            buildRepository.getChampions(
                onSuccess = {

                },
                onError = {

                },
                onException = {

                }

            ).collect { Champion ->
                originalChampionList = Champion.data.values.toList()
                    .sortedBy { it.name }
                    .map { BuildItem(it) }

                _ChampionList.value = originalChampionList
            }
        }
    }

    fun changeColor(size: Int, buildFilter: BuildFilter?) = viewModelScope.launch {
        //안의 객체가 바뀌지않아서 emit을 해도 호출이 되지 않았던거야.
        // dont emit var, and easily not use to MutableList

//        val newObject = totalItem.get(size).value.find { it == buildFilter }?.run {
//            copy(selected = true)
//        }

        val newList = totalItem.get(size).value.toMutableList().also {
            it.reverse()
        }
        newList?.find { it == buildFilter }?.selected = true


//        totalItem.get(size).value.find { it == buildFilter }?.selected = true
//        ho = totalItem.get(size).value.find { it == buildFilter }
        totalItem.get(size).value = newList
//        Timber.d("해당 totalItem 값 $ho")


    }


    fun setSearchQuery(searchQuery: String) = viewModelScope.launch {
        _searchQuery.value = searchQuery
        _ChampionList.value = originalChampionList.filter { chapion ->
            chapion.dataNum.name.contains(_searchQuery.value.toString())
        }
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

