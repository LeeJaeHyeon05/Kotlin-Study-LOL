package com.example.firstapp.fragment.build.detail.mybuild.viewmodel

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.fragment.build.detail.mybuild.repository.DataForMyBuildRepository
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository

class AddMyBuildViewModel: ViewModel() {

    private var _myBuildNameET = MutableLiveData<String>().apply {
        value = "test"
    }
    var myBuildNameET: LiveData<String> = _myBuildNameET

    fun saveAddBuild(data: DataForMyBuildRepository){
//        현재 페이지에 있는 정보 저장
//        -> 빌드 이름 String
//        -> 소환사 주문 Image 2개
//        -> 아이템 + 장신구 이미지 7개
//        -> 새로운 아이템 카테고리 RV
//        -> 스킬 순서
//        -> 룬
//        -> 빌드 노트
    }
}