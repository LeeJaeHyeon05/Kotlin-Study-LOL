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
import javax.inject.Inject

@HiltViewModel
class TierViewModel @Inject constructor(private val tierRepository: TierRepository)
    :ViewModel() {
        val tierDataList = liveData<TierLine>(Dispatchers.IO) {
            when(val response = tierRepository.execute()){
                is ApiResponse.Success ->{
                    // todo 받아온 데이터를 각각의 fragment에 뿌리기
                    emit(response.value)
                }
                is ApiResponse.Failure -> {
                    Log.d("jsoup", "error: ${response.e}")
                }
            }
        }
}