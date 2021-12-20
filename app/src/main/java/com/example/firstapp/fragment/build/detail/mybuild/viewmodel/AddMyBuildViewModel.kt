package com.example.firstapp.fragment.build.detail.mybuild.viewmodel

import android.content.Context
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepositoryData
import dagger.hilt.android.qualifiers.ApplicationContext

class AddMyBuildViewModel: ViewModel() {

    private var _myBuildNameET = MutableLiveData<String>().apply {
        value = "test"
        //추후 챔피언 이름하고 이미 존재하는 빌드 갯수를 넘겨받아 "#1 Garen's builds" 처럼 초기화시킬 것
    }
    var myBuildNameET: MutableLiveData<String> = _myBuildNameET

    fun saveAddBuild(context: Context, data: MyBuildRepositoryData){
//        현재 페이지에 있는 정보 저장
//        -> 빌드 이름 String
//        -> 소환사 주문 Image 2개
//        -> 아이템 + 장신구 이미지 7개
//        -> 새로운 아이템 카테고리 RV
//        -> 스킬 순서
//        -> 룬
//        -> 빌드 노트

        val myBuildRepository= MyBuildRepository(context)
        myBuildRepository.addMyBuildData("Champion Name",data)
    }
}