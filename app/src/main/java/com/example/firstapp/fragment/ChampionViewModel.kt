package com.example.firstapp.fragment

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.firstapp.data.repository.ChampionRepository
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.champion.AatroxVO
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/13
 **/
@HiltViewModel
class ChampionViewModel @Inject constructor(
    val championRepository: ChampionRepository
) : ViewModel() {

    val champion: LiveData<AatroxVO> = liveData {
        with(championRepository.championInfo()) {
            when (this) {
                is ApiResponse.Success -> emit(value)
            }
        }
    }
}