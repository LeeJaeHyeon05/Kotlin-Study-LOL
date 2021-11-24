package com.example.firstapp.repository

import com.example.firstapp.database.dao.ItemDao
import com.example.firstapp.model.Data
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemRepository(var itemDao: ItemDao) {
    suspend fun getItems(): List<Data> = withContext(Dispatchers.IO) {
        return@withContext itemDao.selectAll()
    }
}