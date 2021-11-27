package com.example.firstapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.Champion

@Dao
interface ChampionDao {
    @Query("SELECT * FROM champion")
    fun selectAll(): List<Champion>

    @Query("SELECT count(*) FROM champion")
    fun selectAllCount(): Int

    @Insert
    fun insertAll(champions: Iterable<Champion>)
}