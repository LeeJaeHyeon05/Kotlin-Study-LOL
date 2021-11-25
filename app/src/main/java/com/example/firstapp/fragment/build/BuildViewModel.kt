package com.example.firstapp.fragment.build

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.data.repository.di.BuildRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.stateIn
import javax.inject.Inject

@HiltViewModel
class BuildViewModel @Inject constructor(
    private val buildRepository: BuildRepository,
) : ViewModel() {


    suspend fun getChampion() = buildRepository.getChampions(
        onSuccess = {

        },
        onError = {

        },
        onException = {

        }

    ).stateIn(viewModelScope)
}

