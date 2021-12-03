package com.example.firstapp.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.Worker
import androidx.work.WorkerParameters
import com.example.firstapp.database.dao.ChampionDao
import com.example.firstapp.database.dao.ItemDao
import com.example.firstapp.model.Champion
import com.example.firstapp.model.ChampionAll
import com.example.firstapp.model.Item
import com.example.firstapp.model.ItemAll
import com.example.firstapp.util.getBaseImageUrl
import com.example.firstapp.util.getJsonDataFromAsset
import com.google.gson.Gson
import com.squareup.picasso.Picasso
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import timber.log.Timber

@HiltWorker
class InitDataWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    val championDao: ChampionDao,
    val itemDao: ItemDao
) : Worker(appContext, workerParams) {

    override fun doWork(): Result {

        initChanmpion()
        initItem()

        return Result.success()
    }

    private fun initChanmpion() {
        val championCount = championDao.selectAllCount()
        Timber.i("championCount : %d", championCount)
        if (championCount > 0) return

        val jsonFileString = getJsonDataFromAsset(applicationContext, "champion.json")
        val championAll = Gson().fromJson(jsonFileString, ChampionAll::class.java)
        val champions: Map<String, Champion> = championAll.champions

        val championList = champions.map { it.value }
        championDao.insertAll(championList)
    }

    private fun initItem() {
        val itemCount = itemDao.selectAllCount()
        Timber.i("itemCount : %d", itemCount)
        if (itemCount > 0) return

        val jsonFileString = getJsonDataFromAsset(applicationContext, "item.json")
        val itemAll = Gson().fromJson(jsonFileString, ItemAll::class.java)
        val items: Map<String, Item> = itemAll.items

        for ((key, value) in items) value.id = key
        val itemList = items.map { it.value }
        itemDao.insertAll(itemList)

        // for cache init
        itemList.forEach {
            Picasso.get().load("${getBaseImageUrl()}/item/${it.id}.png").fetch()
        }
    }
}