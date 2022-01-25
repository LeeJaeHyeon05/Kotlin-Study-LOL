package com.example.firstapp.fragment.build.detail.mybuild.repository

import com.example.firstapp.database.dao.MyBuildDao
import com.example.firstapp.model.MyBuild
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyBuildRepository(val myBuildDao: MyBuildDao) {
    suspend fun getAll(): List<MyBuild> = withContext(Dispatchers.IO){
        return@withContext myBuildDao.selectAll()
    }

    suspend fun insert(newData: MyBuild) = withContext(Dispatchers.IO) {
        myBuildDao.insert(newData)
    }

    suspend fun getListByChampionName(championName: String): List<MyBuild> = withContext(Dispatchers.IO) {
        return@withContext myBuildDao.selectByChampionName(championName)
    }
}