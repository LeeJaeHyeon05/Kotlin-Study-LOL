package com.example.firstapp.fragment.build.detail.mybuild.addmybuild

import android.widget.RadioButton
import android.widget.RadioGroup
import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel

class SkillBuildDialogViewModel : ViewModel() {

    private val _skillNum = MutableLiveData<Int>()
    val skillNum: LiveData<Int> get() = _skillNum

    fun changeSkillNum(num: Int){
        _skillNum.value = num
    }
}