package com.example.firstapp.model

import android.util.Log
import android.widget.Toast
import androidx.lifecycle.LiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.liveData
import androidx.lifecycle.viewModelScope
import com.example.firstapp.data.repository.TierRepository
import com.example.firstapp.model.tier.TierLine
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class TierViewModel @Inject constructor(private val tierRepository: TierRepository)
    :ViewModel() {
        val tierDataList = liveData<TierLine>(Dispatchers.IO) {
            when(val response = tierRepository.execute()){
                is ApiResponse.Success ->{
                    emit(response.value)
                    Log.d("jsoup","Success: 뷰모델에서 티어 데이터 가져오기 완료")
                }
                is ApiResponse.Failure -> {
                    Timber.d("error: " + response.e)
                }
            }
        }
}