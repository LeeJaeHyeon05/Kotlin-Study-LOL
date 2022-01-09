package com.example.firstapp.fragment.build.detail.mybuild.viewmodel

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepositoryData
import dagger.hilt.android.qualifiers.ApplicationContext

class AddMyBuildViewModel: ViewModel() {

    var myBuildNameET = MutableLiveData<String>("test")
    var myBuildNoteET = MutableLiveData<String>()

    fun saveAddBuild(context: Context, championName: String, data: MyBuildRepositoryData){
//        현재 페이지에 있는 정보 저장
//        -> 빌드 이름 String
//        -> 소환사 주문 Image 2개
//        -> 아이템 + 장신구 이미지 7개
//        -> 새로운 아이템 카테고리 RV
//        -> 스킬 순서
//        -> 룬
//        -> 빌드 노트

        val myBuildRepository= MyBuildRepository(context)
        myBuildRepository.addMyBuildData(championName,data)
    }
}