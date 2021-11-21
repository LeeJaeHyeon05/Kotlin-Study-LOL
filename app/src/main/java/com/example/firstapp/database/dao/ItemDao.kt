package com.example.firstapp.database.dao

import androidx.room.Dao
import androidx.room.Insert
import com.example.firstapp.model.Data

@Dao
interface ItemDao {
    @Insert
    fun insertAll(vararg items: Data)
}