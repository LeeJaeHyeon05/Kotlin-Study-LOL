package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import android.content.Context
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import dagger.hilt.android.qualifiers.ApplicationContext
import javax.inject.Inject

@HiltViewModel
class AddMyBuildViewModel @Inject constructor(
    private val repository : MyBuildRepository
) : ViewModel() {

    var myBuildNameET = MutableLiveData<String>("test")
    var myBuildNoteET = MutableLiveData<String>()

    fun saveAddBuild(championName: String) {
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