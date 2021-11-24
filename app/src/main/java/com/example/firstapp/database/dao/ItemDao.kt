package com.example.firstapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.Items

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun selectAll(): List<Items>

    @Query("SELECT count(*) FROM item")
    fun selectAllCount(): Int

    @Insert
    fun insertAll(vararg items: Items)
}