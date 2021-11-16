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
class ChampionViewModel @Inject constructor(
    val repository: ChampionRepository,
) : ViewModel() {

    private val _champions: LiveData<List<ChampionInfoVO>> = liveData {
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
    val champions: LiveData<List<ChampionInfoVO>> = _champions

    fun dummy() {
//        viewModelScope.launch(Dispatchers.IO) {
//            repository.championInfo()
//        }
//        champions.value?.let { arr ->
//            // todo 다음 커밋에는 홍식님이 만드신 에셋 매니저 사용 하도록 수정 예정
//            arr.add(ChampionInfoVO())
//            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
//            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
//            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
//            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
//            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
//            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
//            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
//        }
    }

}