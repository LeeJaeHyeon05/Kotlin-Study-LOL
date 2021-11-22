package com.example.firstapp.scene.champion

import androidx.lifecycle.*
import com.example.firstapp.data.repository.ChampionRepository
import com.example.firstapp.model.ApiResponse
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/10
 **/
@HiltViewModel
class ChampionListViewModel @Inject constructor(
    val repository: ChampionRepository,
) : ViewModel() {

    val champions: LiveData<List<ChampionInfoVO>> = liveData {
        with(repository.championInfo()) {
            when (this) {
                is ApiResponse.Success -> {
                    value.data.toSortedMap().map {
                        ChampionInfoVO(
                            name = it.value.name,
                            script = it.value.title,
                            imgUrl = "http://ddragon.leagueoflegends.com/cdn/11.22.1/img/champion/" + it.value.image.full
                        )
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