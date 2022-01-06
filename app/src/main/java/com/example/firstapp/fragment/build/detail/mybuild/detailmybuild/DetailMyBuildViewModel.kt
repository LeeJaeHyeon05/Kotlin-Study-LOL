package com.example.firstapp.fragment.build.detail.mybuild.detailmybuild

import androidx.lifecycle.ViewModel
import com.example.firstapp.fragment.build.detail.mybuild.repository.MyBuildRepository
import javax.inject.Inject

class DetailMyBuildViewModel @Inject constructor(
    private val myBuildRepository: MyBuildRepository
): ViewModel() {

    fun loadRecyclerView(){

    }

//    private var _myBuildDataList = MutableLiveData<MutableList<MyBuildRepositoryData>>()
//    val myBuildDataList : LiveData<MutableList<MyBuildRepositoryData>> = _myBuildDataList
//
//    fun getMyBuildData(context: Context, championName: String){
//
//        val myBuildRepository= MyBuildRepository(context)
//        _myBuildDataList.value = myBuildRepository.getMyBuildData(championName)

}  