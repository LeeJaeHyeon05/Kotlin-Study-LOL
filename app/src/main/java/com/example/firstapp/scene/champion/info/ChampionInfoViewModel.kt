package com.example.firstapp.scene.champion.info

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.firstapp.R
import com.example.firstapp.data.repository.ChampionRepository
import com.example.firstapp.databinding.FragmentChampionInfoBinding
import com.example.firstapp.databinding.FragmentChampionListBinding
import com.example.firstapp.model.ApiResponse
import com.example.firstapp.scene.champion.ChampionInfoVO
import com.xwray.groupie.GroupieAdapter
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