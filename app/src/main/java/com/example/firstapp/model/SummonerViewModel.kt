package com.example.firstapp.model

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.data.repository.SummonerRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import javax.inject.Inject

@HiltViewModel
class SummonerViewModel @Inject constructor(private val summonerRepository: SummonerRepository) :ViewModel(){

}