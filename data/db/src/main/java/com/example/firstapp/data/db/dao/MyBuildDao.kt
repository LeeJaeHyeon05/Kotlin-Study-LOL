package com.example.firstapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.MyBuild

@Dao
interface MyBuildDao {
    @Query("SELECT * FROM mybuild")
    fun selectAll(): List<MyBuild>

    @Query("SELECT * FROM mybuild WHERE champion = :champion ORDER BY id ASC")
    fun selectByChampionName(champion: String): List<MyBuild>

    @Insert
    fun insert(myBuild: MyBuild)

    @Query("DELETE FROM mybuild WHERE id = :id")
    fun delete(id: Int)
}