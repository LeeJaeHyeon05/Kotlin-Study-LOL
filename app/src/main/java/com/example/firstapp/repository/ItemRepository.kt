package com.example.firstapp.repository

import com.example.firstapp.data.db.dao.ItemDao
import com.example.firstapp.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemRepository(var itemDao: com.example.firstapp.data.db.dao.ItemDao) {
    suspend fun getItems(): List<Item> = withContext(Dispatchers.IO) {
        return@withContext itemDao.selectAll()
    }
}