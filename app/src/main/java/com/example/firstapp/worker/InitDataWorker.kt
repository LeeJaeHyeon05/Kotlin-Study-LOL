package com.example.firstapp.worker

import android.content.Context
import androidx.hilt.work.HiltWorker
import androidx.work.CoroutineWorker
import androidx.work.WorkerParameters
import com.example.firstapp.database.dao.ChampionDao
import com.example.firstapp.database.dao.ItemDao
import com.example.firstapp.eventbus.EventBus
import com.example.firstapp.eventbus.InitDataEvent
import com.example.firstapp.model.Champion
import com.example.firstapp.model.ChampionAll
import com.example.firstapp.model.Item
import com.example.firstapp.model.ItemAll
import com.example.firstapp.util.getBaseImageUrl
import com.example.firstapp.util.getJsonDataFromAsset
import com.google.gson.Gson
import com.squareup.picasso.Callback
import com.squareup.picasso.Picasso
import dagger.assisted.Assisted
import dagger.assisted.AssistedInject
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch
import timber.log.Timber

@HiltWorker
class InitDataWorker @AssistedInject constructor(
    @Assisted appContext: Context,
    @Assisted workerParams: WorkerParameters,
    private val championDao: ChampionDao,
    private val itemDao: ItemDao,
) : CoroutineWorker(appContext, workerParams) {

    private var progress: Int = 0

    private suspend fun postMessage(message: String) {
        progress += 1
        EventBus.post(InitDataEvent(progress, message))
    }

    override suspend fun doWork(): Result {
        postMessage("doWork")

        initChampion()

        return Result.success()
    }

    private suspend fun initChampion() {
        postMessage("initChampion start")

        val championCount = championDao.selectAllCount()
        Timber.i("championCount : %d", championCount)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "champion.json")
        val championAll = Gson().fromJson(jsonFileString, ChampionAll::class.java)
        val champions: Map<String, Champion> = championAll.champions

        val championList = champions.map { it.value }
        if (championCount === 0) championDao.insertAll(championList)

        postMessage("insert champion finish")

        // for cache init
        championList.forEachIndexed { index, item ->
            Timber.i("${getBaseImageUrl()}/champion/${item.image.get("full").asString}")
            Picasso.get().load("${getBaseImageUrl()}/champion/${item.image.get("full").asString}")
                .fetch(object : Callback {
                    override fun onSuccess() {
                        CoroutineScope(Dispatchers.IO).launch { postMessage("${item.name} image cached") }
                        if (index === championList.size - 1) CoroutineScope(Dispatchers.IO).launch { initItem() }
                    }

                    override fun onError(e: Exception?) {
                        CoroutineScope(Dispatchers.IO).launch { postMessage("${item.name} image cache failed") }
                        if (index === championList.size - 1) CoroutineScope(Dispatchers.IO).launch { initItem() }
                    }
                })
        }
    }

    private suspend fun initItem() {
        postMessage("initItem start")

        val itemCount = itemDao.selectAllCount()
        Timber.i("itemCount : %d", itemCount)

        val jsonFileString = getJsonDataFromAsset(applicationContext, "item.json")
        val itemAll = Gson().fromJson(jsonFileString, ItemAll::class.java)
        val items: Map<String, Item> = itemAll.items

        for ((key, value) in items) value.id = key
        val itemList = items.map { it.value }
        if (itemCount === 0) itemDao.insertAll(itemList)

        postMessage("insert item finish")

        // for cache init
        itemList.forEachIndexed { index, item ->
            Picasso.get().load("${getBaseImageUrl()}/item/${item.id}.png").fetch(object : Callback {
                override fun onSuccess() {
                    CoroutineScope(Dispatchers.IO).launch { postMessage("${item.name} image cached") }
                    if (index === itemList.size - 1) CoroutineScope(Dispatchers.IO).launch { finishWork() }
                }

                override fun onError(e: Exception?) {
                    CoroutineScope(Dispatchers.IO).launch { postMessage("${item.name} image cache failed") }
                    if (index === itemList.size - 1) CoroutineScope(Dispatchers.IO).launch { finishWork() }
                }
            })
        }
    }

    private suspend fun finishWork() {
        EventBus.post(InitDataEvent(Int.MAX_VALUE, "doWork finish"))
    }
}