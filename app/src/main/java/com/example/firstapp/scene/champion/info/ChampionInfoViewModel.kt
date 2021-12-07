package com.example.firstapp.scene.champion.info

import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import com.example.firstapp.data.repository.ChampionRepository
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.model.champion.Champion
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

    val champions: LiveData<List<Champion>> = liveData {
        with(repository.championInfo()) {
            when (this) {
                is ApiResponse.Success -> {
                    value.data.toSortedMap().map {
                        //"http://ddragon.leagueoflegends.com/cdn/11.23.1/img/champion/"
                        it.value
                    }.run {
                        emit(this)
                    }
                }
                is ApiResponse.Failure -> {

                }
                else -> {
                }
            }
        }
    }
}