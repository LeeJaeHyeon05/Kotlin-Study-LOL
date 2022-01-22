package com.example.firstapp.data.repository

import com.example.firstapp.data.db.dao.ItemDao
import com.example.firstapp.model.Item
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class ItemRepository(var itemDao: ItemDao) {
    suspend fun getItems(): List<Item> = withContext(Dispatchers.IO) {
        return@withContext itemDao.selectAll()
    }
}