package com.example.firstapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.tier.TierChamp

@Dao
interface ChampionTierDao {
    @Query("SELECT * FROM championTier")
    fun selectAll(): List<TierChamp>

    @Query("SELECT count(*) FROM championTier")
    fun selectAllCount(): Int

    @Insert
    fun insertAll(items: ArrayList<TierChamp>)
}