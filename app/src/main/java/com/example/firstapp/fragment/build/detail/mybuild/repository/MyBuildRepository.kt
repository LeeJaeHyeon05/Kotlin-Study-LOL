package com.example.firstapp.fragment.build.detail.mybuild.repository

import android.content.Context
import com.example.firstapp.database.dao.MyBuildDao
import com.example.firstapp.model.Item
import com.example.firstapp.model.MyBuild
import com.google.gson.Gson
import dagger.hilt.android.qualifiers.ApplicationContext
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyBuildRepository(val myBuildDao: MyBuildDao) {
    suspend fun getAll(): List<MyBuild> = withContext(Dispatchers.IO){
        return@withContext myBuildDao.selectAll()
    }

    suspend fun insert(newData: MyBuild) = withContext(Dispatchers.IO) {
        myBuildDao.insert(newData)
    }
}