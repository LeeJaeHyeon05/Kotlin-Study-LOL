package com.example.firstapp.model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.*
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.firstapp.data.repository.TierRepository
import com.example.firstapp.database.AppDatabase
import com.example.firstapp.model.tier.TierChamp
import com.example.firstapp.model.tier.TierLine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TierViewModel @Inject constructor(private val tierRepository: TierRepository) :ViewModel() {
    val topTierData = MutableLiveData<ArrayList<TierChamp>?>()
    val jungleTierData = MutableLiveData<ArrayList<TierChamp>?>()
    val midTierData = MutableLiveData<ArrayList<TierChamp>?>()
    val adcTierData = MutableLiveData<ArrayList<TierChamp>?>()
    val supTierData = MutableLiveData<ArrayList<TierChamp>?>()

    // todo Room DB에서 tierData 가져와서 각각의 line TierData에 넣기
    val tierDataList = liveData<TierLine>(Dispatchers.IO) {
        when(val response = tierRepository.execute()){
            is ApiResponse.Success ->{
                topTierData.postValue(response.value!!.top)
                jungleTierData.postValue(response.value!!.jungle)
                midTierData.postValue(response.value!!.mid)
                adcTierData.postValue(response.value!!.adc)
                supTierData.postValue(response.value!!.sup)
            }
            is ApiResponse.Failure -> {
                Timber.d("error: " + response.e)
            }
        }
    }

}
