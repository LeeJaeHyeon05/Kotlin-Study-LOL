package com.example.firstapp.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.firstapp.R
import com.example.firstapp.database.dao.ItemDao
import com.example.firstapp.eventbus.EventBus
import com.example.firstapp.eventbus.InitDataEvent
import com.example.firstapp.model.Item
import com.example.firstapp.model.ItemAll
import com.example.firstapp.util.getBaseImageUrl
import com.example.firstapp.util.getJsonDataFromAsset
import com.google.gson.Gson
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class InitItemWorker @AssistedInject constructor(
        @Assisted appContext: Context,
        @Assisted workerParams: WorkerParameters,
        private val itemDao: ItemDao,
) : CoroutineWorker(appContext, workerParams) {

    private var cachedItemCount: Int = 0

    override suspend fun doWork(): Result {
        EventBus.post(InitDataEvent(40, applicationContext.getString(R.string.init_item_start)))

        val itemCount = itemDao.selectAllCount()
        Timber.i("itemCount : %d", itemCount)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "item.json")
        val itemAll = Gson().fromJson(jsonFileString, ItemAll::class.java)
        val items: Map<String, Item> = itemAll.items

        for ((key, value) in items) value.id = key
        val itemList = items.map { it.value }
        if (itemCount === 0) itemDao.insertAll(itemList)

        itemList.forEach { item ->
            Picasso.get().load("${getBaseImageUrl()}/item/${item.id}.png").fetch(object : Callback {
                override fun onSuccess() {
                    cachedItemCount++
                }

                override fun onError(e: Exception?) {
                    cachedItemCount++
                }
            })
        }

        while (itemList.size > cachedItemCount) {
            Thread.sleep(100)
        }

        return Result.success()
    }

}