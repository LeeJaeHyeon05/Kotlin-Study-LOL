package com.example.firstapp.fragment.build.detail.mybuild.repository

import androidx.lifecycle.LiveData
import com.example.firstapp.database.dao.MyBuildDao
import com.example.firstapp.model.MyBuild
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MyBuildRepository(val myBuildDao: MyBuildDao) {

    suspend fun insert(newData: MyBuild) = withContext(Dispatchers.IO) {
        myBuildDao.insert(newData)
    }

     fun getListByChampionName(championName: String): LiveData<List<MyBuild>>  {
         return myBuildDao.getListByChampionName(championName)
    }

    suspend fun delete(id: Int) = withContext(Dispatchers.IO) {
        myBuildDao.delete(id)
    }

}