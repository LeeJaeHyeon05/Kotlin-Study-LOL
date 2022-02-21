package com.example.firstapp.fragment.build.detail.mybuild.detailmybuild

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import com.example.firstapp.model.MyBuild
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

@HiltViewModel
class DetailMyBuildViewModel @Inject constructor(
    private val myBuildRepository: MyBuildRepository
): ViewModel() {

    val list: LiveData<List<MyBuild>> by lazy {
        myBuildRepository.getListByChampionName("champion name")
    }

}