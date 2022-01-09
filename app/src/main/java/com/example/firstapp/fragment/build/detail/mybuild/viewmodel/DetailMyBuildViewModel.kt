package com.example.firstapp.fragment.build.detail.mybuild.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.fragment.build.detail.mybuild.DetailMyBuildFragment
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepositoryData
import dagger.hilt.android.qualifiers.ApplicationContext

class DetailMyBuildViewModel: ViewModel() {

    private var _myBuildDataList = MutableLiveData<MutableList<MyBuildRepositoryData>>()
    val myBuildDataList : LiveData<MutableList<MyBuildRepositoryData>> = _myBuildDataList

    fun getMyBuildData(context: Context, championName: String){

        val myBuildRepository= MyBuildRepository(context)
        _myBuildDataList.value = myBuildRepository.getMyBuildData(championName)
    }
}  