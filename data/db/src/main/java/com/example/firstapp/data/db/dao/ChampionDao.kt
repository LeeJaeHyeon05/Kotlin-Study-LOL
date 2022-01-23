package com.example.firstapp.data.db.dao

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

    // 인수 chapID(챔피언 영문명)을 넣으면 한글명을 반환해준다
    @Query("SELECT name FROM champion WHERE `id` = :chapID")
    fun getChampKrName(chapID: String): String

    // 인수 chapID(챔피언 한글명)을 넣으면 영문명을 반환해준다
    @Query("SELECT `id` FROM champion WHERE name = :chapID")
    fun getChampEnName(chapID: String): String
}