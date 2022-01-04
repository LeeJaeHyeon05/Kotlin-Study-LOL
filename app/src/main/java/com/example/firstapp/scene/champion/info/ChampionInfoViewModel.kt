package com.example.firstapp.scene.champion.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.SavedStateHandle
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.firstapp.data.repository.ChampionRepository
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.champion.Champion
import dagger.assisted.Assisted
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/21
 **/
@HiltViewModel
class ChampionInfoViewModel  @Inject constructor(
    val repository: ChampionRepository,
) : ViewModel() {

    val champions: LiveData<Map<String,Champion>> = liveData {
        with(repository.championInfo()) {
            when (this) {
                is ApiResponse.Success -> {
                    emit(value.data)
                }
                is ApiResponse.Failure -> {

                }
                else -> {
                }
            }
        }
    }
}