package com.example.firstapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.Summoner

@Dao
interface SummonerDao {
    @Query("SELECT * FROM summoner")
    fun selectAll(): List<Summoner>

    @Query("SELECT count(*) FROM summoner")
    fun selectAllCount(): Int

    @Insert
    fun insertAll(summoners: Iterable<Summoner>)
}