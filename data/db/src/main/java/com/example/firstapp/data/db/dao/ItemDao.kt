package com.example.firstapp.data.db.dao

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.Query
import com.example.firstapp.model.Item

@Dao
interface ItemDao {
    @Query("SELECT * FROM item")
    fun selectAll(): List<Item>

    @Query("SELECT count(*) FROM item")
    fun selectAllCount(): Int

    @Insert()
    fun insertAll(items: Iterable<Item>)
}