package com.example.firstapp.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.firstapp.database.dao.ItemDao
import com.example.firstapp.model.ItemAll
import com.example.firstapp.model.Items
import com.example.firstapp.util.getJsonDataFromAsset
import com.google.gson.Gson
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject

@HiltWorker
class InitDataWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    val itemDao: ItemDao
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {

        initItem()

        return Result.success()
    }

    private fun initItem() {
        val itemCount = itemDao.selectAllCount()
        if (itemCount > 0) return

        // item
        val jsonFileString = getJsonDataFromAsset(applicationContext, "item.json")
        val itemAll = Gson().fromJson(jsonFileString, ItemAll::class.java)
        val items: Map<String, Items> = itemAll.items

        for ((key, value) in items) value.id = key
        val itemList = items.map { it.value }
        itemList.forEach { item -> itemDao.insertAll(item) }
    }
}