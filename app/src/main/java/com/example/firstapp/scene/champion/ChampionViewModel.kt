package com.example.firstapp.scene.champion

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

/**
 * @author hanago
 * @email kottodat@naver.com
 * @since 2021/11/10
 **/
class ChampionViewModel : ViewModel() {

    private val _champions: MutableLiveData<ArrayList<ChampionInfoVO>> =
        MutableLiveData(ArrayList())
    val champions: LiveData<ArrayList<ChampionInfoVO>> = _champions

    fun dummy() {
        champions.value?.let { arr ->
            // todo 다음 커밋에는 홍식님이 만드신 에셋 매니저 사용 하도록 수정 예정
            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
            arr.add(ChampionInfoVO("가렌", "데마시아의 힘", ""))
        }
    }

}