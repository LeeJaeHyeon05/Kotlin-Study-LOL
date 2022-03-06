package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import timber.log.Timber

class SkillBuildDialogViewModel : ViewModel() {

    private val _skillTree = MutableLiveData<MutableList<String>?>()
    val skillTree: LiveData<MutableList<String>?> get() = _skillTree

    private val _skillTreeDisplay = MutableLiveData<MutableList<String>>()
    val skillTreeDisplay: LiveData<MutableList<String>> get() = _skillTreeDisplay

    fun changeSkillTree(index: Int, skill: String){
        val list = _skillTree.value

        //첫 스킬 추가 시
        if (list == null) {
            val newList = mutableListOf(skill)
            _skillTree.value = newList
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

    fun removeSkillTree(){
        _skillTree.value = null
    }

    fun getSkillTree(){
        _skillTree.value = _skillTreeDisplay.value
    }

    fun saveSkillTree(){
        _skillTreeDisplay.value = _skillTree.value
    }

}