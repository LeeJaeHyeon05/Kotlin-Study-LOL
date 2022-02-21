package com.example.firstapp.database.dao

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.MyBuild

@Dao
interface MyBuildDao {

    @Query("SELECT * FROM mybuild")
    fun getAll(): LiveData<List<MyBuild>>

    @Query("SELECT * FROM mybuild WHERE champion = :champion")
    fun getListByChampionName(champion: String): LiveData<List<MyBuild>>

    @Insert
    fun insert(myBuild: MyBuild)

    @Query("DELETE FROM mybuild WHERE id = :id")
    fun delete(id: Int)
}