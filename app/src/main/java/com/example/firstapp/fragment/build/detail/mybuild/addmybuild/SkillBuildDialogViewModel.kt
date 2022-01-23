package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class SkillBuildDialogViewModel : ViewModel() {

    private val _skillTree = MutableLiveData<MutableList<String>>()
    val skillTree: LiveData<MutableList<String>> get() = _skillTree

    private val _isSaved = MutableLiveData<Boolean>()
    val isSaved: LiveData<Boolean> get() = _isSaved

    fun changeSkillTree(index: Int, skill: String){
        val list = _skillTree.value

        //첫 스킬 추가 시
        if (list == null) {
            val newList = mutableListOf(skill)
            _skillTree.value = newList
            Timber.d("done new")
        }

        if(list != null) {
            //새로운 스킬 추가 시
            if(index == list.size){
                list.add(skill)
                _skillTree.value = list!!
            }
            //기존 스킬 변경 시
            else if(index < list.size) {
                list[index] = skill
                _skillTree.value = list!!
            }
        }
    }

    fun saveSkillTree(){
        _isSaved.value = true
    }

    fun editSkillTree(){
        _isSaved.value = false
    }
}